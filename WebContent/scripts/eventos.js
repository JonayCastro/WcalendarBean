/**
 * 
 */


$(document).ready(function(){
	
	function cleaReason(){
		$("#reason-area").val('');
		$("#contador").text('0/120');
	}
	function charLength(element){
		var valor = $(element).text().length;
		  $("#contador").text(parseInt(valor)+"/120");
	}
	
  $("td").click(function(){
	  var eId = ($(this).attr('id'));
	  if(eId == "dia-laboral"){
		  $("#event-type-select").val('reunion');
		  var day = $(this).text();
		  var month = $("#actualMonth-title").text();
		  
		  $("#event-list").slideDown("slow");
		  $("#event-list-title").text(day+" "+month);
	  }else if(eId == "dia-festivo"){
		  alert('No se pueden a\361adir eventos en fin de semana');
	  }
	  
	  
	  
  });
  
  $("#new-btn-cls").click(function(){
	  $("#event-list").slideUp("slow");
	  
  });
  
  $("#reason-area").bind("keyup", function(){
	  
	  charLength(this);
	  
  });
  
  /*
  $("#event-type-select").change(function(){
	  var selection = $(this).val();
	  if(selection == "otros"){
		  $("#reason-area").prop("disabled", false);
	  }else{
		  $("#reason-area").prop("disabled", true);
		  cleaReason();
	  }
  });
  */
});