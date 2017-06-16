<template>
	<div class="app">
		<div class="image"></div>
		<div class="title">Могу ли я сдать кровь?</div>

		<router-link to="/questions"><button class="start">Ознакомительная викторина</button></router-link>
	</div>
</template>

<script>
	export default{

	}
</script>

<style lang="scss" scoped>
.app{
	min-height:352px;
	height:80vh;
	position:relative;
	box-sizing:border-box;
	overflow: hidden;
}
	.image{
		width:200px;
		height:200px;
		margin:30px auto;
		border-radius: 50%;
		background-image: url("~../../assets/hearts.svg");
		background-repeat: no-repeat;
		background-size: auto;
		background-position: 50% 50%;
	}
	.title{
		width:100%;
		text-align:center;
		font-size:18px;
		color:#DB3328;
	}

	.start{
		display:block;
		width:90%;
		background-color: #DB3328;
		color:white;
		margin: 0 auto;
		border:none;
		padding:10px;
		border-radius: 4px;
		position:absolute;
		bottom:38px;
		left:5%;
	}

@media only screen and (min-width: 600px){
  .app{
    width:700px;
    margin: 0 auto;
  }
}
</style>