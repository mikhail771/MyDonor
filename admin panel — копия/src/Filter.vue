<template>
<ul>
	<li class="head">Банк:</span><span> Адрес:</span></li>
	<i-tems> </i-tems>
</ul>
</template>

<script>
import Items from './Item.vue'
	export default{
		 data: function(){
    return{
     keyword: ''
    }
  },
  props: ['store', 'keyword'],
		components:{
			'i-tems': Items
		},
		  computed:{
     filteredList(){
        return this.store.filter((item) =>{
          return item.bank.toLowerCase().includes(this.keyword.toLowerCase());
        });
      }
  }
	}
</script>

<style>
	
</style>