<template>
	<div class="app">
		<img class="image" :src="image"></img>
		<div class="count">Вопрос {{counter}} из 8</div>
		<div class="title">{{title}}</div>
<div class="controls">
	<button @click="next">Да</button> 	<button @click="failed">Нет</button>
</div>

	</div>
</template>

<script>

import { store } from "../../../store/store.js"
	export default{
		
		computed:{
			counter: function(){
				return store.state.quizCounter
			},
			title: function(){
				return store.state.quiz[this.counter].title
			},
			image: function(){
				return store.state.quiz[this.counter].image
			}
		},
		methods:{
			next: function(){
				if(this.counter<3){
				store.commit("cNext");
			} else {
				store.commit("answer");
			}
			},
			failed: function(){
				if(this.counter<3){
				store.commit("answer");
			}else if(this.counter< 8){
				store.commit("cNext");
			} else{
				store.commit("final");
			}
			}
		}

			
	}
</script>

<style lang="scss" scoped>
.app{
	min-height:460px;
	height:90vh;
	position:relative;
	box-sizing:border-box;
	overflow: hidden;
}
	.image{
		width:200px;
		height:200px;
		margin:30px auto;
		border-radius: 50%;
		display:block;
		background-repeat: no-repeat;
		background-size: auto;
		background-position: 50% 50%;
	}

	.count{
		width:100%;
		padding:10px;
		color:grey;
		font-size: 14px;
	}
	.title{
		width:90%;
		display:flex;
		flex-wrap:wrap;
		padding:10px;
		font-size:18px;
		color:#DB3328;
	}

	button{
		width:45%;
		background-color:white;
		color:#DB3328;
		margin: 0 auto;
		border:1px solid #DB3328;
		padding:10px;
		border-radius: 4px;
		&:active{
			background-color: #DB3328;
			color:white;
		}
	}

.controls{
	width:100%;
	display:flex;
	justify-content:space-around;
	position:absolute;
	bottom:38px;
}
</style>