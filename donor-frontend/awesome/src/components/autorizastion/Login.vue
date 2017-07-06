<template>
    <div class="login-wrap">
        <form class="login-form" @submit.prevent="regUser">
            <div class="login-field__wrap">
                <label for="login">Логин<br>
                    <input type="text" required v-model="loginform.username" class="login-field__input" id="login" placeholder="Введите Ваш Email">
                </label>
            </div>
            <div class="login-field__wrap">
                <label for="password">Пароль<br>
                    <input type="password" required v-model="loginform.password" class="login-field__input" id="password" placeholder="Введите пароль">
                </label>
            </div>
            <button class="button">Войти</button>
        </form>
    </div>
</template>

<script>
    import Vue from 'vue'
    import axios from 'axios'
    import VueAxios from 'vue-axios'
import { store } from "../../store/store.js"
    Vue.use(VueAxios, axios);

    export default {
        data: function(){
            return{
                loginform: {
                    username: "" ,
                    password:"" ,
                },
            }
        },
        methods:{
            regUser: function(){
                var then = this;

                const config = { headers: {'Content-Type': 'application/json'}};
                axios.post(store.state.baseRequestUrl + '/registration', JSON.stringify(this.loginform), config)
                        .then(function (response) {
                            console.log(response.data);

                        })
                        .catch(function (error) {
                            console.log(JSON.stringify(then.userData));
                            console.log(error);
                        });
            },
            checkPassword: function (e) {
                if (this.password_confirm !== this.userData.password ){
                    this.isPasErr = true;
                    this.password_confirm = "";
                } else {
                    this.isPasErr = false;
                }
            }
        }
    }

</script>

<style lang="scss" scoped>
    .login-wrap{
        padding: 10px;
        background-color: white;
        padding-bottom:30px;
    }
    .login-form {
        text-transform: uppercase;
        color: #9a9a9a;
    }
    .login-field__wrap {
        border-bottom: 1px solid #9a9a9a;
        margin:20px 0;
    }
    .login-field__input{
        margin:10px 0;
        width: 100%;
        box-sizing: border-box;
        padding:5px;
        border:none;
    }
    .button{
        background-color: #d80000;
        color:#fff;
        padding:10px;
        border-radius: 10px;
        border: none;
        display: block;
        margin: 0 auto;
        width:100%;
        font-size: 1.1em;
    }

</style>