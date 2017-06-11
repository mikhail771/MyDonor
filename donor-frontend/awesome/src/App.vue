<template>
    <div id="app">
        <app-menu></app-menu>
        <transition name="slide-fade" mode="out-in">
            <keep-alive>
                <router-view></router-view>
            </keep-alive>
        </transition>
        <app-footer></app-footer>

    </div>
</template>

<script>
    import menu from './components/menu/App.vue'
    import footer from './components/footer/Footer.vue'

    export default {
        components:{
            'app-menu': menu,
            'app-footer': footer
        }
    }
</script>

<style lang="scss">
body{
    margin:0;
    padding:0;
}
#app{
    margin:0;
    padding:0;
}
    // #app{
    //     overflow: hidden;
    // }
    .slide-fade-enter-active {
        transition: all 0.2s ease;
    }
    .slide-fade-leave-active {
        transition: all 0.2s cubic-bezier(1.0, 0.5, 0.8, 1.0);
    }
    .slide-fade-enter{
        transform: translateX(-400px);
        opacity: 0;
    }
    .slide-fade-leave-to{
        transform: translateX(400px);
        opacity: 0;
    }
</style>
