<template>
<div class="app">
	<div class="menu_panel">
				<div id="menu_btn"></div>
		</div>
		
		<ul class="nav" id="nav">
			<li @click.prevent="feed"><a class="nav_a" href="#about" data-name="bid">Главная/Заявки</a></li>
			<li @click.prevent="bid"><a class="nav_a" href="#prepose" data-name="feed" >Подать заявку</a></li>
			<li @click.prevent="reg" ><a class="nav_a" href="#travel" data-name="travel">Регистрация</a></li>
			
		</ul>
</div>
</template>

<script>
	export default{
		data: function(){
			return{
				feedIndex: 0,
				bidIndex:1,
				regIndex:2
			}
		},
		props:['index'],

	
		methods:{
			feed: function(){
				this.$emit('goTo', this.feedIndex);
			},
			bid: function(){
				this.$emit('goTo', this.bidIndex);
			},
			reg: function(){
				this.$emit('goTo', this.regIndex);
			}
		}
	}
</script>

<style scoped>
	.app{
width:100%;
	height:100px;
	box-sizing: border-box;
	}

.menu_panel{
	background-color: #b02429;
	
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

/*------------------------*/

/*@media all and (max-width: 980px){
	#page{min-width:100%;}
	.wrap {
	    width: 96%;
	    padding: 0 2%;
	}	
}*/
#menu_btn{
	display: none;
}
@media all and (max-width: 800px){
	.menu_panel{
		border-radius: 7px;
		padding: 18px;
		margin-bottom: 1px;
	}
	#menu_btn{
		width: 45px;
		height: 45px;
		border-bottom: 15px double #fff;
		border-top: 5px solid #fff;
		height: 5px;
		width: 30px;
		display: block;
		cursor: pointer;
	}
	.nav li{
		margin-bottom: 1px;
		margin-right: 0;
		border-radius: 7px;
		display: none;
		cursor: pointer;
	}
}

/*#content{*/
	/*background-color:#D9D2E9;*/
	/*min-height: 502px;*/
/*}*/

</style>