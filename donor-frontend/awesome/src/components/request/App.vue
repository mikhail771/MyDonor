<template>
<!-- app uses class list as function blur identifier (together with list of bids and stories) -->
<div class="app list">
<div class="mainTitle">Подать новую заявку</div>
    <div class="request-wrap">
        <notation></notation>

        <form class="request-form" @submit.prevent="sendRequest">
            <div class="reg-field__wrap">
                <label for="name-rec">Имя и фамилия реципиента<br>
                    <input type="text" required v-model="request.bidUserName" class="reg-field__input" id="name-rec" placeholder="Введите имя и фамилию">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="date">Дата рождения реципиента<br>
                    <input type="text" :class="{ err: isDateErr }" @blur="checkDate" required class="reg-field__input" id="date" v-model="request.recipientBirthDate" placeholder="Введите дату рождения dd.mm.yyyy">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="email">Введите Ваш Email<br>
                    <input type="mail" required v-model="request.email"class="reg-field__input" id="email" placeholder="Введите Ваш Email">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="name-contact">Контактный человек<br>
                    <input type="text" required v-model="request.bidContactName" class="reg-field__input" id="name-contact" placeholder="Введите ФИО">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="phone-contact">Телефон<br>
                    <input type="tel" required v-model="request.bidContactNumber" class="reg-field__input" id="phone-contact" placeholder="Телефон контактного человека">
                </label>
            </div>

            <div class="reg-field__wrap">
                <label for="donation-type">Тип кроводачи<br>
                    <select v-model="request.bidType" id="donation-type" class="reg-field__input select" required placeholder="Выберите из списка">
                        <option v-for="item in formData.donationType">{{item}}</option>
                    </select>
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="blood-type">Группа крови<br>
                    <select v-model="request.bidGroup" id="blood-type" class="reg-field__input select" required placeholder="Выберите из списка">
                        <option v-for="item in formData.bloodType">{{item}}</option>
                    </select>
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="rhesus">Резусфактор<br>
                    <select v-model="request.bidRhesusFactor" id="rhesus" class="reg-field__input select" required placeholder="Выберите из списка">
                        <option v-for="item in formData.rhesus">{{item}}</option>
                    </select>
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="donor-quantity">Количество доноров<br>
                    <input type="number" v-model="request.bidQuantity" class="reg-field__input" id="donor-quantity" placeholder="Необходимое количество доноров">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="diagnostic">Диагноз реципиента<br>
                    <input type="text" v-model="request.bidInfo" class="reg-field__input" id="diagnostic" placeholder="Введите название болезни">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="hospital-name">Центр крови<br>
                    <input type="text" v-model="request.bidHospital" class="reg-field__input" id="hospital-name" placeholder="Введите название больницы реципиента">
                </label>
            </div>
            <div class="reg-field__wrap">
                <label for="deadline">Крайний срок сдачи<br>
                    <input type="number" v-model="request.bidDate" class="reg-field__input" id="deadline" placeholder="Введите сроки (от 2 до 10 дней от сегодня)">
                </label>
            </div>
            <div class="reg-field__wrap non-bottom-line">
                <label for="photo">Фото реципеента<br>
                    <input type="file" @change="processFile($event)" class="reg-field__input" id="photo" placeholder="Зугразить">
                </label>
            </div>
            <div class="reg-field__wrap non-bottom-line ">
                <p class="details">Укажите как можно больше деталей, которые помогут нам немедленно отреагировать на вашу заявку:</p>
                <textarea name="" v-model="request.bidComments" rows="10" class="reg-field__input details-text-area" placeholder="Ваше сообщение"></textarea>

            </div>
            <div class="reg-field__wrap non-bottom-line">
                <input type="checkbox"  v-model="agree" id="agree" required>
                <label for="agree" class="agree-text">Даю согласие на обработку персональных данных (согласно закону Украины "О защите персональных данных") от 1 июня 2010 года, №2297-VI</label>
            </div>
            <button class="button">Создать заявку</button>
        </form>

    </div>
    </div>
</template>

<script>

    import Vue from 'vue';
    import axios from 'axios';
    import VueAxios from 'vue-axios';
    import notation from './notation.vue';
    import { store } from "../../store/store.js"
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
                    bidUserName:"", 
                    recipientBirthDate:"",
                    email:"",
                    bidContactName:"",
                    bidContactNumber:"",
                    bidType:"",
                    bidGroup:"",
                    bidQuantity:"",
                    bidRhesusFactor:"",
                    bidInfo:"",
                    bidHospital:"",
                    bidComments:"",
                    bidDate:"",
                    bidTime:""

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
            getDate:function(){
            var getDate = new Date();
            var curr_date = getDate.getDate();
            var curr_month = getDate.getMonth();
            var curr_year = getDate.getFullYear();
            // var totalDate = getDate.getTime();
            // var formattedDate = new Date(totalDate);
            // var finalDate = formattedDate.toString().split(" ");
            // var currentDate = finalDate.splice(0,5);
            var currentDate =curr_date + "-" + (curr_month+1) + "-" + curr_year;
            this.request.bidTime = currentDate;

        },
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
                this.getDate();
                const config = { headers: {'Content-Type': 'application/json'}};
                axios.post(store.state.baseRequestUrl +'bids', then.request, config)
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

    .app{
        background-color: #0065BD;
        width:100%;
        background-image: url("~../assets/background.jpg");
         background-size: auto;
         background-repeat:repeat;
    }
      .mainTitle{
    width:100%;
    height:30px;
    padding:20px 0 0 0;
    background-color: transparent;
    font-size: 20px;
  color:white;
  font-family: 'Yeseva One', cursive;
  display:flex;
  justify-content:center;

  }
    .request-form {
        text-transform: uppercase;
        color: #9a9a9a;
        padding: 10px;
        padding-bottom:45px;
        background-color: white;
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


@media only screen and (min-width: 600px){
  .request-wrap{
    width:700px;
    margin: 0 auto;
  }
}

</style>