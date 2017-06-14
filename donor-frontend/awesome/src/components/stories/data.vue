<template>
	<div class="list">
	<feed-item> </feed-item>		
			
	</div>

</template>

<script>
import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'


Vue.use(VueAxios, axios)
import FeedItem from './FeedItem.vue'
export default {
 	data: function(){
  return{
    store:[]
  }
 },
 methods:{
   retData: function(){
      const api = 'https://dry-island-77618.herokuapp.com/bids'
      Vue.axios.get(api).then(response=> {
        this.store = response.data
        console.log(this.store);
      }).catch(error=>{
        console.log('error')
        this.store = []
      })
    }
 },
  beforeMount(){
    this.retData()
  } 
}
</script>

<style lang="scss" scoped>
	
</style>