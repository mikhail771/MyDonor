<template>
<div class="app">
<div class="tabs">
	<div :class="{feed:true, selectedTab:tabs[0].tab.activated}" @click="setTab(0)">ЗАЯВКИ</div> <div :class="{stories:true, selectedTab:tabs[1].tab.activated}" @click="setTab(1)">ИСТОРИИ</div> <div :class="{stories:true, selectedTab:tabs[2].tab.activated}" @click="setTab(2)">ПОДАТЬ ЗАЯВКУ</div>
</div>

<v-touch v-on:swipeleft="toLeft" v-on:swiperight="toRight">
	<component :is="currentTab">
	</component>
</v-touch>
</div>
 
</template>

<script>

import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import FeedList from './FeedList.vue'
import stories from '../stories/FeedList.vue'
import request from '../request/App.vue'

import {store} from "../../store/store.js"

Vue.use(VueAxios, axios)
var VueTouch = require('vue-touch')
Vue.use(VueTouch, {name: 'v-touch'})

VueTouch.config.swipe = {
  direction: 'horizontal'
}
export default {
	data: function(){
		return{
			tabs: [{tab:{
				element: "feedList",
				activated:true}
			}, {tab:{
				element: "stories",
				activated: false}
			},
			{tab:{
				element: "request",
				activated:false}
			}],
			currentTab: "feedList",

		}
	},
 components:{
  'feedList': FeedList,
  'stories': stories,
  'request':request

 },
 methods:{
 	setTab:function(e){
 		this.currentTab = this.tabs[e].tab.element;
 		for(var i =0; i<this.tabs.length; i++){
 			this.tabs[i].tab.activated = false;
 		}
 		this.tabs[e].tab.activated = !this.tabs[e].tab.activated;
 		
 	},
 	toLeft: function(){
 		this.currentTab="stories";
 		this.tabs[0].tab.activated = false
 		this.tabs[1].tab.activated = true
 	},
 	toRight: function(){
 		this.currentTab="feedList";
 		this.tabs[0].tab.activated = true
 		this.tabs[1].tab.activated = false
 	}
 }
 
}
</script>

<style lang="scss" scoped>
.app{
	overflow: hidden;
}

.tabs{
	width:100%;
	height:40px;
	background-color: #0065bd;
	display:flex;
	justify-content:center;
	position:relative;
	div{
		display:flex;
		align-items:center;
		justify-content:center;
		padding:0 20px;
		margin: 0 35px;
		height:100%;
		color:white;
	}
}

.selectedTab{
	border-bottom:2px solid white;
}
</style>
