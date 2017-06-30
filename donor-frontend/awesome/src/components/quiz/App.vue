<template>
	<div class="app">
		<component :is="current"> </component>
	</div>
</template>

<script>
import { store } from "../../store/store.js"
import start from "./questions/One.vue"
import answers from "./answers/App.vue"
import final from './answers/Final.vue';

	export default{
		computed:{
			current: function(){
				return store.state.quizComponent;
			} 
		},
		components:{
			'q-start': start,
			'q-answer': answers,
			'q-final': final
		}
	}
</script>

<style lang="scss" scoped>
@media only screen and (min-width: 600px){
  .app{
    width:700px;
    margin: 0 auto;
  }
}
</style>