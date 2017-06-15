<template>
	<div class="app">
		<iframe width="100%" height="325" frameborder="0" style="border:0"
:src="link" allowfullscreen></iframe>
	</div>
</template>

<script>
import { store } from "../../store/store.js"
	export default{
		
			computed:{
				link: function(){
					return store.state.link;
				} 
			}
		}

</script>

<style lang="scss" scoped>
	
</style>