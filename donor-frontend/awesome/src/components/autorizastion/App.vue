<template>
    <div class="autorization-wrapper">
    <div class="container">
        <!-- <notation></notation> -->
        <ul class="autorization__list">
            <li class="autorization__item">
                <a class="autorization__link" :class="{ active: currentView == 'login' }" href="#" @click.prevent="changeView('login')">Личный&nbsp;кабинет</a>
            </li>
            <li class="autorization__item">
                <a class="autorization__link" :class="{ active: currentView == 'registration' }" href="#" @click.prevent="changeView('registration')">Регистрация</a>
            </li>
        </ul>
        <component :is="currentView"></component>
        <notation></notation>
        </div>
    </div>
</template>

<script>

    import Vue from 'vue';
    import axios from 'axios';
    import VueAxios from 'vue-axios';
    import Login from './Login.vue';
    import Registration from './Registration.vue';
    import notation from './notation.vue';

    Vue.use(VueAxios, axios);

    export default {
        data: function(){
            return {
                currentView : "login"
            }
        },
        components:{
            login:Login,
            registration: Registration,
            notation: notation
        },
        methods:{
            changeView: function (view){
                this.currentView = view;
            }
        }

    }
</script>

<style lang="scss" scoped>
.autorization-wrapper{
    background-color: #3A63A2;
         background-image: url("~../assets/background.jpg");
  background-size: auto;
  background-repeat:repeat;
}

.autorization__list{
        display: flex;
        list-style: none;
        background-color: white;
        padding: 0;
        align-items: center;
        justify-content: space-around;
        margin: 0px;
    }
    .autorization__item{
        margin:10px;
    }
    .autorization__link{
        text-decoration: none;
        color: black;
        font-size: 1.3em;
    }
    .autorization__link.active{
        border-bottom: 2px solid red;
    }

@media only screen and (min-width: 600px){
  .container{
    width:700px;
    margin: 0 auto;
  }

  .autorization-wrapper{
    padding-top:40px;
  }

}
</style>