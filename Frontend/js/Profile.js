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

	/*var data = [{"name" : name},
				{"emailId" : emailId},
				{"number" : number},
				{"gender" : gender},
				{"dob" : dob},
				{"city" : city},
				{"state" : state}
				]*/
	//alert(name + ',' + emailId + ',' + number + ',' + gender + ',' + dob + ',' + city + ',' + state);
	
	var data = new FormData();
	data.append("name",name);
	data.append("number",number);
	data.append("emailId",emailId);
	data.append("gender",gender);
	data.append("dob",dob);
	data.append("city",city);
	data.append("state",state);

	var xhr = new XMLHttpRequest();
	xhr.open("POST","http://localhost/profile.php",true);
	//xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhr.onreadystatechange = function() 
    {
    if(xhr.readyState == 4 && xhr.status == 200) 
        {
        	alert(xhr.responseText);
        }
    }
    //alert(xhr.responseText);
	xhr.send(data);

	//alert(JSON.stringify(data));

	/*xhr.open('POST', 'http://localhost:8080/Backend/profile.php', true);

	xhr.onload = function() 
	{
    	if (this.status == 200) 
    	{
	      var resp = JSON.parse(this.response);
	      alert('Server got:', resp);
    	}
  	}
  	
  	xhr.send(data);*/
}


/*$(document).ready(function(e){

	$('#ProfileTab-SubmitButton').click(function()
	{
		alert("Hello World");
	});

});*/

