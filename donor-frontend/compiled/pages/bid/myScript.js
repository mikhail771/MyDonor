const ELEMENTS = {
    bidUserName: document.forms.form.elements.name,
    bidHospital: document.form.elements.hospital,
    bidContacts: document.form.elements.contacts,
    bidGroup: document.form.elements.bloodType,
    bidQuantity: document.form.elements.bloodQuntity,
    bidComments: document.form.elements.hospital2,
    bidPrice: document.form.elements.hospital3,
    bidInfo: document.form.elements.additionalInfo
}

function getValue(obj) {
    var newObj = {};
    for (key in obj){
        newObj[key] = obj[key].value;
    }
    return newObj;
}

form.onsubmit = function() {
    var data = JSON.stringify( getValue(ELEMENTS) );
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open('POST', '/bids/add', true);
    xmlhttp.setRequestHeader('Content-Type', 'application/json');
    xmlhttp.send(data);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4) {
            if(xmlhttp.status == 200) {
                document.getElementById("results").innerHTML = xmlhttp.responseText; 
                console.log('Ok');
            } else {
                console.log('not Ok');
            }
        }
    };
}


