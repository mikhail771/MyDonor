<template>
<div class="app">
	<div class="nav">
		<div  @click="toggleMenu" :class="{menuButton:!seeMenu, backButton:seeMenu}"></div>
		<router-link to="/"><div class="logo" @click="toggleMenu"></div>  </router-link>
	</div>
	<transition name="slide-fade">
		<div :class="{menu:true}" v-if="seeMenu" @click="toggleMenu">
			<div class="category"> <router-link to="/profile"> <div class="user-image"></div> Владимир Купец (профиль) </router-link></div>
			<div class="category" @click="toggleSub('donor')">Процесс донорства <div :class="{extend:!subList.donor, extendReverse: subList.donor}"></div>
				<div class="subcategory" v-if="subList.donor">
					<div class="sub enabled"> <router-link to="/registration">Регистрация на сайте </router-link></div>
					<div class="sub enabled"><router-link to="/quiz">Могу ли я сдать кровь?</router-link></div>
					<div class="sub">Перед забором крови</div>
					<div class="sub">Подготовка в день сдачи крови</div>
					<div class="sub">Как происходит забор крови?</div>
					<div class="sub">Что делать сразу после сдачи крови?</div>
					<div class="sub">После того, как покинете банк крови</div>
					<div class="sub">Когда можно снова сдать кровь?</div>
					<div class="sub">Процедура сдачи крови и компонентов</div>
					<div class="sub enabled"><router-link to="/contraindications">Противопоказания</router-link></div>

				</div>
			</div>
			<div class="category" @click="toggleSub('help')">Адресная помощь (реципиенты) <div :class="{extend:!subList.help, extendReverse: subList.help}"></div>
				<div class="subcategory" v-if="subList.help">
					<div class="sub enabled"><router-link to="/registration">Регистрация на сайте</router-link></div>
					<div class="sub enabled"><router-link to="/">Помочь конкретному реципиенту</router-link></div>
					<div class="sub">Создать заявку реципиента</div>
				</div>
			</div>
			<div class="category" @click="toggleSub('stories')">Удивительные истории <div :class="{extend:!subList.stories, extendReverse: subList.stories}"></div>
				<div class="subcategory" v-if="subList.stories">
					<div class="sub">Ярослав</div>
					<div class="sub">Алла</div>
					<div class="sub">Миша и Юля</div>
				</div>
			</div>
			<div class="category" @click="toggleSub('info')">О крови <div :class="{extend:!subList.info, extendReverse: subList.info}"></div>
				<div class="subcategory" v-if="subList.info">
					<div class="sub">Типы крови</div>
					<div class="sub">Как хранится кровь?</div>
					<div class="sub">Текущие уровни запасов крови</div>
					<div class="sub">Компоненты крови</div>
					<div class="sub">Переливание крови</div>
				</div>
			</div>
			<div class="category ">Поддержать проект <div class="support"></div></div>
		</div>
	</transition>
		
</div>
</template>

<script>
	export default{
		data: function(){
			return{
				seeMenu:false,
				target: '',
				subList:{
					donor:false,
					help:false,
					stories:false,
					info:false
				}
			}
		},
		methods:{
			toggleMenu: function(e){
				if (e.target.classList.contains("logo")) this.seeMenu = true;
				if (e.target.classList.contains("sub")|| e.target.classList.contains("category") || e.target.classList.contains("extend") || e.target.classList.contains("extendReverse")) return;
				this.seeMenu = !this.seeMenu;
				// reset opened subcategories
				for( var key in this.subList){
					this.subList[key] = false;
				}

			},
			toggleSub: function(which){
				this.target = which;
				this.subList[this.target] = !this.subList[this.target];
			}
		}
	}
</script>

<style lang="scss" scoped>
	.app{
		width:100%;
		height:65px;
		 position: -webkit-sticky;
		position: sticky;
		  top:0;
		  z-index:1000;
		background-color: white;
		margin:0;
		top:0;
		box-shadow: 0 1px 4px 0 rgba(100,100,100,0.5);
	}

	a{
		text-decoration:none;
		color:#454647;
	}
	.nav{
		display:flex;
		width:100%;
		height:65px;
		justify-content:center;
	.menuButton{
	width:65px;
	height:65px;
	background-image: url("~../assets/hamburger.png");
	background-size: 100%;
	background-position: 50% 50%;
	background-repeat: no-repeat;
	position:absolute;
	left:0;
	}

	.backButton{
		@extend .menuButton;
		background-image: url("~../assets/Strela.svg");
		background-size: 65%;
	}
	}

	
	.logo{
		width:65px;
		height: 65px;
		background-image: url("~../assets/LogoDonor2.svg");
		background-size: 100%;
		background-position: 50% 50%;
		background-repeat: no-repeat;
	}

	.menu{
		position: absolute;
		width:100%;
		z-index:1000;
		background-color: white;
		box-shadow: 0 1px 4px 0 rgba(100,100,100,0.5);
		}
	.showMenu{
		display:block;
		background-color: white;
	}



	.category{
		font-size:16px;
		color:#DB3328;
		border-top:1px solid rgba(0,101,189,0.3);
		padding:10px;
		padding-left:48px;
		display:flex;
		align-items:center;
		justify-content:space-between;
		overflow: hidden;
		flex-wrap:wrap;
		&:nth-of-type(1){
			display:block;
			padding:18px 10px 18px 10px;
			background-color: rgba(0,101,189,0.1);
			color:black;
			font-weight:bold;
		}
		
	}

	.user-image{
		width:25px;
		height:25px;
		background-color: grey;
		border-radius: 50%;
		display:inline-block;
		margin-right:10px;
		vertical-align: middle;
		background-image: url("~../assets/111.jpg");
		background-repeat: no-repeat;
		background-position: 50% 50%;
		background-size: cover;
		box-shadow: 0 0 5px grey;
	}
	
	.subcategory{
		width:100%;
	}
	
	.sub{
		width:100%;
		padding:10px;
		color:#c9c9c9;
		font-size: 14px;
	}
	
	.enabled{
		a{
			color:#454647;;
		}
	}

	.extend{
		width:30px;
		height:30px;
		position:relative;
		&:before{
			content:"";
			display:inline-block;
			width:1px;
			height:1px;
			border: 11px solid transparent;
			border-top:11px solid #F77777;
			position:absolute;
			top:45%;
			left:10px;
		}

	}

	.extendReverse{
		@extend .extend;
		transform:scaleY(-1);
	}

	.support{
		@extend .extend;
		left:10px;
		&:before{
			display:none;
		}
		background-image: url("~../assets/heart.svg");
		background-size: 80%;
		background-repeat: no-repeat;
	}


	// ANIMATION
	.slide-fade-enter-active {
		  transition: all 0.4s ease;
		}
		.slide-fade-leave-active {
		  transition: all 0.4s cubic-bezier(1.0, 0.5, 0.8, 1.0);
		}
		.slide-fade-enter{
			transform:translateY(-300px) !important;
		  opacity: 0;
		}
		 .slide-fade-leave-to{
		  transform:translateY(-300px) !important;
		  opacity: 0;
		}
</style>
