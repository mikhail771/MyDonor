<template>
  <div id="app">
   <header>{{day}}<!--  {{month}} {{year}} --></header>
    <article>
      <h3>Текущие уровни запасов крови в Украине</h3>
      <section>
        <figure>
          <img src="http://photodnepr.com.ua/dist/Blood.svg" alt="blood O-" />
          <p>O-</p>
          <figcaption> {{dataValue.o0}} дней</figcaption>
        </figure>
        <figure>
          <img src="http://photodnepr.com.ua/dist/Blood.svg" alt="blood AB-" />
          <p>AB-</p>
          <figcaption> {{dataValue.a0}} дней</figcaption>
        </figure>
        <figure>
          <img src="http://photodnepr.com.ua/dist/Blood.svg" alt="blood O+" />
          <p>O+</p>
          <figcaption> {{dataValue.o1}} дней</figcaption>
        </figure>
        <figure>
          <img src="http://photodnepr.com.ua/dist/Blood.svg" alt="blood A+" />
          <p>A+</p>
          <figcaption> {{dataValue.a1}} дней</figcaption>
        </figure>
        <figure>
          <img src="http://photodnepr.com.ua/dist/Blood.svg" alt="blood B+" />
          <p>B+</p>
          <figcaption> {{dataValue.b1}} дней</figcaption>
        </figure>
        <figure>
          <img src="http://photodnepr.com.ua/dist/Blood.svg" alt="blood AB+" />
          <p>AB+</p>
          <figcaption> {{dataValue.ab1}} дней</figcaption>
        </figure>
      </section>
      <section id="aboutBlood">
        <h3>Об уровне запасов крови</h3>
        <p>Несчастья невозможно спрогнозировать заранее. Поэтому в критической ситуации Центр крови вынужден приглашать на сдачу крови больше доноров, чем обычно. В Украине меньше доноров, чем должно было бы быть для того, чтобы покрывать нужды больниц в любой ситуации. Спрос крови непредсказуем и даже отличается с каждым типом крови. Например O‐ кровь может назначаться пациентам со всеми типами крови. AB+ подходит только для пациентов с АВ+.</p>
        <p>Срок хранения различных компонентов крови небольшой: эритроцитов, или суспензии красных кровяных телец, – примерно 35 дней; тромбоцитов, или кровяных пластинок, – семь дней, а свежезамороженной плазмы – до трех лет. По этой причине заранее надолго запастись кровью в большом количестве невозможно.</p>
       <router-link id="moreAboutTypeBlood" to="/blood-component"> Узнать больше о типах крови</router-link>
      </section>
    </article>
  </div>
</template>

<script>
    export default {
        data: function () {
            return {
                dataValue: {
                    day: '',
                    month: '',
                    year:"",
                    o0:'7',
                    a0:'8',
                    b0:' 5',
                    ab0:'13',
                    o1:'9',
                    a1:'7',
                    b1:'10',
                    ab1:'4'
                }
            }
        },
        methods:{
          getDate:function(){
      var getDate = new Date();
      var totalDate = getDate.getTime();
      var formattedDate = new Date(totalDate);
      var finalDate = formattedDate.toString().split(" ");
      var currentDate = finalDate.splice(0,3);
      this.day = currentDate.join(" ");

    }

  },
  beforeMount(){
    this.getDate();
  }
        }

    
</script>

<style lang="scss" scoped>
  #app{
    margin: 0 auto;
    width: 100%;
    padding: 0 10px;
    box-sizing:border-box;
    padding-bottom:35px;
  }

  header{
    border-bottom: 1px solid gray;
    border-right: 1px solid lightgray;
    border-left: 1px solid lightgray;
  }

  section{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-around;
  }

  section figure img{
    width: 170px;
  }

  section figure p{
    font-size: 3em;
    color: white;
    margin-top: -140px;
    text-align: center;
  }

  section figure figcaption{
    text-align: center;
    font-size: 1.5em;
    padding-top: 10px;
  }

  h3{
    margin-bottom: 0;
  }
  #aboutBlood p{
    text-indent: 1.5em;
    text-align: justify;
  }

  #moreAboutTypeBlood{
    font-size: 16px;
    background-color: #DB3328;
    color: white;
    padding: 15px 30px;
    border-radius: 20px;
    cursor: pointer;
    border:none;
    text-decoration: none;
  }

  @media only screen and (min-width: 600px){
  #app{
    width:700px;
    margin: 0 auto;
  }
}

</style>
