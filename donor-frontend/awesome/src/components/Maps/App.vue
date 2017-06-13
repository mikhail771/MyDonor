<template>
	<div class="app">
		<iframe width="100%" height="325" frameborder="0" style="border:0"
:src="link" allowfullscreen></iframe>
	</div>
</template>

<script>
import {store} from "../../store/store.js"
	export default{
		data:function(){
			return{
				place: store.state.place,
				link: ""
			}
		
		},
		methods:{
			query: function(){
				this.link = "https://www.google.com/maps/embed/v1/search?q=станция+переливания+крови+возле+" + this.place + "&key=AIzaSyAO0Ju6FOiKKWYpbv-CDHJ9aq9Ff4NOy9g"
			}
		},
		beforeMount(){
			this.query();
		}
	}
</script>

<style lang="scss" scoped>
	
</style>