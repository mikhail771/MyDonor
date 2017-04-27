<template>
<div>
		<div class="post" v-if="!classLogic">
		
			<div>
				<span class="name">{{elem.bidUserName}}</span>
			</div>
			<div>
				<span class="post-title">Банк крови: </span> <span>{{elem.bidHospital}}</span>
			</div>
			
			<div>
				<span class="post-title">Количество крови (мл): </span><span>{{elem.bidQuantity}}</span>
			</div>
			
			<div>
				<span class="post-title">Группа крови: </span><span>{{elem.bidGroup}}</span>
			</div>
			<div>
				<span class="post-title">Цена: </span><span>{{elem.bidPrice}}</span>
			</div>
			
			<button class="details" @click="classLogic = !classLogic" :class="{redO: classLogic}">Подробнее...</button>
		
	</div>

	<div class="post"  v-if="classLogic">
		
			<div>
				<span class="name">{{elem.bidUserName}}</span>
			</div>
			<div>
				<span class="post-title">Банк крови: </span> <span>{{elem.bidHospital}}</span>
			</div>
			<div>
				<span class="post-title">Контакты: </span><span>{{elem.bidContacts}}</span>
			</div>
			<div>
				<span class="post-title">Количество крови (мл): </span><span>{{elem.bidQuantity}}</span>
			</div>
			<div>
				<span class="post-title">Дополнительная информация: </span><span>{{elem.bidInfo}}</span>
			</div>
			<div>
				<span class="post-title">Группа крови: </span><span>{{elem.bidGroup}}</span>
			</div>
			<div>
				<span class="post-title">Цена: </span><span>{{elem.bidPrice}}</span>
			</div>
			<div>
				<span class="post-title">Комментарии: </span><span>{{elem.bidComments}}</span>
			</div> 

			<button class="details" @click="classLogic = !classLogic" :class="{redO: classLogic}">Скрыть подробности...</button>
		
	</div>
	
</div>
</template>

<script>

export default{
	props:['elem'],
	data:function(){
		return{
			classLogic: false
		}
	}
}
</script>

<style lang="scss" scoped>
$buttun-color: rgba(80,171,204,0.4);
	body{
	background-color: #f7eee7;
	font-size:24px;
	color:#5b2b19;
}

button{
	border:none;
}

.name{
	display:flex;
	align-items: center;
	/*width:100%;*/
	transform:translate(0,0);
	height:45px;
	padding-left:15px;
	margin-bottom:15px;
	background-color: rgba(20,133,204,0.4);
	border-bottom: 1px solid rgba(0,0,0,0.2);
}
/*.name:after{
	content: '';
    width: 95%;
    border-bottom: solid 1px #570303;
    position: absolute;
    left: 2.5%;
    top: 40px;
    z-index: 1;
}*/
.post{
	width:90%;
	margin:0 auto;
	text-align:justify;
	/*padding:20px;*/
	margin-bottom:10px;
	background-color: rgba(138,7,7,0.4);
	transition:all 0.7s;
	position:relative;
	padding-bottom:10px;
	border: 1px solid rgba(0,0,0,0.2);

}

.post:hover{
	transform:scale(1.04,1.04);
	box-shadow:0 0 12px 2px rgba(80,80,80,0.6);
}


.post div{
	padding-left:45px;
}

.post div:nth-of-type(1){
	font-style: italic;
	padding:0;
	color:#f7eee7;
}

.post-title{
	font-weight:bold;
}

.details, .back{
	display:block;
	width:190px;
	padding:8px;
	text-align:center;
	border-radius:4px;
	background-color: $buttun-color;
	color:#f7eee7;
	font-size: 18px;
	text-decoration:none;
	margin-top:10px;
	transform:translate(245%, -30%);
	/*box-shadow: 0 0 15px 1px rgba(80,80,80,0.2),inset 0 0 17px 4px rgba(215,190,169,0.9) ;*/
}

.back{
	width:190px;
	transform:translateX(225%);
}

.show{
	display:block;
}

.redO{
	background-color: saturate($buttun-color, 50%);
}



@media only screen and (min-width: 600px){
	.post{
		width:700px;
	}
}
</style>