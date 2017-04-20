
$(document).ready(function(){
	$m=$(".nav li");

	$("#menu_btn").on('click',function(){
		if($m.css('display')=='none'){
			$m.show();
		}else{
			$m.hide();
		}
	});

	$(window).on('resize',function(){
		if($(window).width()>800){
			$m.css('display','');
		}
	})
})
	