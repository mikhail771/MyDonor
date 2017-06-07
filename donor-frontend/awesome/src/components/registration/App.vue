<template>
    <div id="app">
        <form  name="xml-ajax" id="xml-ajax" class="userForm" @submit.prevent="regUser">
            <h1>Регистрация пользователя</h1>
            <div class="wrap">
                <div class="block">
                    <label class="control-label" for="login">Логин *</label>
                    <input type="text" v-model="userData.login" required id="login">
                </div>
                <div class="block">
                    <label class="control-label" for="password">Пароль *</label>
                    <input type="password" v-model="userData.password" required id="password" placeholder="* * * * * * * *">
                </div>
                <div class="block">
                    <label class="control-label" for="password_confirm">Подтверждение пароля *</label>
                    <input type="password" v-model="userData.password_confirm" required id="password_confirm" placeholder="* * * * * * * *">
                </div>
                <div class="block">
                    <label class="control-label" for="city">Город *</label>
                    <select v-model="userData.city" required id="city" class="select">
                        <option v-for="option in formData.cities"> {{option}}</option>

                    </select>
                </div>

                <div class="block">
                    <label class="control-label" for="gender">Пол *</label>
                    <select v-model="userData.gender" id="gender" class="select" required>
                        <option v-for="item in formData.gender">{{item}}</option>
                    </select>
                </div>


                <div class="block">
                    <label class="control-label" for="bloodType">Группа крови *</label>
                    <select v-model="userData.bloodType" id="bloodType" class="select" required>
                        <option v-for="item in formData.bloodType">{{item}}</option>
                    </select>
                </div>

                <div class="block">
                    <label class="control-label" for="rhesus">Резус фактор *</label>
                    <select v-model="userData.rhesus" id="rhesus" class="select" required>
                        <option v-for="item in formData.rhesus">{{item}}</option>
                    </select>
                </div>
                <div class="block">
                    <label class="control-label" for="contact">Контакты *</label>
                    <input type="text" v-model="userData.contact" id="contact" required placeholder="Введите E-mail или номер телефона">
                </div>

                <div class="block">
                    <label class="control-label" for="info">Информация</label>
                    <input type="text" v-model="userData.info" id="info">
                </div>


                <div class="block">
                    <button type="submit" id="but" class="button">Зарегистрироваться</button>
                </div>
            </div>
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
                formData:{
                    cities: ["Днепр", "Киев", "Харьков", "Одесса", "Запорожье", "Камянское"],
                    gender: ["мужской","женский"],
                    bloodType: ["первая (O)","вторая (A)","третья (B)","четвертая (AB)"],
                    rhesus: ["положительный","отрицательный"]


                },
                userData: {
                    login: "" ,
                    password:"" ,
                    city: "Днепр",
                    password_confirm:"",
                    gender:"мужчина",
                    bloodType:"" ,
                    rhesus:"" ,
                    contact:"" ,
                    info: ""
                }
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
            }
        }
    }
</script>

<style lang="scss" scoped>
    html{
        background-color: #d84146;
        font-family: Tahoma, Verdana, Segoe, sans-serif;
        font-size: 16px;
    }
    form{
        width: 50%;
        background-color: #fff;
        margin: 20px auto;

    }
    @media screen and(max-width:1024px){
        form{
            width:90%;
        }
    }
    form > div {
        padding: 30px;
    }
    .userForm h1 {
        background-color: #b02429;
        color: #fff;
        padding: 20px;
        margin: 0;
    }
    .userForm input {
        border: 1px solid #b02429;
        padding-left: 10px;
        height: 25px;
        width: 40%;
        border-radius: 5px;
        outline: none;
    }
    .userForm input[type="radio"] {
        width: 4%;
    }
    .userForm textarea {
        border: 1px solid #b02429;
        border-radius: 5px;
    }
    .userForm label {
        color: #b02429;
        text-transform: uppercase;
        vertical-align: top;
    }
    .block {
        padding: 10px;
    }
    .select {
        height: 25px;
        border: 1px solid #b02429;
        background-color: #fff;
        width: 150px;
        outline: none;
        font-size: 14px;
        color: gray;
    }
    .control-label {
        width: 30%;
        display: inline-block;
    }
    .button {
        width: 90%;
        height: 40px;
        padding: 0;
        margin: 20px auto;
        border: none;
        cursor: pointer;
        border-radius:  5px;
        background: -webkit-gradient(linear, 0 0, 0 100%, from(rgba(216, 65, 82, 0.3)), to(#b02429));
        background: -webkit-gradient(linear, 0 0, 0 100%, from(rgba(216, 65, 82, 0.3)), to(#b02429));
        color: #b02429;
        text-transform: uppercase;
        display: block;
        color: #fff;
        font-size: 16px;
        letter-spacing: 2px;
    }
    button:hover{
        background: #b02429;
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#b02429), to(rgba(216, 65, 82, 0.3)));
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#b02429), to(rgba(216, 65, 82, 0.3)));
    }
    button:active{
        background: #b02429;
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#D60000), to(#F44336));
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#D60000), to(#F44336));
    }
    button:focus{
        outline: none;
    }
</style>
