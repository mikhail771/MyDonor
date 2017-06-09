<template>
    <div>
        <notation></notation>
        <ul>
            <li><a href="#" @click.prevent="changeView('login')">Login</a></li>
            <li><a href="#" @click.prevent="changeView('registration')">Registration</a></li>
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
                console.log("switch");
                this.currentView = view;
            }
        }

    }
</script>

<style lang="scss" scoped>

</style>