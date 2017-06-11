<template>
    <div id="app">
        <app-menu></app-menu>
        <transition name="slide-fade" mode="out-in">
            <keep-alive>
                <router-view></router-view>
            </keep-alive>
        </transition>

         <transition name="fade">
   <a href="#top" class="toTop" v-if="scrolled"></a>
   </transition>
        <app-footer></app-footer>

    </div>
</template>

<script>
    import menu from './components/menu/App.vue'
    import footer from './components/footer/Footer.vue'

    export default {
        data: function(){
            return{
                scrolled: false
            }
        },
        components:{
            'app-menu': menu,
            'app-footer': footer
        },
        methods: {
  handleScroll () {
      this.scrolled = window.scrollY > 100;
    
  }
},
created () {
  window.addEventListener('scroll', this.handleScroll);
},
destroyed () {
  window.removeEventListener('scroll', this.handleScroll);
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

    .toTop{
  display: block;
  width:57px;
  height:57px;
  border-radius:5px;
  background-color: white;
  background-image: url('~./assets/css_sprites.png');
  background-size: auto;
  background-repeat: no-repeat;
  background-position: -11px -88px;
  position:fixed;
  bottom:10px;
  right:120px;
  z-index:10000;
  cursor: pointer;
  @media screen and (min-width:300px) and (max-width:1100px){
      right:10px;
      bottom:50px;
    }
}

// To top button animation
.fade-enter-active {
      transition: all 1.5s ease;
    }
    .fade-leave-active {
      transition: all 1.5s ease;
    }
    .fade-enter{
      opacity: 0;
    }
     .fade-leave-to{
      opacity: 0;
    }
</style>
