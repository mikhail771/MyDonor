<template>
    <div id="app">
        <form  name="xml-ajax" id="xml-ajax" class="userForm" @submit.prevent="regUser">
            <h1>Регистрация пользователя</h1>
            <div class="wrap">
                <div class="block">
                    <label class="control-label" for="login">Логин *</label>
                    <input type="text" v-model="userData.login" required id="login">
                </div>
                <div class="block">
                    <label class="control-label" for="password">Пароль *</label>
                    <input type="password" v-model="userData.password" required id="password" placeholder="* * * * * * * *">
                </div>
                <div class="block">
                    <label class="control-label" for="password_confirm">Подтверждение пароля *</label>
                    <input type="password" :class="{ err: isPasErr }" @blur="checkPassword" v-model="password_confirm" required id="password_confirm" :placeholder="[isPasErr ? 'пароли не совпадают':'* * * * * * * *']">
                </div>
                <div class="block">
                    <label class="control-label" for="city">Город *</label>
                    <select v-model="userData.city" required id="city" class="select">
                        <option v-for="option in formData.cities"> {{option}}</option>

                    </select>
                </div>

                <div class="block">
                    <label class="control-label" for="gender">Пол *</label>
                    <select v-model="userData.gender" id="gender" class="select" required>
                        <option v-for="item in formData.gender">{{item}}</option>
                    </select>
                </div>


                <div class="block">
                    <label class="control-label" for="bloodType">Группа крови *</label>
                    <select v-model="userData.bloodType" id="bloodType" class="select" required>
                        <option v-for="item in formData.bloodType">{{item}}</option>
                    </select>
                </div>

                <div class="block">
                    <label class="control-label" for="rhesus">Резус фактор *</label>
                    <select v-model="userData.rhesus" id="rhesus" class="select" required>
                        <option v-for="item in formData.rhesus">{{item}}</option>
                    </select>
                </div>
                <div class="block">
                    <label class="control-label" for="contact">Контакты *</label>
                    <input type="text" v-model="userData.contact" id="contact" required placeholder="Введите E-mail или номер телефона">
                </div>

                <div class="block">
                    <label class="control-label" for="info">Информация</label>
                    <input type="text" v-model="userData.info" id="info">
                </div>


                <div class="block">
                    <button type="submit" id="but" class="button">Зарегистрироваться</button>
                </div>
            </div>
        </form>
    </div>
</template>

