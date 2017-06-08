<template>
	<div>
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
	body{
	background-color: red;
	font-size:24px;
	color:#5b2b19;
}

button{
	border:none;
}

.name{
	display:flex;
	align-items: center;
	/*width:100%;*/
	transform:translate(0,0);
	height:45px;
	padding-left:15px;
	margin-bottom:15px;
	background-color: rgba(20,133,204,0.4);
	border-bottom: 1px solid rgba(0,0,0,0.2);
}

.post{
	width:90%;
	margin:0 auto;
	text-align:justify;
	/*padding:20px;*/
	margin-bottom:10px;
	background-color: rgba(138,7,7,0.4);
	transition:all 0.7s;
	position:relative;
	padding-bottom:10px;
	border: 1px solid rgba(0,0,0,0.2);

}

.post:hover{
	transform:scale(1.04,1.04);
	box-shadow:0 0 12px 2px rgba(80,80,80,0.6);
}


.post div{
	padding-left:45px;
}

.post div:nth-of-type(1){
	font-style: italic;
	padding:0;
	color:#f7eee7;
}

.post-title{
	font-weight:bold;
}

.details, .back{
	display:block;
	width:190px;
	padding:8px;
	text-align:center;
	border-radius:4px;
	background-color: rgba(80,171,204,0.4);
	color:#f7eee7;
	font-size: 18px;
	text-decoration:none;
	margin-top:10px;
	transform:translate(245%, -30%);
	/*box-shadow: 0 0 15px 1px rgba(80,80,80,0.2),inset 0 0 17px 4px rgba(215,190,169,0.9) ;*/
}

.back{
	width:190px;
	transform:translateX(225%);
}

.show{
	display:block;
}

.load{
	display:flex;
	width:100%;
	justify-content:center;
}

.noload{
	display:none;
}

@media only screen and (min-width: 600px){
	.post{
		width:700px;
	}
}
</style>