<template>
    <div id="app">
        <div id="imgWrap">
            <img src="assets/vinni-pyx.jpg" alt="Vinni" id="profilePicture">
            <div id="titleForProfileImg"><p>{{dataValue.name}}</p> </div>
        </div>
        <p id="date">Добавлено  {{dataValue.addDate}}  </p>
        <section id="mainInfo">
            <p>{{dataValue.disease}}</p>
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
            <p><b>Возраст:</b> <br />
                {{dataValue.age}} лет
            </p>

            <p><b>Нужны доноры:</b><br />
                {{dataValue.bloodGroup}} <br />
                {{dataValue.bloodType}}
            </p>
            <p><b>Центр крови:</b><br />
                {{dataValue.place}} <br />
                {{dataValue.adress}}
            </p>
            <p>Ребенок проходит курс интенсивной химиотерапии в детском отделении, проходит первый курс ﴾назначено всего
                шесть﴿. Во время такого лечения очень быстро понижаются жизненно важные показатели крови ﴾тромбоциты,
                гемоглобин﴿, организму очень трудно восстанавливаться самостоятельно. Для эффективного лечения на каждый курс
                необходимо 5 доноров тромбоцитной массы.
            </p>
            <p>
                Вот что пишут о девочке на сайте помощи онкобольным детям:
            <p id="redLine" v-model="redLine">
                "С лета 2016 года девочка периодически жаловалась на боли в ноге. В феврале 2017 уже стало больно становиться на ногу. Обратились к травматологу в поликлинике. Сделали рентген и направили ребенка в областную больницу. После недели обследования предположили три диагноза и порекомендовали родителям искать клинику. Приехали в НИР. Оформили статус переселенца и с марта 2017 года Ксения начала лечение в отделении детской онкологии Национального института рака."
            </p>
            </p>

            <i v-model="diseaseDescription"> <b>Саркома Юинга</b> (лат. Myeloma endotheliale)‐ злокачественная опухоль костного скелета. Саркома Юинга, как правило, поражает нижнюю часть длинных трубчатых костей, ребра, таз, лопатку, позвоночник и ключицу.</i>
            <footer>
                <ul>
                    <li><a href="#"><img src="assets/32/facebook.png" alt=""></a></li>
                    <li><a href="#"><img src="assets/32/skype.png" alt=""></a></li>
                    <li><a href="#"><img src="assets/32/twitter.png" alt=""></a></li>
                </ul>
            </footer>
        </section>

    </div>
</template>

<script>
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
                }
            }
        } //data

    }
</script>

<style scoped>
    #profilePicture{
        width: 100%;
    }
    #titleForProfileImg{
        padding: 5px 40px;
        background-color: white;
        opacity: 0.7;
        position: absolute;
        bottom: 50px;
        overflow: auto;
        margin: auto;
        right: 20%; left: 20%;
    }
    #titleForProfileImg p{
        opacity: 1 !important;
        color: red;
        font-size: 18pt;
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
    }
    b{
        font-size: 110%;
    }
</style>
