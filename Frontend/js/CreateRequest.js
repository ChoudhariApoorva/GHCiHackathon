$(document).ready(function(e){

    $('#contact-details-tab').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#request-details-tab').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#request-details-tab').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#contact-details-tab').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#ContactTab-NextButton').click(function(e)
	{
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#contact-details-tab').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

	$('#RequestTab-Submit').click(function(e)
	{
		var name = $('#inputFullName').val();
		var emailId = $('#inputEmailId').val();
		var mobileNumber = $('#inputMobileNumber').val();

		var check_gender = document.getElementsByName('optionsGender');
		var gender;
		for(var i = 0; i < check_gender.length; i++)
		{
    		if(check_gender[i].checked)
    		{
        		gender = check_gender[i].value;
    		}
		}
		
		var dateOfBirth = $('#inputDOB').val();
		var city = $('#inputCity').val();
		var state = $('#inputState').val();

		var type = $('#radioOfferingAid').val();
		var condition = $('#select').val();
		var requestName = $('#inputRequestName').val(); 	
		var requiredBy = $('#inputReqByDate').val(); 	

		$.post(" http://localhost:8080/antardrishti/create",
		{
        	"contact":
        	{
	      		"name":name,
	      		"emailId":emailId,
	      		"mobileNumber":mobileNumber,
	      		"gender":gender,
	      		"dateOfBirth":dateOfBirth,
	      		"city":city,
	      		"state":state
   			},
   			"request":
   			{
		      	"type":type,
		      	"condition":condition,
		      	"requestName":requestName,
		      	"requiredBy":requiredBy
   			}
    	},
    	function(data)
    	{
    		alert("Data submitted");
    	});
		
	});

});
