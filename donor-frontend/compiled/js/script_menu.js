$(document).ready(function(){
	
function loadPage(name){
    var fullUrl = 'pages/'+name+'/index.html';
    $('#content').css("display","none");
    console.log(fullUrl);
    $('#content').load(fullUrl).fadeIn(1000);
}    


$('#nav > li > a').click(function(){
   // $('#nav > ul > li').removeClass('active');
    //$(this).addClass('active');

    console.log($(this).data("name") );

    var nameOfPage = $(this).data("name");
     switch (nameOfPage){
        case 'bid':
          loadPage(nameOfPage);
          break;
        case 'feed':
          loadPage(nameOfPage);
          break;
        case 'travel':
          loadPage(nameOfPage);
          break;
        case 'registration':
          loadPage(nameOfPage);
          break;
    }


})

})