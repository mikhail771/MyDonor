import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import Registration from './components/registration/App.vue';
import Bids from './components/bids/App.vue';
import Feed from './components/feed/App.vue';
import Login from './components/login/login.vue';


Vue.use(VueRouter);

var router = new VueRouter({
<<<<<<< Updated upstream
  mode: 'history',
=======
mode: 'history',
>>>>>>> Stashed changes
  routes: [
    {path: "/registration", component: Registration},
    {path: "/bids", component: Bids},
    {path: "/", component: Feed},
    {path:"/login", component: Login}
  ]
});

new Vue({
  el: '#app',
  render: h => h(App),
  router: router
});
