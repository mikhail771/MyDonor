<template>
<div class="app">
<app-search class="searching"></app-search>
<div class="tabs__container">
<div class="tabs">
	<div :class="{feed:true, selectedTab:tabs[0].tab.activated}" @click="setTab(0)"><i class="fa fa-id-card" aria-hidden="true"></i></div> <div :class="{stories:true, selectedTab:tabs[1].tab.activated}" @click="setTab(1)"><i class="fa fa-bullhorn" aria-hidden="true"></i></div> <div :class="{stories:true, selectedTab:tabs[2].tab.activated}" @click="setTab(2)"><i class="fa fa-medkit" aria-hidden="true"></i>
</div>
</div>
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
import search from "../Maps/SearchMap.vue"

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
				activated:true,
				index:0}
			}, {tab:{
				element: "stories",
				activated: false,
				index:1}
			},
			{tab:{
				element: "request",
				activated:false,
				index:2}
			}],
			currentIndex:0,

		}
	},
 components:{
  'feedList': FeedList,
  'stories': stories,
  'request':request,
    'app-search': search,


 },
 computed: {
 	currentTab: function(){
 		return this.tabs[this.currentIndex].tab.element	
 	}
 },
 methods:{
 	setTab:function(e){
 		this.currentTab = this.tabs[e].tab.element;
 		for(var i =0; i<this.tabs.length; i++){
 			this.tabs[i].tab.activated = false;
 		}
 		this.tabs[e].tab.activated = !this.tabs[e].tab.activated;
 		this.currentIndex = this.tabs[e].tab.index
 		
 	},
 	toLeft: function(){
 		if(this.currentIndex <2){
 			this.currentIndex++;
 		}
 		
 		for(var i =0; i<this.tabs.length; i++){
 			this.tabs[i].tab.activated = false;
 		}
 		this.tabs[this.currentIndex].tab.activated = true
 	},
 	toRight: function(){
 		if(this.currentIndex > 0){
 			this.currentIndex--;
 		}
 		
 		for(var i =0; i<this.tabs.length; i++){
 			this.tabs[i].tab.activated = false;
 		}
 		this.tabs[this.currentIndex].tab.activated = true
 
 	}
 }
 
}
</script>

<style lang="scss" scoped>

.app{
	overflow: hidden;
	background-image: url("~../assets/background.jpg");
  background-size: auto;
  background-repeat:repeat;
  padding-top:25px;
}
.searching{
	width:85%;
	margin:0 auto;
}

.tabs__container{
	width:100%;
	height:40px;
	background-color: #0065bd;
	display:flex;
	justify-content:center;
	position:relative;
	     background-image: url("~../assets/background.jpg");
  background-size: auto;
  background-repeat:repeat;
  padding-top:20px;
}

.tabs{
	width:100%;
	height:40px;
	background-color: #0065bd;
	display:flex;
	justify-content:center;
	position:relative;
	     background-image: url("~../assets/background.jpg");
  background-size: auto;
  background-repeat:repeat;
  padding-bottom:0px;
	div{
		display:flex;
		align-items:center;
		justify-content:center;
		text-align: center;
		padding:0 20px;
		height:100%;
		color:white;
		font-size: 28px;
		box-sizing:border-box;
		width:33%;
	}
}

.selectedTab{
	border-bottom:2px solid white;
}

@media only screen and (min-width: 600px){
  .tabs, .searching{
    width:700px;
  }
}
</style>
