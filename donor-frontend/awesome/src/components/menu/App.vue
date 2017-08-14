<template>
<div class="app">
	<div class="nav">
	<div class="blur" v-if="blurBack"></div>
	<div class="icon--hamburger" @click="toggleMenu" :class="{menuButton:!seeMenu, backButton:seeMenu}">
      <span class="line"></span>
      <span class="line"></span>
      <span class="line"></span>
  </div>
		<router-link to="/"><div class="logo"></div>  </router-link>
	</div>
	<transition name="slide-fade">
		<div :class="{menu:true}" v-if="seeMenu" @click="toggleMenu">
			<!--unregistered-->
			<!--<div class="category" v-if="isRegistered == false"> <router-link to="/registration">  Регистрация </router-link></div>-->
			<!--registered-->
			<div class="category"> <router-link to="/profile"> <div class="user-image"></div> Владимир Купец (профиль) </router-link></div>
			<div class="category" @click="toggleSub('donor')">Процесс донорства <div :class="{extend:!subList.donor, extendReverse: subList.donor}"></div>
				<div class="subcategory" v-if="subList.donor">
					<div class="sub enabled"> <router-link to="/registration">Регистрация на сайте </router-link></div>
					<div class="sub enabled"><router-link to="/quiz">Могу ли я сдать кровь?</router-link></div>
					<div class="sub enabled"><router-link to="/donation-process">Процедура сдачи крови и компонентов</router-link></div>
					<div class="sub enabled"><router-link to="/contraindications">Противопоказания</router-link></div>

				</div>
			</div>
			
			<div class="category" @click="toggleSub('info')">О крови <div :class="{extend:!subList.info, extendReverse: subList.info}"></div>
				<div class="subcategory" v-if="subList.info">
					<div class="sub">Типы крови</div>
					<div class="sub">Как хранится кровь?</div>
					<div class="sub enabled"> <router-link to="/blood-supply">Текущие уровни запасов крови</router-link></div>
					<div class="sub enabled"><router-link to="/blood-component">Компоненты крови</router-link></div>
				</div>
			</div>
			<div class="category ">Поддержать проект <div class="support"></div></div>
		</div>
	</transition>
		
</div>
</template>

<script>
    import {store} from "../../store/store.js"

    export default{
		data: function(){
			return{
				seeMenu:false,
				target: '',
				blurBack:false,
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
				this.blurBack = !this.blurBack;
				if(this.seeMenu == true){
				document.querySelector("body").classList.add("bluredApp");
				document.querySelector(".list").classList.add("mainBlur");
				document.querySelector(".tabs").classList.add("mainBlur");
			} else {
				document.querySelector("body").classList.remove("bluredApp");
				document.querySelector(".list").classList.remove("mainBlur");
				document.querySelector(".tabs").classList.remove("mainBlur");
			}
				// reset opened subcategories
				for( var key in this.subList){
					this.subList[key] = false;
				}

			},
			toggleSub: function(which){
				this.target = which;
				this.subList[this.target] = !this.subList[this.target];
			}
		},
		computed:{
		    isRegistered:function(){
		        return store.state.auth;
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
		box-shadow: 0 1px 2px 0 rgba(80,80,80,0.7);
		background-image: url("~../assets/lightpaperfibers.png");
    background-size: 21%;
    background-repeat:repeat;
	}
	.blur{
		width:100vw;
		height:100vh;
		position:absolute;
		top:0;
		left:0;
		z-index:1;
		background-color: rgba(255,255,255,0.7);
		// filter:blur(30px);
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
		position: relative;
		// background-color: #DB3328;
		box-shadow: 0 2px 6px 2px rgba(80,80,80,0.7);
	.menuButton{
	width:65px;
	height:65px;
	 cursor: pointer;
	position:absolute;
	left:20px;
	top:40%;
	transition:all 1s;
	z-index:10000;
	// filter:invert(100%);
	span{
		transition: 0.5s;
	}
	}

	.backButton{
		@extend .menuButton;
		// filter:invert(0);
		 span:nth-child(1) {
        -webkit-transform: rotate(-45deg);
        left: -1px;
        top: 2px;

        width: 17px;
            
    }
  
   span:nth-child(2) {
       -webkit-transform: rotate(180deg);
          
    }
        
     span:nth-child(3) {
        
        -webkit-transform: rotate(45deg);
        left: -1px;
        top: 14px;
        width: 17px;
            
    }
	}
	}

	
	.logo{
		width:65px;
		height: 65px;
		background-image: url("~../assets/LogoDonor2.svg");
		background-size: 100%;
		background-position: 50% 50%;
		background-repeat: no-repeat;
		// filter:invert(100%) grayscale(1) brightness(3);
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

		.icon--hamburger {
    
    cursor: pointer;
    position: relative;
    height: 19px;
    width: 28px;

}

.line{
	background-color: black;
        display: block;
        height: 4px;
        position: absolute;
        width: 28px;

        &:nth-child(1) { top: 0; }
        &:nth-child(2) { top: 8px; }
        &:nth-child(3) { top: 16px; }
}

@media only screen and (min-width: 600px){
  .menu{
    width:400px;
  }
}
</style>
