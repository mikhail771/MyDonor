function SendToServer() {
    
var login = document.getElementById("login").value;
var password = document.getElementById("password").value;
var city = document.getElementById("city").value;
var gender = document.getElementById("gender").value;
var bloodType = document.getElementById("bloodType").value;
var rhesus = document.getElementById("rhesus").value;
var contact = document.getElementById("contact").value;
var info = document.getElementById("info").value;

//creating XMLhttpRequest object
 var xhr;
	 if (window.XMLHttpRequest) { // Mozilla, Safari, ...
    xhr = new XMLHttpRequest();
} else if (window.ActiveXObject) { // IE 8 and older
    xhr = new ActiveXObject("Microsoft.XMLHTTP");
}
    var jsonData =
        {
            "login": login,
            "password": (password),
            "city": (city),
            "gender": (gender),
            "bloodType": (bloodType),
            "rhesus": (rhesus),
            "contact": (contact),
            "info": (info),
            "info": (info)
        }
    alert(jsonData);
    console.log(jsonData);

  var url = "#"; // Build the URL to connect to
  xhr.open("POST", url, true); // Open a connection to the server
  xhr.setRequestHeader("Content-Type", "text/json"); // declaring that the data being sent is in XML format
  xhr.send(jsonData); // Send the request
}

var rrr=document.getElementsByClassName('block');
console.log(rrr);
var bbb=document.getElementsByClassName('button');
console.log(bbb);
console.dir(bbb);


