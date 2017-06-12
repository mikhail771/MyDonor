<template>
    <div class="notation">
        <h2 class="notation__title">Войдите или зарегистрируйтесь</h2>
        <p class="notation__text">Если вы являетесь донором или планируете им стать, вход в личный кабинет позволит Вам:</p>
        <ul class="notation__list">
            <li><span>Узнать, где можно сдать кровь</span></li>
            <li><span>Заносить данные о своих кроводачах</span></li>
            <li><span>Просматривать свою историю донороства</span></li>
            <li><span>Установить напоминание о следующей кроводаче</span></li>
        </ul>
        <p class="notation__text">Если Вы хотите зарегистрироваться в качестве нового донора крови, то Ваш возраст должен быть от 18 до 60 лет.</p>
    </div>
</template>

<script>


</script>

<style lang="scss" scoped>
    .notation{
        background-color: #3a63a2;
        color:#fff;
        padding: 10px;
    }
    .notation__list{
       list-style: circle;
       color: red;
    }
    .notation__list span{
        color: #fff;
    }
</style>