<script>
    import Vue from 'vue'
    import axios from 'axios'
    import VueAxios from 'vue-axios'

    Vue.use(VueAxios, axios);

    export default {
        data: function(){
            return{
                formData:{
                    cities: ["Днепр", "Киев", "Харьков", "Одесса", "Запорожье", "Камянское"],
                    gender: ["мужской","женский"],
                    bloodType: ["первая (O)","вторая (A)","третья (B)","четвертая (AB)"],
                    rhesus: ["положительный","отрицательный"]
                },
                userData: {
                    login: "" ,
                    password:"" ,
                    city: "Днепр",
                    gender:"мужчина",
                    bloodType:"" ,
                    rhesus:"" ,
                    contact:"" ,
                    info: ""
                },
                password_confirm:"",
                isPasErr: false
            }
        },
        methods:{
            regUser: function(){
                var then = this;
                this.UserData.password = this.md5(this.UserData.password);
                const config = { headers: {'Content-Type': 'application/json'}};
                axios.post('registration', JSON.stringify( this.userData ), config)
                        .then(function (response) {
                            console.log(response.data);
                        })
                        .catch(function (error) {
                            console.log(JSON.stringify(then.userData));
                            console.log(error);
                        });
                console.log('password to md5', this.userData.password );
            },
            checkPassword: function (e) {
                if (this.password_confirm !== this.userData.password ){
                    this.isPasErr = true;
                    this.password_confirm = "";
                   // e.target.focus();
                } else {
                    this.isPasErr = false;
                }
            }
        },
        md5: function (){
        var l='length',
            h=[
                '0123456789abcdef',0x0F,0x80,0xFFFF,
                0x67452301,0xEFCDAB89,0x98BADCFE,0x10325476
            ],
            x=[
                [0,1,[7,12,17,22]],
                [1,5,[5, 9,14,20]],
                [5,3,[4,11,16,23]],
                [0,7,[6,10,15,21]]
            ],
            A=function(x,y,z){
                return(((x>>16)+(y>>16)+((z=(x&h[3])+(y&h[3]))>>16))<<16)|(z&h[3])
            },
            B=function(s){
                var n=((s[l]+8)>>6)+1,b=new Array(1+n*16).join('0').split('');
                for(var i=0;i<s[l];i++)b[i>>2]|=s.charCodeAt(i)<<((i%4)*8);
                return(b[i>>2]|=h[2]<<((i%4)*8),b[n*16-2]=s[l]*8,b)
            },
            R=function(n,c){return(n<<c)|(n>>>(32-c))},
            C=function(q,a,b,x,s,t){return A(R(A(A(a,q),A(x,t)),s),b)},
            F=function(a,b,c,d,x,s,t){return C((b&c)|((~b)&d),a,b,x,s,t)},
            G=function(a,b,c,d,x,s,t){return C((b&d)|(c&(~d)),a,b,x,s,t)},
            H=function(a,b,c,d,x,s,t){return C(b^c^d,a,b,x,s,t)},
            I=function(a,b,c,d,x,s,t){return C(c^(b|(~d)),a,b,x,s,t)},
            _=[F,G,H,I],
            S=(function(){
                with(Math)for(var i=0,a=[],x=pow(2,32);i<64;a[i]=floor(abs(sin(++i))
                    *x));
                return a
            })(),
            X=function (n){
                for(var j=0,s='';j<4;j++)
                    s+=h[0].charAt((n>>(j*8+4))&h[1])+h[0].charAt((n>>(j*8))&h[1]);
                return s
            };
        return function(s){
            var $=B(''+s),a=[0,1,2,3],b=[0,3,2,1],v=[h[4],h[5],h[6],h[7]];
            for(var i,j,k,N=0,J=0,o=[].concat(v);N<$[l];N+=16,o=[].concat(v),J=0){
                for(i=0;i<4;i++)
                    for(j=0;j<4;j++)
                        for(k=0;k<4;k++,a.unshift(a.pop()))
                            v[b[k]]=_[i](
                                v[a[0]],
                                v[a[1]],
                                v[a[2]],
                                v[a[3]],
                                $[N+(((j*4+k)*x[i][1]+x[i][0])%16)],
                                x[i][2][k],
                                S[J++]
                            );
                for(i=0;i<4;i++)
                    v[i]=A(v[i],o[i]);
            };return X(v[0])+X(v[1])+X(v[2])+X(v[3]);
        }};

    }
</script>

<style lang="scss" scoped>
    html{
        background-color: #d84146;
        font-family: Tahoma, Verdana, Segoe, sans-serif;
        font-size: 16px;
    }
    form{
        width: 50%;
        background-color: #fff;
        margin: 20px auto;

    }
    @media screen and(max-width:1024px){
        form{
            width:90%;
        }
    }
    form > div {
        padding: 30px;
    }
    .userForm h1 {
        background-color: #b02429;
        color: #fff;
        padding: 20px;
        margin: 0;
    }
    .userForm input {
        border: 1px solid #b02429;
        padding-left: 10px;
        height: 25px;
        width: 40%;
        border-radius: 5px;
        outline: none;
    }
    .userForm input[type="radio"] {
        width: 4%;
    }
    .userForm textarea {
        border: 1px solid #b02429;
        border-radius: 5px;
    }
    .userForm label {
        color: #b02429;
        text-transform: uppercase;
        vertical-align: top;
    }
    .block {
        padding: 10px;
    }
    .select {
        height: 25px;
        border: 1px solid #b02429;
        background-color: #fff;
        width: 150px;
        outline: none;
        font-size: 14px;
        color: gray;
    }
    .control-label {
        width: 30%;
        display: inline-block;
    }
    .button {
        width: 90%;
        height: 40px;
        padding: 0;
        margin: 20px auto;
        border: none;
        cursor: pointer;
        border-radius:  5px;
        background: -webkit-gradient(linear, 0 0, 0 100%, from(rgba(216, 65, 82, 0.3)), to(#b02429));
        background: -webkit-gradient(linear, 0 0, 0 100%, from(rgba(216, 65, 82, 0.3)), to(#b02429));
        color: #b02429;
        text-transform: uppercase;
        display: block;
        color: #fff;
        font-size: 16px;
        letter-spacing: 2px;
    }
    button:hover{
        background: #b02429;
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#b02429), to(rgba(216, 65, 82, 0.3)));
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#b02429), to(rgba(216, 65, 82, 0.3)));
    }
    button:active{
        background: #b02429;
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#D60000), to(#F44336));
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#D60000), to(#F44336));
    }
    button:focus{
        outline: none;
    }
    .block .err{
        box-shadow: 0 0 5px red;
    }
</style>
