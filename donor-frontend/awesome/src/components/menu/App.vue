<template>
<div class="app">
		<ul class="nav" id="nav">
			<li><router-link to="/">Главная/Заявки</router-link></li>
			<li><router-link to="/bids">Подать заявку</router-link></li>
			<li><router-link to="/registration">Регистрация</router-link></li>
		</ul>
</div>
</template>

<script>

</script>

<style scoped>
.app{
	width:100%;
	height:100px;
	box-sizing: border-box;
}

.nav{
	list-style: none;
    font-size: 18px;
    text-align: center;
}
.nav li{
	display: inline-block;
	padding: 20px;
	background-color: #b02429;
	border-radius: 0 0 7px 7px;
	margin-right: 5px;
	cursor: pointer;
}
.nav li:last-child{
	margin-right: 0;
}
.nav li:hover{
	background: -webkit-gradient(linear, 0 0, 0 100%, from(rgba(216, 65, 82, 0.3)), to(#b02429));
}
.nav li a{
	color: #fff;
	text-decoration: none;
	text-transform: uppercase;
}


@media all and (max-width: 800px){
	.nav li{
		margin-bottom: 1px;
		margin-right: 0;
		border-radius: 7px;
		display: none;
		cursor: pointer;
	}
}
</style>