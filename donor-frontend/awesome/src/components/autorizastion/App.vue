<template>
    <div class="autorization-wrapper">
        <notation></notation>
        <ul class="autorization__list">
            <li class="autorization__item">
                <a class="autorization__link" :class="{ active: currentView == 'login' }" href="#" @click.prevent="changeView('login')">Личный&nbsp;кабинет</a>
            </li>
            <li class="autorization__item">
                <a class="autorization__link" :class="{ active: currentView == 'registration' }" href="#" @click.prevent="changeView('registration')">Регистрация</a>
            </li>
        </ul>
        <component :is="currentView"></component>
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
    .autorization__list{
        display: flex;
        list-style: none;
        padding: 0;
        align-items: center;
        justify-content: space-around;
        margin: 10px;
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
</style>