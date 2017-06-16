<template>
	<div class="app">
	<div class="img-container">
		<img class="image" :src="image"> <div class="warning"></div>
		</div>
		
		<div class="title">{{title}}</div>
<div class="controls">
<button ><router-link to="/contraindications">Узнать больше</router-link></button>	<button @click="freshStart">Обновить данные</button>
</div>

	</div>
</template>

<script>
import { store } from "../../../store/store.js"
	export default{
		computed:{
			title: function(){
				return store.state.quiz[this.counter].answer.title
			},
			image: function(){
				return store.state.quiz[this.counter].image
			},
			counter:function(){
				return store.state.quizCounter
			}
		},
		methods:{
			freshStart: function(){
				store.commit("refresh");
			}
		}

			
	}
</script>

<style lang="scss" scoped>
a{
	text-decoration:none;
	color:#DB3328;
}
.app{
	min-height:510px;
	height:90vh;
	position:relative;
	box-sizing:border-box;
	overflow: hidden;
}
.img-container{
	width:200px;
		height:200px;
		position:relative;
		margin:30px auto;
}
	.image{
		display:block;
		width:200px;
		height:200px;
		position:absolute;
		z-index:1;
		background-repeat: no-repeat, no-repeat;
		background-size: 50%, 80%;
		background-position: 110% 0, 50% 50%;
	}

	.warning{
		position:absolute;
		right:-20px;
		z-index:2;
		width:85px;
		height:85px;
		background-image: url("~../../assets/error.svg");
		background-size: auto;
		background-repeat: no-repeat;
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
		color:black;
		font-weight: bold;
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