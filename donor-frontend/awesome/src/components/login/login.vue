<template>
	<div class="container">
		<form action="">
			<input type="text">
			<input type="password">
			<div class="controls">
				<button class="login">Login</button>
				<router-link to="/registration">Зарегестрироваться</router-link>
			</div>
		</form>
	</div>
</template>

<script>
	export default{

	}
</script>

<style lang="scss" scoped>
	form{
		width:90%;
		display:flex;
		flex-wrap:wrap;
		margin:0 auto;
		justify-content:center;
			input{
				width:80%;
			}
	}

	.controls{
		width:40%;
		display:flex;
		justify-content:space-around;
	}

</style>