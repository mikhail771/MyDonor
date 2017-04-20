<template>

  <div id="app">
  <div class="title"> <span><i class="fa fa-cogs" aria-hidden="true"></i> Панелюшка админчика </span> <button @click="toggleAdd" class="addbutton">{{capt}} </button></div>
  <div class="search"><i class="fa fa-search" aria-hidden="true"></i> <input type="text"  placeholder="Какой банк будете искать?" class="searchfield" v-model="keyword"></div>
   
  <form  class="add" v-if="show">
  <div><input type="text" :class="{error:classErrorB, valid:classValid}"  v-model="newBank"  autofocus placeholder="Банк" required></div> <div> <input type="text" :class="{error:classErrorL, valid:classValid}" v-model="newLocation" placeholder="Адрес" required> <input type="submit"  class="fa" value=" Добавить банк" @click.stop.prevent="addNext"> </div></form>
  
  <i-list :dat="store" :keyword="keyword" @updateStore="store = $event"> </i-list>
  </div>
</template>

<script>
import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'


Vue.use(VueAxios, axios)
import List from './Item.vue';
import { required} from 'vuelidate/lib/validators'
export default{
  data: function(){
    return{
      store: [],
      newBank: '',
      newLocation: '',
      show: false,
      capt: 'Добавить банк',
     keyword: '',
     classErrorB: false,
     classErrorL:false,
     classValid: false
    }
  },
   validations: {
    newBank: {
      required
    },
    newLocation: {
      required
    }
  },
 components:{
    'i-list': List
  },
  methods:{
    addNext: function(){ 
      var thi = this;
      if(thi.newBank && thi.newLocation) {
      const config = { headers: {'Content-Type': 'application/json'}};
      axios.post('https://dry-island-77618.herokuapp.com/banks', {
      name: this.newBank,
    address: this.newLocation
  
    
  }, config)
  .then(function (response) {
    thi.store = response.data;

  })
  .catch(function (error) {
    console.log(error);
  });
      this.newBank='';
      this.newLocation='';
       this.show = !this.show;
       thi.classErrorB = false;
   thi.classErrorL = false;
    
  } else if(!thi.newBank){
   thi.classErrorB = true;
   thi.classErrorL = false }

   else if(!thi.newLocation){
   thi.classErrorL = true ;
   thi.classErrorB = false}



},
  
    toggleAdd: function(){
      this.show = !this.show;
      this.classErrorL = false; 
   this.classErrorB = false;
    },
    place: function(){
      if(this.store.length == 0){
        return true;
      } else{
        return false
      }
    },
    retData: function(){
      const api = 'https://dry-island-77618.herokuapp.com/banks'
      Vue.axios.get(api).then(response=> {
        this.store = response.data
      }).catch(error=>{
        console.log('error')
        this.store = []
      })
    }
  },
  beforeMount(){
    this.retData()
  }  
}
</script>

<style lang="scss" scoped>
input{
  border:none;
  padding:5px;
  border-radius: 4px;
}
button, input[type="submit"]{
  border: none;
  border-radius:5px;
  background-color: #5b2b19;
  color:#f7eee7;
  outline:none;
  padding:5px;
}
#app{
  width:80%;
  border:1px solid black;
  margin: 0 auto;
  padding:25px;
  border-radius: 5px;
  background-color: rgba(138,7,7,0.4);
  position: relative;
  transform:translateY(10%);
}

.add{
  width:60%;
  margin: 0 auto;
  display:flex;
  justify-content: space-around;
  flex-wrap:wrap;
    
}

@media screen and (max-width:990px){
  .add{
    justify-content:center;
      div{
        width:100%;
      }
      input{
        width:100%;
        margin-bottom: 8px;
      }
  }
  .add button{
    width: 100%;
  }
}

.search{
  display:flex;
  width:60%;
  justify-content:center;
  margin: 0 auto;
  margin-bottom:25px;
  position:relative;
}

.searchfield{
  width:95%;
  padding:10px 25px;
  border-radius: 3px;
  border:none;
  outline: none;
  margin-top:30px;

}

.title{
  width:100%;
  height:40px;
  background-color: rgba(20,133,204,0.4);
  position:absolute;
  top:0;
  left:0;
  display:flex;
  justify-content:space-between;
  box-sizing:border-box;
  color:#f7eee7;
  padding:{
    left:20px;
    right:20px;
  }
  span{
    font-size: 25px;
    font-weight: bold;
    line-height: 1.5;
  }
  // i{
  //   position: absolute;
  //   top:0;
  // }
}
.addbutton{
  height:30px;
  margin:5px;
  // position: absolute;
  // top:7%;
}
.placeholder{
  width:100%;
  height:50px;
  display:flex;
  justify-content:center;
  align-items:center;
}

.fa-search{
  position:absolute;
  top:38px;
  left:5px;
  color:grey;
}
  .error {
  border-color: red;
  background-color: #FDD;
  border:1px solid red;
  border-radius:none;
}

.error:focus {
  outline-color: #F99;
}

.valid {
  border-color: #5A5;
  background: #EFE;
}

.valid:focus {
  outline-color: #8E8;
}

</style>
