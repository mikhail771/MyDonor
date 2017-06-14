<template>
<div class="app">
	<feed-list> </feed-list>
</div>
 
</template>

<script>

import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import FeedList from './FeedList.vue'

Vue.use(VueAxios, axios)
export default {
 components:{
  'feed-list': FeedList
 }
 
}
</script>

<style lang="scss" scoped>
.app{
	overflow: hidden;
}
</style>
