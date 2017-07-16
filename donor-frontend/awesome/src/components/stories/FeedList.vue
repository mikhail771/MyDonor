<template>
  <div class="list">
  <div class="mainTitle">Удивительные истории</div>
  <!-- <app-search class="test"></app-search> -->
    <feed-item v-for="n in 2"> </feed-item>
    <mugen-scroll :handler="retData" :should-handle="!loading">
      <div  :class="{load:true, noload:hiddenLoad}"></div>
       <span  :class="{end:true, noload:!hiddenLoad}">заявок больше нет...</span>
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
import { store } from "../../store/store.js"
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
      const api = store.state.baseRequestUrl + 'bids?decimalcount=' + this.counter
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
    background-image: url("~../assets/background.jpg");
    background-size: auto;
    background-repeat:repeat;
  }

    .mainTitle{
    width:100%;
    height:30px;
    background-color: transparent;
    padding:20px 0 0 0;
    font-size: 20px;
  color:white;
  font-family: 'Yeseva One', cursive;
  display:flex;
  justify-content:center;

  }
.show{
  display:block;
}

.load{
  width:70px;
  height:70px;
  margin: 0 auto;
  background-image: url("~../assets/refresh.png");
  background-size: 40%;
  background-repeat: no-repeat;
  background-position: 50% 50%;
  animation: spinIt 1.5s infinite linear;
}

.end{
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


@keyframes spinIt {
  0%   { transform: rotate(0deg); }
  100% { transform: rotate(359deg); }
}
@media only screen and (min-width: 600px){
  .post{
    width:700px;
  }
}
</style>