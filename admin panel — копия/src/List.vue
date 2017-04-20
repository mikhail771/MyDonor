<template>
	<div>
		<i-tem v-for="item in 6"> </i-tem>
	</div>
</template>

<script>
	import Item from './Item.vue';
export default {
 components:{
  'i-tem': Item
 }
 
}
</script>

<style>
	
</style>