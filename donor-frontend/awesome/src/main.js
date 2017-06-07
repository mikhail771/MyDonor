import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import Registration from './components/registration/App.vue';
import Bids from './components/bids/App.vue';
import Feed from './components/feed/App.vue';


Vue.use(VueRouter);

var router = new VueRouter({
  routes: [
    {path: "/registration", component: Registration},
    {path: "/bids", component: Bids},
    {path: "/", component: Feed}
  ]
});

new Vue({
  el: '#app',
  render: h => h(App),
  router: router
});
