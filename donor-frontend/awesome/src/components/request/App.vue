<template>
    <div class="request-wrap">
        <notation></notation>

        <form class="request-form" @submit.prevent="sendRequest">
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
                <label for="email">Введите Ваш Email<br>
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

            <div class="reg-field__wrap">
                <label for="donation-type">Тип кроводачи<br>
                    <select v-model="request.donationType" id="donation-type" class="reg-field__input select" required placeholder="Выберите из списка">
                        <option v-for="item in formData.donationType">{{item}}</option>
                    </select>
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="blood-type">Группа крови<br>
                    <select v-model="request.bloodType" id="blood-type" class="reg-field__input select" required placeholder="Выберите из списка">
                        <option v-for="item in formData.bloodType">{{item}}</option>
                    </select>
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="rhesus">Резусфактор<br>
                    <select v-model="request.rhesus" id="rhesus" class="reg-field__input select" required placeholder="Выберите из списка">
                        <option v-for="item in formData.rhesus">{{item}}</option>
                    </select>
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="donor-quantity">Количество доноров<br>
                    <input type="number" v-model="request.donorQuantity" class="reg-field__input" id="donor-quantity" placeholder="Необходимое количество доноров">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="diagnostic">Диагноз реципиента<br>
                    <input type="text" v-model="request.diagnostic" class="reg-field__input" id="diagnostic" placeholder="Введите название болезни">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="hospital-name">Центр крови<br>
                    <input type="text" v-model="request.hospitalName" class="reg-field__input" id="hospital-name" placeholder="Введите название больницы реципиента">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="deadline">Крайний срок сдачи<br>
                    <input type="number" v-model="request.deadline" class="reg-field__input" id="deadline" placeholder="Введите сроки (от 2 до 10 дней от сегодня)">
                </label>
            </div>
            <div class="reg-field__wrap non-bottom-line">
                <label for="photo">Фото реципеента<br>
                    <input type="file" @change="processFile($event)" class="reg-field__input" id="photo" placeholder="Зугразить">
                </label>
            </div>
            <div class="reg-field__wrap non-bottom-line ">
                <p class="details">Укажите как можно больше деталей, которые помогут нам немедленно отреагировать на вашу заявку:</p>
                <textarea name="" v-model="request.details" rows="10" class="reg-field__input details-text-area" placeholder="Ваше сообщение"></textarea>

            </div>
            <div class="reg-field__wrap non-bottom-line">
                <input type="checkbox"  v-model="agree" id="agree" required>
                <label for="agree" class="agree-text">Даю согласие на обработку персональных данных (согласно закону Украины "О защите персональных данных") от 1 июня 2010 года, №2297-VI</label>
            </div>
            <button class="button">Создать заявку</button>
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
        data: function(){
            return {
                formData:{
                    donationType:["плазма", "цельная кровь", "тромбоциты", "эритроциты"],
                    bloodType: ["первая (O)","вторая (A)","третья (B)","четвертая (AB)"],
                    rhesus: ["положительный","отрицательный"]


                },
                request:{
                    name:"",
                    surname:"",
                    date:"",
                    login:"",
                    nameContact:"",
                    surnameContact:"",
                    middleNameContact:"",
                    phoneContact:"",
                    donationType:"",
                    bloodType:"",
                    donorQuantity:"",
                    rhesus:"",
                    diagnostic:"",
                    hospitalName:"",
                    deadline:"",
                    photo:"",
                    details:""

                },
                isDateErr:"",
                agree: false
            }
        },
        components:{
            'notation': notation
        },
        computed:{
            nameRec: {
                get: function () {
                    return this.request.name + ' ' + this.request.surname
                },
                set: function(newValue){
                    var arr = newValue.split(" ");
                    this.request.name = arr[0];
                    this.request.surname = arr[1];

                }
            },
            nameContact:{
                get: function () {
                    return this.request.surnameContact + ' ' + this.request.nameContact + ' ' + this.request.middleNameContact
                },
                set: function(newValue){
                    var arr = newValue.split(" ");
                    this.request.surnameContact = arr[0];
                    this.request.nameContact = arr[1];
                    this.request.middleNameContact = arr[2];
                }
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
            },
            sendRequest: function(){
                if (this.agree === false) return;
                var then = this;

                const config = { headers: {'Content-Type': 'application/json'}};
                axios.post('request', then.request, config)
                        .then(function (response) {
                            console.log(response.data);

                        })
                        .catch(function (error) {
                            console.log(JSON.stringify(then.request));
                            console.log(then.request.photo);
                            console.log(error);
                        });
            },
            processFile: function(e){
                this.request.photo = e.target.files[0]
            }
        }
    }
</script>

<style lang="scss" scoped>
/*    .request-wrap{
        padding: 10px;
    }*/
    .request-form {
        text-transform: uppercase;
        color: #9a9a9a;
        padding: 10px;
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
    .select{
        appearance: inherit;
    }
    .details{
        text-transform:none;
    }
    .details-text-area{
        border: 1px solid gray;
    }
    .agree-text{
        text-transform: none;
    }
    .non-bottom-line{
        border-bottom: none;
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
    .err{
        box-shadow: 0 0 5px 2px red;
    }
</style>