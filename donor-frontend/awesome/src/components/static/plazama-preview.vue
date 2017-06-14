<template>
    <div class="plazma-preview-wrap">
        <div class="img-wrap">
            <img src="../../assets/plazma.jpg" alt="plazma">
        </div>
        <p>      Донорство плазмы крови базируется
            на аналогичном методе сдачи
            компонентов крови - тромбоцитов и
            занимает до 2-х часов в течение
            одного дня. При ручном плазмаферезе
            кровь забирается в стерильную
            систему (как при обычной процедуре
            кроводачи), центрифугуется,
            разделяется на эритроцитарную массу
            и плазму с использованием
            плазмоекстрактора, после чего
            эритроцитарная масса возвращается
            донору. Объем циркулирующей крови
            восполняется введением адекватного
            количества физиологического
            раствора.</p>

        <p>      При автоматическом плазмаферезе
            донор через специальную систему
            подключается к сепаратору,
            забирается непосредственно плазма
            крови.</p>
        <router-link to="/plazma">
            <div class="arrow"></div>
        </router-link>
    </div>
</template>

<script>

</script>

<style lang="scss" scoped>
    .plazma-preview-wrap{
        background-color: #e98282;
        padding: 10px 10px 30px 10px;
        position: relative;
    }
    .arrow{
        cursor: pointer;
        width: 30px;
        height: 30px;
        background: url(../../assets/StrelaWhite.svg) center no-repeat;
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
        max-height: 100%;
        display: block;
    }

</style>