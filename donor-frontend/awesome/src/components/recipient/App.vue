<template>
    <div id="app">
        <div id="imgWrap">
            <img src="~../assets/girl.jpg" alt="girl" id="profilePicture">
            <div id="titleForProfileImg"><p>{{user.bidUserName}}</p> </div>
        </div>
        <p id="date">Добавлено  {{dataValue.addDate}}  </p>
        <section id="mainInfo">
            <p>{{user.bidInfo}}</p>
            <p><b>Кроводачи</b> <br />
                <span id="heartFull">&hearts;</span>
                <span id="heartFull">&hearts;</span>
                <span id="heartFull">&hearts;</span>
                <span id="heartMiddle">&hearts;</span>
                <span id="heartMiddle">&hearts;</span>
                <span id="heartMiddle">&hearts;</span>
                <span id="heartMiddle">&hearts;</span>
                <span id="heartMiddle">&hearts;</span>
                <span id="heartEmpty">&hearts;</span>
                <span id="heartEmpty">&hearts;</span>
                <span id="heartEmpty">&hearts;</span>
            </p>
            <p><b>Дата рождения:</b> <br />
                {{user.recipientBirthDate}} 
            </p>

            <p><b>Нужны доноры:</b><br />
                {{user.bidGroup}}, резус - {{user.bidRhesusFactor}} <br />
                {{user.bidType}}
            </p>
            <p><b>Контактное лицо:</b><br />
                {{user.bidContactName}} <br />
               <b>Тел:</b> {{user.bidContactNumber}} <br>
               <b>e-mail:</b> {{user.email}}
            </p>
            <p><b>Центр крови:</b><br />
                {{user.bidHospital}} <br />
               
            </p>
            <p>{{user.bidComments}}</p>
            <footer>
                <ul>
                    <li><a href="#"><img src="~../assets/32/facebook.png" alt=""></a></li>
                    <li><a href="#"><img src="~../assets/32/skype.png" alt=""></a></li>
                    <li><a href="#"><img src="~../assets/32/twitter.png" alt=""></a></li>
                </ul>
            </footer>
        </section>

    </div>
</template>

<script>
import { store } from "../../store/store.js"
 import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
    export default {
        data: function () {
            return {
                dataValue: {
                    name: 'Саморядова Ксения',
                    addDate: '17.05.2017',
                    disease:'Саркома Юинга',
                    age:'8',
                    bloodGroup:' A ﴾II﴿ Rh ﴾+﴿ ',
                    bloodType:'Тромбоцитна масса',
                    place:'Национальный институт рака',
                    adress:'Киев, ул.Ломоносова, 33/43, первый этаж',
                    redLine:'',
                    diseaseDescription:''
                },
                user: ""
            }
        },
        methods:{
             retData: function(){
      const api = 'https://dry-island-77618.herokuapp.com/bids/' + store.state.userId
      Vue.axios.get(api).then(response=> {
        // if(response.data.length == 0){
        //   this.loading = false;
        //   this.hiddenLoad = true;
      //   } else{
         this.user = response.data;
         console.log(this.user);

        

      }).catch(error=>{
        console.log('error')
        })
        }
    },
    beforeMount(){
        this.retData();
    }

}
</script>

<style scoped>


    #profilePicture{
        width: 100%;
    }
    #titleForProfileImg{
        padding: 5px;
        background-color: white;
        opacity: 0.7;
        position: absolute;
        bottom: 12px;
        overflow: auto;
        margin: auto;
        right: 20%; left: 20%;
        display:flex;
        justify-content:center;
    }
    #titleForProfileImg p{
        opacity: 1 !important;
        color: red;
        font-size: 16px;
    }
    #imgWrap{
        position: relative;
        /*display: flex;*/
        /*align-items: center;*/
        /*justify-content: center;*/
    }
    #date{
        text-align: right;
        margin-right: 10px;
        color: #95989A;
    }
    #heartFull{
        color: #EE2412; font-size: 45px; font-family: 'Comic Sans MS'; opacity: 1
    }
    #heartMiddle{
        color: #EE2412; font-size: 45px; font-family: 'Comic Sans MS'; opacity: 0.5
    }
    #heartEmpty{
        color: #EE2412; font-size: 45px; font-family: 'Comic Sans MS'; opacity: 0.1;
        border-color: red;
    }
    #redLine{
        border: 2px solid red;
        padding: 20px;
        width: auto;
    }
    footer ul li{
        list-style-type: none; /* Убираем маркеры */
        display: inline;
        padding: 10px;
    }
    footer ul li:first-child{
        margin-left: -40px;
    }

    footer{
        display: flex;
        justify-content: center;
    }
    #mainInfo{
        border-top: 1px solid rgba(0, 0, 0, 0.42);
        padding:12px;
    }
    b{
        font-size: 110%;
    }

@media only screen and (min-width: 600px){
  #app{
    width:700px;
    margin: 0 auto;
  }
}
</style>
