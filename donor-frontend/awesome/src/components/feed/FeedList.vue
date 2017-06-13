<template>
	<div class="list">
  <app-search class="test"></app-search>
		<feed-item v-for="elem in store" :elem="elem"> </feed-item>
		<mugen-scroll :handler="retData" :should-handle="!loading">
      <span  :class="{load:true, noload:hiddenLoad}">загрузка...</span>
      <span  :class="{load:true, noload:!hiddenLoad}">заявок больше нет...</span>
    </mugen-scroll>
	</div>
</template>

<script>
	import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import FeedItem from './FeedItem.vue'
import MugenScroll from 'vue-mugen-scroll'
import search from "../Maps/SearchMap.vue"

Vue.use(VueAxios, axios)
export default {
 	data: function(){
  return{
     store:[],
    currentItem: '',
    container: document.querySelector(".container"),
    counter: 0,
    loading:false,
    hiddenLoad:false


  }
 },
 components:{
 	'feed-item': FeedItem,
  'app-search': search,
 	MugenScroll
 },
  methods:{
   retData: function(){
   	this.loading = true;
      const api = 'https://dry-island-77618.herokuapp.com/bids?decimalcount=' + this.counter
      Vue.axios.get(api).then(response=> {
      	if(response.data.length == 0){
      		this.loading = false;
      		this.hiddenLoad = true;
      	} else{
      		if(this.store.length == 0){
      		this.store = response.data;
      		this.counter++;
      	} else{
      		// this.store = response.data;
      		this.counter++;
      		for(var i =0; i<response.data.length;i++){
      			this.store.push(response.data[i]);
      		}
      	}
      }
      	

      }).catch(error=>{
        console.log('error')
        this.store = []
      })
     this.loading = false;
    },
    select: function(index) {
        this.currentItem = this.store[index];
        console.log(this.currentItem); 
    }
 } 
}
</script>

<style lang="scss" scoped>
	.list{
    background-color: #0065BD;
    padding-top:5px;
    margin:0 auto;
  }
.show{
	display:block;
}

.load{
	display:flex;
	width:100%;
	justify-content:center;
  color:white;
  padding:7px;
}

.noload{
	display:none;
}


.test{
  box-sizing:border-box;
  padding:20px;
}
@media only screen and (min-width: 600px){
	.post{
		width:700px;
	}
}
</style>