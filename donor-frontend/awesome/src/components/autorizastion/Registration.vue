<template>
    <div class="reg-wrap">
        <form class="login-form" @submit.prevent="regUser">
            <div class="reg-field__wrap">
                <label for="name">Имя<br>
                    <input type="text" required v-model="userData.name" class="reg-field__input" id="name" placeholder="Введите имя">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="surname">Фамилия<br>
                    <input type="text" required v-model="userData.surname" class="reg-field__input" id="surname" placeholder="Введите фамилию">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="date">Дата рождения<br>
                    <input type="text" required class="reg-field__input" id="date" v-model="userData.date" placeholder="Введите дату рождения">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="email">Email<br>
                    <input type="mail" required v-model="userData.login"class="reg-field__input" id="email" placeholder="Введите Email">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="password">Пароль<br>
                    <input type="password" required v-model="userData.password" class="reg-field__input" id="password" minlength="6" placeholder="Введите пароль 6 или более символов">
                </label>
            </div>
            <div class="reg-field__wrap">
                <span>Пол</span>
                <div class="reg-radio__wrap">
                    <input type="radio" name="gender" value="male" v-model="userData.gender" required class="reg-field__input reg-field__input--gener" id="male">
                    <label for="male" class="reg-radio__label">Мужчина</label>

                    <input type="radio" name="gender" required value="female" v-model="userData.gender" class="reg-field__input reg-field__input--gener" id="female">
                    <label for="female" class="reg-radio__label">Женщина</label>

                </div>
            </div>
            <button class="button">Войти</button>
        </form>
    </div>
</template>

<script>
    import Vue from 'vue'
    import axios from 'axios'
    import VueAxios from 'vue-axios'

    Vue.use(VueAxios, axios);

    export default {
        data: function(){
            return{
                userData: {
                    name: "" ,
                    surname:"" ,
                    login:"", //email
                    password:"",
                    gender:"",
                    date:""
                },
                password_confirm:"",
                isPasErr: false
            }
        },
        methods:{
            regUser: function(){
                var then = this;

                const config = { headers: {'Content-Type': 'application/json'}};
                axios.post('registration', JSON.stringify(this.userData), config)
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
    .reg-wrap{
        padding: 10px;
    }
    .login-form {
        text-transform: uppercase;
        color: #9a9a9a;
    }
    .reg-field__wrap {
        border-bottom: 1px solid #9a9a9a;
        margin:20px 0;
    }
    .reg-field__input {
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
    .reg-radio__wrap{
        display:flex;
        justify-content: space-around;
        align-items: center;
        text-transform: capitalize;
    }
    .reg-field__input--gener{
        flex-basis: 20px;
    }
    .reg-radio__label{
        flex-grow: 1;
    }

</style>