


function getState(countryCode){
  
	//$('#ajaxLoader').find(".lightbox").show();
	softNiceUtilityData.getState(countryCode,{
		callback : function(str) 
		{
			 list = str.list;
			 var slist ='<option value="0">Select</option>';
			 $('#city').html('<option value="0">Select</option>');
			 for(var i=0; i<list.length;i++)
			 {
				 
				 slist += '<option value='+list[i].code+'>'+list[i].name+'</option>';
				 
				/* if(bucode==list[i].code){
					 slist += '<option selected="selected" value='+list[i].code+'>'+list[i].name+'</option>';
				 }else{
					 slist += '<option value='+list[i].code+'>'+list[i].name+'</option>';
				 }*/
					
	        	
	         }         

	         $('#state').html(slist);
	         
	         
	        // $('#ajaxLoader').find(".lightbox").hide();
	       
         } 
    });
}
function getCity(stateCode){
	  
	//$('#ajaxLoader').find(".lightbox").show();
	softNiceUtilityData.getCity(stateCode,{
		callback : function(str) 
		{
			 list = str.list;
			 var slist ='<option value="0">Select</option>';
			 for(var i=0; i<list.length;i++)
			 {
				 
				 slist += '<option value='+list[i].code+'>'+list[i].name+'</option>';
				 
				/* if(bucode==list[i].code){
					 slist += '<option selected="selected" value='+list[i].code+'>'+list[i].name+'</option>';
				 }else{
					 slist += '<option value='+list[i].code+'>'+list[i].name+'</option>';
				 }*/
					
	        	
	         }         

	         $('#city').html(slist);
	         
	         
	        // $('#ajaxLoader').find(".lightbox").hide();
	       
         } 
    });
}