<template>
    <div class="autorization-wrapper">
        <notation></notation>

        <form class="login-form" @submit.prevent="regUser">
            <div class="reg-field__wrap">
                <label for="name-rec">Имя и фамилия реципиента<br>
                    <input type="text" required v-model="request.nameRec" class="reg-field__input" id="name-rec" placeholder="Введите имя и фамилию">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="surname">Фамилия<br>
                    <input type="text" required v-model="request.surname" class="reg-field__input" id="surname" placeholder="Введите фамилию">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="date">Дата рождения<br>
                    <input type="text" :class="{ err: isDateErr }" @blur="checkDate" required class="reg-field__input" id="date" v-model="userData.date" placeholder="Введите дату рождения dd.mm.yyyy">
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

    import Vue from 'vue';
    import axios from 'axios';
    import VueAxios from 'vue-axios';
    import notation from './notation.vue';

    Vue.use(VueAxios, axios);

    export default {
        data:{
            request:{
                nameRec:""
            }
        },
        components:{
            'notation': notation
        }
    }
</script>

<style lang="scss" scoped>

</style>