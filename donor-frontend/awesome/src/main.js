import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';
// import Registration from './components/registration/App.vue';
import Bids from './components/bids/App.vue';
import Feed from './components/feed/App.vue';
import Login from './components/login/login.vue';
import notFound from './components/notFound/NotFound.vue';
import authorization from './components/autorizastion/App.vue';
import request from './components/request/App.vue';
import profile from './components/profile/App.vue';
import maps from './components/Maps/App.vue';
import recipient from './components/recipient/App.vue';
import protivopokazanija from './components/static/protivopokazanija.vue';
import trombocity from './components/static/trombocity.vue';
import plazma from './components/static/plazma.vue';
import wholeBlood from './components/static/whole-blood.vue';
import bloodComponent from './components/static/komponenty-i-krov.vue';


Vue.use(VueRouter);

var router = new VueRouter({
  mode: 'history',
  scrollBehavior (to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { x: 0, y: 0 }
    }
  },
  routes: [
    {path: "/registration", component: authorization},
    {path: "/bids", component: Bids},
    {path: "/", component: Feed},
    {path:"/login", component: Login},
    {path:"/request", component: request},
    {path: "/profile", component: profile},
    {path: "/search", component: maps},
    {path: "/recipient", component: recipient},
    {path: "/contraindications", component: protivopokazanija},
    {path: "/trombocity", component: trombocity},
    {path: "/plazma", component: plazma},
    {path: "/whole-blood", component: wholeBlood},
    {path: "/blood-component", component: bloodComponent},
    {path: "*", component: notFound}
  ]
});

new Vue({
  el: '#app',
  render: h => h(App),
  router: router
});
