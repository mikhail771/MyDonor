<template>
	<div class="app">
		<app-search></app-search>
		<div class="title">Свяжитесь с нами</div>
		<div class="mail">Email: <a href="mailto:DonorDnepr@gmail.com">DonorDnepr@gmail.com</a></div>
		<div class="socials">или через <div class="soc-labels"><div class="facebook"></div> <div class="vk"></div></div></div>
		<hr/>
		<div class="year">2017</div>
		
	</div>
</template>

<script>
import search from "../Maps/SearchMap.vue"
	export default{
		components:{
			'app-search': search
		}

	}
</script>

<style lang="scss" scoped>
	.app{
		width:100%;
		background-color: #454647;
		margin:0;
		padding:16px 16px 10px 16px;
		box-sizing:border-box;
	}

hr{
	margin: 0 auto;
	height:1px;
	border:none;
	background-color: #95989A;
	color:white;
}

div{
	color:white;
}
a{
	color:white;
	text-decoration: none;
	font-style:italic;
}

.title{
	font-size: 16px;
	padding-left:10px;
	padding-bottom:10px;
}

.mail, .socials{
	font-size: 12px;
	padding-left:10px;
	padding-bottom:10px;
}
.socials{
	display:flex;
	width:140px;
	justify-content:space-between;
	align-items:center;
}

.soc-labels{
	display:flex;
	justify-content:space-between;
	width:65px;
}
.facebook, .vk{
	width:30px;
	height: 30px;
	background-color: blue;
	border-radius: 50%;

}

.facebook{
	background-image: url("~../assets/Facebook.svg");
	background-size: auto;
	background-repeat: no-repeat;
	background-position: 50% 50%;
}

.vk{
	@extend .facebook;
	background-image: url("~../assets/VK.svg");
}
.year{
	display:flex;
	justify-content:center;
	align-items:center;
	width:100%;
	height:40px;
	font-size:14px;
}
</style>
