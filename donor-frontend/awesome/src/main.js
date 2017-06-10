import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
import Registration from './components/registration/App.vue';
import Bids from './components/bids/App.vue';
import Feed from './components/feed/App.vue';
import Login from './components/login/login.vue';
import notFound from './components/notFound/NotFound.vue';
import authorization from './components/autorizastion/App.vue';


Vue.use(VueRouter);

var router = new VueRouter({
  mode: 'history',
  routes: [
    {path: "/registration", component: authorization},
    {path: "/bids", component: Bids},
    {path: "/", component: Feed},
    {path:"/login", component: Login},
    {path: "*", component: notFound}
  ]
});

new Vue({
  el: '#app',
  render: h => h(App),
  router: router
});
