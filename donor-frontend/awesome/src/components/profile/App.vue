<template>
	<div class="app">
	<div class="actions">
		<div class="edit"></div>
		<div class="delete"></div>
	</div>
	<div class="image-container">
		<div class="image"></div>
	</div>

	<div class="name">Владимир Купец</div>
	<div class="city">Украина, Днепр</div>
	<div class="blood"> A (II) Rh-</div>
	</div>
</template>

<script>
	export default{

	}
</script>

<style lang="scss" scoped>
	.app{
		width:100%;
		background-color: white;
	}

	.actions{
		width:100%;
		height:40px;
		display:flex;
		justify-content:flex-end;
		padding: 10px 0;
	}

	.edit{
		width:40px;
		height:40px;
		margin-right:16px;
		background-image: url("~../assets/Pen.png");
		background-position: 50% 50%;
		background-repeat: no-repeat;
		background-size: 80%;
	}

	.delete{
	@extend .edit;
	background-image: url("~../assets/del.svg");
	background-size: 100%;
	}

	.image-container{
		width:200px;
		height:200px;
		margin: 0 auto;
		display:flex;
		justify-content:center;
		background-image: url("~../assets/111.jpg");
		background-size: cover;
		background-repeat: no-repeat;
		background-position: 30% 50%;
		border-radius:50%;
		box-shadow: 0 0 10px 2px rgba(50,50,50, 0.9);
		margin-bottom:18px;
	}

	.name{
		font-size: 24px;
		padding:8px 12px;
	}

	.city{
		font-size: 14px;
		color:grey;
		padding:0 12px;
	}

	.blood{
		background-color: #DB3328;
		width:130px;
		height:40px;
		color:white;
		border-radius: 5px;
		display:flex;
		justify-content:center;
		align-items:center;
		font-size: 16px;
		margin:12px;
	}
</style>