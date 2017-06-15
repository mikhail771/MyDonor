import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export const store = new Vuex.Store({
	state:{
		place:"",
		link: "",
		quizComponent: "q-start",
		quizCounter: 1,
		quiz:[
		{technic: "technick"},
		{question:1,
		 image:'url("./src/components/assets/calendar.svg")',
		title:"Вам от 18 до 60 лет?",
		answer:{
			image:'url("./src/components/assets/error.svg"),url("./src/components/assets/calendar.svg")',
		title:"К сожалению, вы можете быть донором крови только между 18-м днем рождения и 60-м.",
		}},

		{question:2,
		 image:'url("./src/components/assets/ageweight.svg")',
		title:"Ваш вес больше 50 кг и рост выше 150 см?",
		answer:{
			image:'url("./src/components/assets/error.svg"),url("./src/components/assets/calendar.svg")',
		title:"Вы можете стать донором крови в индивидуальном случае. Медицинская комиссия определит,можно ли будет допустить вас к сдачи крови. Для этого обратитесь в донорский пункт.",
		}},

			{question:3,
		 image:'url("./src/components/assets/plane.svg")',
		title:"За последний год вы посещали малярийные страны?",
		answer:{
			image:'url("./src/components/assets/error.svg"),url("./src/components/assets/calendar.svg")',
		title:"К сожалению, вам придется ждать от 6 месяцев до 3-х лет, прежде чем сдать кровь.",
		}},

			{question:4,
		 image:'url("./src/components/assets/heartcardio.svg")',
		title:"У вас были болезни сердца, инсульт или рак?",
		answer:{
			image:'url("./src/components/assets/error.svg"),url("./src/components/assets/calendar.svg")',
		title:"К сожалению, вы не имеете права сдавать кровь.",
		}},

			{question:5,
		image:'url("./src/components/assets/baby.svg")',
		title:"Вы родили, кормите в течении последнего года или беременны?",
		answer:{
			image:'url("./src/components/assets/error.svg"),url("./src/components/assets/calendar.svg")',
		title:"Будем рады видеть вас донором через год после рождения или беременности. Если вы кормите грудью, стать донором можно через 3 месяца, после завершения лактации.",
		}},

			{question:6,
		 image:'url("./src/components/assets/allicon.svg")',
		title:"Вы делали татуировку, пирсинг за последний год?",
		answer:{
			image:'url("./src/components/assets/error.svg"),url("./src/components/assets/calendar.svg")',
		title:"Будем рады видеть вас донором крови через 12 месяцев после процедуры нанесения татуировки иглоукалывания или пирсинга.",
		}},

			{question:7,
		image:'url("./src/components/assets/endoscopy.svg")',
		title:"За последние шесть месяцев Вам делали эндоскопию или колоноскопию?",
		answer:{
			image:'url("./src/components/assets/error.svg"),url("./src/components/assets/calendar.svg")',
		title:"Вам нужно ждать 6 месяцев после исследования, прежде чем вы сможете сдать кровь.",
		}},

			{question:8,
		 image:'url("./src/components/assets/transfusion.svg")',
		title:"Вам переливали кровь за последний год?",
		answer:{
			image:'url("./src/components/assets/error.svg"),url("./src/components/assets/calendar.svg")',
		title:"Вы можете стать донором через 1 год после трансфузии компонентов крови (за исключением ожоговых реконвалесцетов и лиц, иммунизированных к резус-фактору)",
		}},
		]
	},

	mutations: {
		answer(state){
			state.quizComponent = "q-answer"
		},
		refresh(state){
			state.quizCounter = 1;
			state.quizComponent = "q-start"
		},
		final(state){
			state.quizComponent = "q-final"
		},
		cNext(state){
			state.quizCounter++;
		},
		formLink(state){
			state.link = "https://www.google.com/maps/embed/v1/search?q=станция+переливания+крови+возле+" + state.place + "&key=AIzaSyAO0Ju6FOiKKWYpbv-CDHJ9aq9Ff4NOy9g"
		}
	}
	
})
