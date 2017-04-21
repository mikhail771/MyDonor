function getCORS(url, success) {
    var xhr = new XMLHttpRequest();
    if (!('withCredentials' in xhr)) xhr = new XDomainRequest(); // fix IE8/9
    xhr.open('GET', url);
    xhr.onload = success;
    xhr.send();
    return xhr;
}

getCORS('https://dry-island-77618.herokuapp.com/bids', function(request){
    var response = request.currentTarget.response || request.target.responseText;
    var feed = JSON.parse(response);
    // console.log(feed);
    var main = document.querySelector("main");
var postDetails = document.querySelector(".postDetails");
var html = "";
var html2 = "";
function showAllFeed(){
for(var i =0; i<feed.length; i++){
	html += '<div class="post"><div><span class="name"> '+feed[i].bidUserName +'</span></div><div><span>Банк крови: </span>'+feed[i].bidHospital+'</div><div><span class="contacts">Контакты: </span>'+feed[i].bidContacts+'</div><div><span>Количество крови (мл): </span>'+feed[i].bidQuantity+'</div><div><span class="addInfo">Дополнительная информация: </span> '+feed[i].bidInfo+'</div><div> <span>Группа крови: </span>'+feed[i].bidGroup+'</div><div><span>Цена: </span>'+feed[i].bidPrice+'</div><div><span class="comments">Комментарии: </span>'+feed[i].bidComments+'</div> <button class="details">Подробнее...</button></div>';
	main.innerHTML = html;

}
}

showAllFeed();
var linkDetail = document.querySelectorAll(".details");


for (var i = 0 ; i < linkDetail.length; i++) {
   linkDetail[i].addEventListener("click", function(){
	main.innerHTML = '<div class="post">' + this.parentNode.innerHTML + '<a href="index.html" class="back">Ко всем заявкам </a></div>';
	document.querySelector(".details").style.display = "none"; 
	document.querySelector(".contacts").style.display = "block"; 
	document.querySelector(".addInfo").style.display = "block"; 
	document.querySelector(".comments").style.display = "block"; 


})
}
}, true);
