<template>
	<div class="app">
		<div class="caption">Узнайте, где вы можете сдать кровь</div>
		<form class="input"> <input type="text" placeholder="Введите ваш город, улицу, дом" v-model="place"> <router-link to="/search"><button class="search" @click="getPlace"></button></router-link></form>
	</div>
</template>

<script>
import {store} from "../../store/store.js"
	export default{
		data:function(){
			return{
				place:""
			}
		},
		methods:{
			getPlace: function(){
				this.place = this.place.split(" ").join("+");
				store.state.place = this.place;
				console.log(store.state.place);
				store.state.link = "https://www.google.com/maps/embed/v1/search?q=станция+переливания+крови+возле+" + this.place + "&key=AIzaSyAO0Ju6FOiKKWYpbv-CDHJ9aq9Ff4NOy9g"
				console.log(store.state.link);
			}
		}
	}
</script>

<style lang="scss" scoped>
	.app{
		width:100%;
		background-color: transparent;
		display:flex;
		flex-wrap:wrap;
		justify-content:center;
	}
	.caption{
		color:white;
		width:100%;
		font-size: 16px;
		text-align:center;
	}
	.input{
		width:100%;
		position:relative;
		z-index:1;
		margin-top:12px;
	}
	input{
		width:100%;
		position: relative;
		z-index:2;
		border:none;
		padding:10px 5px;
		color:grey;
		outline:none;
		border-radius: 5px;
		font-size: 12px;
	}

	.search{
		position: absolute;
		right: -10px;
		top:0;
		z-index:100;
		height:100%;
		width:60px;
		border:none;
		background-color: #DB3328;
		border-top-right-radius:5px;
		border-bottom-right-radius: 5px;
		background-image: url("~../assets/search.png");
		background-size: 37%;
		background-repeat: no-repeat;
		background-position: 50% 50%;
	}
</style>