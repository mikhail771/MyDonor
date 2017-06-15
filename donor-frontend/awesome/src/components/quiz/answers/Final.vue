<template>
	<div class="app">
		<div class="image"></div>
		<div class="title">Поздравляем! Вы можете быть донором крови.</div>
<div class="controls">
<button ><router-link to="/contraindications">Узнать больше</router-link></button>	<button @click="freshStart">Обновить данные</button>
</div>

	</div>
</template>

<script>
import { store } from "../../../store/store.js"
	export default{
		
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
	.image{
		width:200px;
		height:200px;
		margin:30px auto;
		background-image: url("~../../assets/hearts.svg");
		background-repeat: no-repeat, no-repeat;
		background-size: auto;
		background-position: 50% 50%;
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