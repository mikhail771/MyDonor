<template>
    <div class="autorization-wrapper">
        <notation></notation>

        <form class="login-form" >
            <div class="reg-field__wrap">
                <label for="name-rec">Имя и фамилия реципиента<br>
                    <input type="text" required v-model="nameRec" class="reg-field__input" id="name-rec" placeholder="Введите имя и фамилию">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="date">Дата рождения реципиента<br>
                    <input type="text" :class="{ err: isDateErr }" @blur="checkDate" required class="reg-field__input" id="date" v-model="request.date" placeholder="Введите дату рождения dd.mm.yyyy">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="email">Введите ВашEmail<br>
                    <input type="mail" required v-model="request.login"class="reg-field__input" id="email" placeholder="Введите Ваш Email">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="name-contact">Контактный человек<br>
                    <input type="text" required v-model="nameContact" class="reg-field__input" id="name-contact" placeholder="Введите ФИО">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="phone-contact">Телефон<br>
                    <input type="tel" required v-model="request.phoneContact" class="reg-field__input" id="phone-contact" placeholder="Телефон контактного человека">
                </label>
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
                name:"",
                surname:"",
                date:"",
                nameContact:"",
                surnameContact:"",
                middleNameContact:"",
                phoneContact:""
            },
            isDateErr:""
        },
        components:{
            'notation': notation
        },
        computed:{
            nameRec: function(){
                var arr = this.nameRec.split(" ");
                this.request.name = arr[0];
                this.request.surname = arr[1];

            },
            nameContact: function(){
                var arr = this.nameContact.split(" ");
                this.request.surnameContact = arr[0];
                this.request.nameContact = arr[1];
                this.request.middleNameContact = arr[2];
            }
        },
        methods:{
            checkDate: function (e) {
                var arr = e.target.value.split(/[-\/,.]/);
                if (arr.length < 3 && e.target.value.length !== 0){
                    this.isDateErr = true;
                    return false;
                }
                if (+arr[1] == 0 || +arr[1] > 12 || +arr[0] > 31 || +arr[2] > 2018 || +arr[2] < 1800) {
                    this.isDateErr = true;
                    return false;
                }
                if (+arr[1] === 2 && +arr[0] > 29) {
                    this.isDateErr = true;
                    return false;
                }
                if ((+arr[1] === 4 || +arr[1] === 6 || +arr[1] === 9 || +arr[1] === 11) && +arr[0] > 30){
                    this.isDateErr = true;
                    return false;
                }
                this.isDateErr = false;
                return true;
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>