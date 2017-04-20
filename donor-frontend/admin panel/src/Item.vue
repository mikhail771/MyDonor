<template>
	<div id="item">
	<ul>
	<li class="head"><span>Банк:</span><span>Адрес:</span></li>
		<li v-for="item in filteredList"><span> {{ item.name }}  </span> <span> {{ item.address }} </span> <i class="fa fa-trash" aria-hidden="true" @click="deleteList(id)"></i></li>
		</ul>
	</div>
</template>

<script>
	export default{
		props:['dat', 'keyword'],
		
		computed:{
     filteredList(){
        return this.dat.filter((item) =>{
          return item.name.toLowerCase().includes(this.keyword.toLowerCase());
        });
      }
      
  },
  methods:{
  	deleteList: function(id) {
      // var index = this.lists.indexOf(list);
      this.dat.splice(id, 1);
    }
  }

	}
</script>

<style lang="scss"scoped>
$post: rgba(20,133,204,0.4);
ul{
	padding:0;
}
li{
	list-style-type: none;
	display:flex;
	overflow-x:hidden;
	word-wrap:break-word;
	justify-content: space-around;
	align-items:center;
	width: 50%;
	margin: 0 auto;
	border:1px solid black;
	margin-bottom:10px;
	background-color: $post;
	padding: 20px;
	color:#5b2b19;

		span{
			width:45%;
		}
	&:hover{
		background-color: lighten($post, 20%);
	};
}

.head{
	font-weight: bold;
	font-style: italic;
	font-size: 20px;
	padding:{
		top:5px;
		bottom:5px;
	}
	
}

	.fa-trash{
		cursor: pointer;
	}
</style>