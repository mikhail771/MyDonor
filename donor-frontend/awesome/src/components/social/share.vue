<template>
    <div class="social">
        <div class="text">Поделиться:</div>
        <div class="share-item fb"></div>
        <div class="share-item vk"></div>
    </div>
</template>

<script>

</script>

<style lang="scss" scoped>
    .social{
        display: flex;
        justify-content:flex-start;
        align-items: center;
    }
    .text{
        flex-basis: 50px;
        margin-right:25px;
    }
    .share-item{
        flex-basis: 25px;
        height: 25px;
        margin-right:10px;
        cursor: pointer;
    }
    .fb{
        background: url(../../assets/Facebook.svg) center no-repeat;
    }
    .vk{
        background: url(../../assets/vk.svg) center no-repeat;

    }
</style>