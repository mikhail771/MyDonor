<template>
	<div class="post" @click="toggleDetails">
	<div class="date"> {{elem.bidTime}}</div>
	<div class="container">
	<div class="title">
		<div class="image"> </div>
	</div>
	<div class="general">
		<div>
				<span class="name">{{elem.bidUserName}}</span>
			</div>
			<div>
				<span class="age">18 лет</span>
			</div>
			<div class="info">
				<span>{{elem.bidInfo}}</span>
			</div>
			<hr v-if="!extend">
		</div>	
	</div>
	<div :class="{extend:!extend, hide:extend}"></div>
	<router-link to="/recipient">
		<div class="details" v-if="extend">
				<div class="detailImage"></div>
			 	<div class="detail-description">{{elem.bidComments}}</div>
			 	<div class="goToBid"></div>
			 </div>
			 </router-link>
	</div>
</template>

<script>
import { store } from "../../store/store.js"
export default{
	props:['elem'],
	data:function(){
		return{
			extend: false,
			day:0,
			month:"",
			year: 0,
			id: this.elem.id
		}
	},
	methods:{
		toggleDetails: function(){
			this.extend = !this.extend;
			store.state.userId = this.id;
		},
		// TEMPORARY I GET CURRENT DATE FOR EACH BID
		getDate:function(){
			var getDate = new Date();
			var totalDate = getDate.getTime();
			var formattedDate = new Date(totalDate);
			var finalDate = formattedDate.toString().split(" ");
			var currentDate = finalDate.splice(0,5);
			this.day = currentDate.join(" ");

		}

	},
	beforeMount(){
		this.getDate();
	}
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css?family=Yeseva+One&subset=cyrillic');
hr{
	width:100%;
	height:1px;
	border:none;
	background-color: rgba(90,90,90,0.2);
	transform:translateY(20px);
}

a{
	text-decoration:none;
}
.post{
	width:97%;
	margin:0 auto;
	background-color: white;
	position:relative;
	box-sizing:border-box;
	margin-bottom:5px;
	padding-bottom: 10px;
	padding-top: 10px;
	box-shadow: 0 0 5px rgba(100, 100, 100, 0.4);

}

.date{
	padding-right:10px;
	font-size: 11px;
	color:rgba(140,140,140,0.8);
	display:flex;
	justify-content:flex-end;
}

.container{
	width:98%;
	height:98%;
	background-color: white;
	margin: 0 auto;
	padding:10px;
	box-sizing: border-box;
	border-radius: 2px;
	display:flex;
}
.title{
	width:100px;
	height:100%;
}

.general{
	width:80%;
}
.name, .age, .info{
	padding-left:10px;
}
.image{
	width:90px;
	height:90px;
	border-radius: 50%;
	background-color: grey;
	background-image: url("~../assets/face.svg");
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: auto;
	box-shadow: 0 0 5px grey;
}

.detailImage{
	@extend .image;
	width:200px;
	height:200px;
	margin: 0 auto;
}

.detail-description{
	border-left: 1px solid white;
	padding-left: 5px;
}
.name{
	font-size: 20px;
	color:#2A5885;
	// font-weight: bold;
	font-family: 'Yeseva One', cursive;
}

.extend{
	width:98%;
	height:20px;
	position:relative;
	background-image: url("~../assets/Spisok.svg");
	background-size: 5%;
	background-repeat: no-repeat;
	background-position: 100% 50%;
}

.hide{
	@extend .extend;
	transform:scaleY(-1);
	background-image: none;
	left:0;
	&:before{
		content:"";
		display:block;
		width:1px;
		height:1px;
		border: 10px solid transparent;
		border-top: 10px solid #F77777;
		position:absolute;
		right:1px;
	}

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
	background-image: url("~../assets/StrelaWhite.svg");
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