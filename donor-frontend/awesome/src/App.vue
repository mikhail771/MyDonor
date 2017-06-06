<template>
  <div id="app">
<app-menu @goTo="index = $event"></app-menu>
<transition name="slide-fade" mode="out-in">
<keep-alive>
   <component :is="currentSlide"> </component>
   </keep-alive>
   </transition>

   
  </div>
</template>

<script>
import menu from './components/menu/App.vue'
import bids from './components/bids/App.vue'
import feed from './components/feed/App.vue'
import registration from './components/registration/App.vue'


export default {
  data: function(){
    return{
      index:0,
      elements: ['app-feed','app-bids','app-registration']
    }
  },
  computed:{
      currentSlide: function(){
        return this.elements[this.index];
      }
    },

  components:{
    'app-menu': menu,
    'app-bids': bids,
    'app-feed': feed,
    'app-registration': registration
  }
  
}
</script>

<style lang="scss">
.app{
  overflow: hidden;
}
.slide-fade-enter-active {
      transition: all 0.5s ease;
    }
    .slide-fade-leave-active {
      transition: all 0.5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
    }
    .slide-fade-enter{
      transform: translateX(-400px) scale(0.8, 0.8);
      opacity: 0;
    }
     .slide-fade-leave-to{
      transform: translateX(400px) scale(0.8, 0.8);
      opacity: 0;
    }
</style>
