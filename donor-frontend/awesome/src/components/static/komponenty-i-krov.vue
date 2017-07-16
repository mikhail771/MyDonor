<template>
<div class="app">
    <div class="wrap">
        <div class="whole-blood">
            <div class="img-wrap">
                <img src="http://photodnepr.com.ua/dist/whole-blood.jpg" alt="whole blood">
            </div>


           <p> Процедура сдачи крови и компонентов</p>

            <h2>Цельная кровь</h2>

           <p> Донорство крови можно разделить на
            виды. Это донорство цельной крови -
            эритроцитной массы и донорство
            компонентов крови - тромбоциты и
            плазма.</p>

           <p> Процесс сдачи цельной крови
            состоит из двух частей - медосмотра
            и кроводачи и занимает максимум
            30-40 минут, если не учитывать
            деталей, связанных с очередями. В
            целом вам стоит выделить 3 часа,
            учитывая время, что вы используете,
            чтобы добраться до и от станции
            переливания крови и время,
            которое вы проведете на самой
            станции.</p>
            <router-link to="/whole-blood">
                <div class="arrow"></div>
            </router-link>


        </div>

        <div class="switch-line">
            <div class="switch-item" :class="[currentView === 'plazma' ? 'triangle' : '']" @click="changeView('plazma')">
                <div class="img-wrap">
                    <img class="kostyl" src="http://photodnepr.com.ua/dist/plazma.jpg" alt="plazma">
                </div>

                <h3>Плазма</h3>
            </div>
            <div class="switch-item" @click="changeView('trombocity')" :class="[currentView === 'trombocity' ? 'triangle' : '']">
                <div class="img-wrap">
                    <img src="http://photodnepr.com.ua/dist/trombocity.jpg" alt="trombocity">
                </div>
                <h3>Тромбоциты</h3>
            </div>
        </div>
        </div>
        <component :is="currentView"></component>


    </div>
</template>

<script>
    import Vue from 'vue';

    import plazma from './plazama-preview.vue';
    import trombocity from './trombocity-preview.vue';



    export default {
        data: function(){
            return {
                currentView : "plazma"
            }
        },
        components:{
            plazma:plazma,
            trombocity:trombocity

        },
        methods:{
            changeView: function (view){
                this.currentView = view;
            }
        }

    }
</script>

<style lang="scss" scoped>
.app{
    width:100%;
    background-color: #e98282;
}
    .wrap{
        color: #fff;
    }
    .whole-blood{
        background-color: #e98282;
        padding: 0 10px 20px 10px;
        position: relative;
    }
    .whole-blood::after{
        content: "";
        display: block;
        width: 1px;
        height: 1px;
        border: 10px solid transparent;
        border-top: 10px solid #e98282;
        position: absolute;
        left: 50%;
        transform: translateY(20px) translateX(-5px);
    }
    .img-wrap{
        border-radius: 50%;
        overflow: hidden;
        width: 200px;
        height: 200px;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 0 auto;
        transform: translateY(20px);
        margin-bottom: 30px;
        box-shadow: 0 0 5px grey;
    }
    img {
        max-width: 100%;
        display: block;
    }
    .kostyl{
        max-width: none;
        max-height: 100%;
    }

    .arrow{
        cursor: pointer;
        width: 30px;
        height: 30px;
        background: url('http://photodnepr.com.ua/dist/StrelaWhite.svg') center no-repeat;
        position: absolute;
        bottom: 15px;
        right: 15px;
    }
    .switch-line{
        display: flex;
        background-color: white;
        padding: 0 10px 20px 10px;
        color: #e98282;

    }
    .switch-line .img-wrap{
        width: 100px;
        height: 100px;
    }
    .switch-item{
        flex-grow: 1;
        position: relative;
    }
    .triangle::after{
        content: "";
        display: block;
        width: 1px;
        height: 1px;
        border: 10px solid transparent;
        border-bottom: 10px solid #e98282;
        position: absolute;
        bottom: 0;
        left:50%;
        transform: translateY(20px) translateX(-5px);
    }

    h1 {
        text-align: center;
        background-color: #e98282;
        color:#fff;
        padding: 10px;
        font-size: 1.6em;
        position: relative;
        margin-top: -65px;
    }
    h2{
        font-size: 1.3em;

    }
    h3{
        text-align: center;
    }
    .head-title{
        color: #343434;
    }
@media only screen and (min-width: 600px){
  .wrap{
    width:700px;
    margin: 0 auto;
  }
}
</style>
