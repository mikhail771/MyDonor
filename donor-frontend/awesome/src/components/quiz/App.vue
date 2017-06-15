<template>
	<div class="app">
		<component :is="current"> </component>
	</div>
</template>

<script>
import { store } from "../../store/store.js"
import start from "./questions/One.vue"
import answers from "./answers/App.vue"
	export default{
		computed:{
			current: function(){
				return store.state.quizComponent;
			} 
		},
		components:{
			'q-start': start,
			'q-answer': answers
		}
	}
</script>

<style lang="scss" scoped>
	
</style>