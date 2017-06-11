<template>
	<div class="post" @click="toggleDetails">
			<div class="image"></div>
			<div>
				<span class="name">{{elem.bidUserName}}</span>
			</div>
			<div>
				<span class="age">18 лет</span>
			</div>
			<div class="info">
				<span>{{elem.bidInfo}}</span>
			</div>
			<div :class="{extend:!extend, hide:extend}"></div>
			
			<div class="details" v-if="extend">
				<div class="detailImage"></div>
			 	<div>{{elem.bidComments}}</div>
			 	<router-link to="/"><div class="goToBid"></div></router-link>
			 </div>
			<hr v-if="!extend">

	</div>
</template>

<script>

export default{
	props:['elem'],
	data:function(){
		return{
			extend: false
		}
	},
	methods:{
		toggleDetails: function(){
			this.extend = !this.extend;
		}

	}
}
</script>

<style lang="scss" scoped>

hr{
	width:90%;
	height:1px;
	border:none;
	background-color: #F77777;
}
.post{
	width:100%;
	position:relative;
	box-sizing:border-box;
	margin-bottom:10px;

}

.name, .age, .info{
	padding-left:10px;
}
.image{
	width:90px;
	height:90px;
	border-radius: 50%;
	margin:0 auto;
	background-color: grey;
	background-image: url("/src/assets/face.svg");
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: auto;
	box-shadow: 0 0 5px grey;
}

.detailImage{
	@extend .image;
	width:200px;
	height:200px;
}

.name{
	font-size: 20px;
	color:#F77777;
}

.extend{
	width:20px;
	height:10px;
	margin:0 auto;
	position:relative;
	&:before{
		content:"";
		display:block;
		width:1px;
		height:1px;
		border: 10px solid transparent;
		border-top: 10px solid #F77777;
		position:absolute;
		transform: translateY(-1px);
	}
}

.hide{
	@extend .extend;
	transform:scaleY(-1);
}

.details{
	width:100%;
	background-color: #F77777;
	color:white;
	padding:16px;
	box-sizing:border-box;
	position:relative;
}

.goToBid{
	width:30px;
	height: 15px;
	background-image: url("/src/assets/StrelaWhite.svg");
	background-size: 80%;
	background-repeat: no-repeat;
	background-position: 50% 50%;
	position:absolute;
	right:12px;
	bottom:0px;
	margin-bottom:10px;
}
@media only screen and (min-width: 600px){
	.post{
		width:700px;
	}
}
</style>