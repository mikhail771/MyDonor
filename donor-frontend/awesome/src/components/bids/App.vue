<template>
  <div id="app">
    <h2>{{ fieldsValue.greeting }}</h2>

    <form method="POST" id="form" name="form" action="javascript:void(null);" >
        <fieldset>
            <legend>Добавить заявку</legend>
            <p><label for="name">ФИО: <em>*</em></label><input type="text" id="name" name="name" value="qwerty" v-model="fieldsValue.name"></p>
            <p><label for="hospital">Номер больницы: </label><input type="text" id="hospital" name="hospital" v-model="fieldsValue.hospital"></p>
            <p><label for="contacts">Контакты: </label><input type="text" id="contacts" name="contacts" v-model="fieldsValue.contacts"></p>
            <p><label for="bloodType">Тип крови: </label><input type="text" id="bloodType" name="bloodType" v-model="fieldsValue.bloodType"></p>
            <p><label for="bloodQuntity">Необходимое количество крови: </label><input type="text" id="bloodQuntity" name="bloodQuntity" v-model="fieldsValue.bloodQuntity"></p>
            <p><label for="hospital2">Номер больницы: </label><input type="text" id="hospital2" name="hospital2" v-model="fieldsValue.hospital2"></p>
            <p><label for="hospital3">Номер больницы: </label><input type="text" id="hospital3" name="hospital3" v-model="fieldsValue.hospital3"></p>
            <p><label for="additionalInfo">Дополнительная информация: </label><textarea id="additionalInfo" name="additionalInfo" v-model="fieldsValue.additionalInfo"></textarea></p>
        </fieldset>
        <p><input type="submit" value="Добавить" id="send" @click.prevent="onsubmit"></p>
    </form>
    <div id="results">вывод</div>

  </div>
</template>

<script>
    import Vue from 'vue';
    import axios from 'axios';
    import VueAxios from 'vue-axios';

    Vue.use(VueAxios, axios);

export default {
    data: function () {
        return {
            fieldsValue: {
                greeting: 'Форма заявки для реципиента',
                name: 'poiuytre',
                hospital: '',
                contacts:'',
                bloodType:'',
                bloodQuntity:'',
                hospital2:'',
                hospital3:'',
                additionalInfo:''
            }
        }
    }, //data
    methods:{
        onsubmit: function () {
            const config = { headers: {'Content-Type': 'application/json'}};
            axios.post('#', {
                name: this.name ,
                hospital:this.hospital ,
                contacts:this.contacts,
                bloodType:this.bloodType ,
                bloodQuntity:this.bloodQuntity ,
                hospital2:this.hospital2 ,
                hospital3:this.hospital3 ,
                additionalInfo:this.additionalInfo
            }, config)
                .then(function (response) {
                    console.log(response.data);

                })
                .catch(function (error) {
                    console.log(error);
                });
        } //onsubmit
    } //methods
}

</script>

<style>
    h1{
        color: #d42045;
    }

    fieldset p{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-between;
    }
    fieldset p input, fieldset p textarea{
        /*flex-grow: 0;*/
        width: 240px;
    }

    #send{
        float: right;
        margin: 0 15px 15px 15px;
        background: green;
        padding: 10px 20px;
        color: white;
    }
</style>