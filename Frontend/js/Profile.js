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
	alert("Hello");

	xhr.open("POST","http://localhost/GHCiHackathon/Backend/profile.php",true);
	
	xhr.onreadystatechange = function() 
    {
		if(xhr.readyState == 4) 
			{
				alert(xhr.status);
			}
			
	};
	xhr.send(data);
}

