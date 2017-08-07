<template>
    <div class="trombocity-preview-wrap">
        <div class="img-wrap">
            <img src="http://photodnepr.com.ua/dist/trombocity.jpg" alt="trombocity">
        </div>
        <p>Процедура сдачи тромбоцитов
            преимущественно занимает два дня и
            требует большего участия донора, чем
            при даче крови на эритроцитарную массу.</p>

        <p>В первый день донор проходит
            обследование, а на второй -
            непосредственно сдает тромбоциты.
        </p>
        <p>Обследование происходит на станции
            переливания крови или в отделении
            переливания крови, которое находится
            в больнице. Его лучше сделать с 9 до
            11 утра.</p>
        <router-link to="/trombocity">
            <div class="arrow"></div>
        </router-link>
    </div>
</template>

<script>

</script>

<style lang="scss" scoped>
    .trombocity-preview-wrap{
        background-color: #e98282;
        padding: 10px 10px 30px 10px;
        position: relative;
        color:white;
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
        background-color: #fff;
    }
    img {
        max-width: 100%;
        display: block;
    }
@media only screen and (min-width: 600px){
  .trombocity-preview-wrap{
    width:701px;
    margin: 0 auto;
  }
}
</style>