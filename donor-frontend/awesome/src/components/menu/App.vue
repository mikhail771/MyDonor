<template>
<div class="app">
	<div class="nav">
		<div  @click="toggleMenu" :class="{menuButton:!seeMenu, backButton:seeMenu}"></div>
		<router-link to="/"><div class="logo"></div>  </router-link>
	</div>
	<transition name="slide-fade">
		<div class="menu" v-if="seeMenu">
			<div class="category" @click="toggleSub('donor')">Процесс донорства <div :class="{extend:!subList.donor, extendReverse: subList.donor}"></div>
				<div class="subcategory" v-if="subList.donor">
					<div class="sub"> <router-link to="/registration">Регистрация на сайте </router-link></div>
					<div class="sub">Могу ли я сдать кровь?</div>
					<div class="sub">Перед забором крови</div>
					<div class="sub">Подготовка в день сдачи крови</div>
					<div class="sub">Как происходит забор крови?</div>
					<div class="sub">Что делать сразу после сдачи крови?</div>
					<div class="sub">После того, как покинете банк крови</div>
					<div class="sub">Когда можно снова сдать кровь?</div>
					<div class="sub">Процедура сдачи крови и компонентов</div>
					<div class="sub">Противопоказания</div>

				</div>
			</div>
			<div class="category" @click="toggleSub('help')">Адресная помощь (реципиенты) <div :class="{extend:!subList.help, extendReverse: subList.help}"></div>
				<div class="subcategory" v-if="subList.help">
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
				</div>
			</div>
			<div class="category" @click="toggleSub('stories')">Удивительные истории <div :class="{extend:!subList.stories, extendReverse: subList.stories}"></div>
				<div class="subcategory" v-if="subList.stories">
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
				</div>
			</div>
			<div class="category" @click="toggleSub('info')">О крови <div :class="{extend:!subList.info, extendReverse: subList.info}"></div>
				<div class="subcategory" v-if="subList.info">
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
					<div class="sub">Lorem ipsum dolor sit.</div>
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
			toggleMenu: function(){
				this.seeMenu = !this.seeMenu;

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
		position: -webkit-sticky;
		  position: sticky;
		  top:0;
		  z-index:1000;
		background-color: white;
		margin:0;
		top:0;
	}

	a{
		text-decoration:none;
		color:#454647;
	}
	.nav{
		display:flex;
		width:100%;
		height:40px;
		justify-content:center;
	.menuButton{
	width:40px;
	height:40px;
	background-image: url("/src/assets/hamburger.png");
	background-size: 100%;
	background-position: 50% 50%;
	background-repeat: no-repeat;
	position:absolute;
	left:0;
	}

	.backButton{
		@extend .menuButton;
		background-image: url("/src/assets/Strela.svg");
		background-size: 65%;
	}
	}


	.logo{
		width:40px;
		height: 40px;
		background-image: url("/src/assets/LogoDonor2.svg");
		background-size: 100%;
		background-position: 50% 50%;
		background-repeat: no-repeat;
	}

	.menu{
		// display: none;
		position: absolute;
		width:100%;
		z-index:1000;
		background-color: white;
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
		display:flex;
		align-items:center;
		justify-content:space-between;
		overflow: hidden;
		flex-wrap:wrap;

	}

	.subcategory{
		width:100%;
	}

	.sub{
		width:100%;
		padding:10px;
		color:#454647;
		font-size: 14px;
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
			left:0;
		}

	}

	.extendReverse{
		@extend .extend;
		transform:scaleY(-1);
	}

	.support{
		@extend .extend;
		&:before{
			display:none;
		}
		background-image: url("/src/assets/heart.svg");
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