function doSubmitAction()
{
	var name = document.getElementById("inputName").value;
	var emailId = document.getElementById("inputEmail").value;
	var number = document.getElementById("inputNumber").value;
	var check_gender = document.getElementsByName('optionsGender');
	var gender;
		for(var i = 0; i < check_gender.length; i++)
		{
    		if(check_gender[i].checked)
    		{
        		gender = check_gender[i].value;
    		}
		}
	var dob = document.getElementById("inputDOB").value;
	var city = document.getElementById("inputCity").value;
	var state = document.getElementById("inputState").value;

	var data = [{"name" : name},
				{"emailId" : emailId},
				{"number" : number},
				{"gender" : gender},
				{"dob" : dob},
				{"city" : city},
				{"state" : state}
				]
	//alert(name + ',' + emailId + ',' + number + ',' + gender + ',' + dob + ',' + city + ',' + state);
	alert(JSON.stringify(data));

	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'profile.php', true);

	xhr.onload = function() 
	{
    	if (this.status == 200) 
    	{
	      var resp = JSON.parse(this.response);
	      alert('Server got:', resp);
    	}
  	}
  	
  	xhr.send(data);
}


/*$(document).ready(function(e){

	$('#ProfileTab-SubmitButton').click(function()
	{
		alert("Hello World");
	});

});*/

