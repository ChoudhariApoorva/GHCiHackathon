$('#confirm-delete').on('show.bs.modal', function(e) {
    $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
});


$(document).ready(function(e)
{
	$dispRow = document.getElementById('dispRow');
	$dispRow.style.visibility = "hidden";
	$.get( "http://localhost/GHCiHackathon/Backend/manageRequest.php", function(data) 
	{
		var data = jQuery.parseJSON(data);
		if(data.length > 0)
		{
			$dispRow.style.visibility = "visible";
  			$firstRow = document.getElementById('firstRow');
  			$firstRow.innerHTML = data[0];
  			$heading = document.getElementById('heading');
  			$heading.innerHTML = data[0];
  		}
  		
	});
});

var name;
var emailId;
var number;
var city;

function findVolunteers()
{
	$firstRow = document.getElementById('firstRow');
	$cond = $firstRow.innerHTML;

	//alert($cond);

	var xhr = new XMLHttpRequest();

	xhr.open("GET","http://localhost/GHCiHackathon/Backend/findVolunteers.php?cond="+$cond,true);
	//xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function() 
    {
		if(xhr.readyState == 4 && xhr.status == 200 ) 
			{
				var data = jQuery.parseJSON(xhr.responseText);
				if(data.length == 0)
					alert("No Volunteer found. Please try after sometime");
				else
				{		
					var name = document.getElementById("VolunteerName");
					name.innerHTML = "Name : " + data["name"];
					var emailId = document.getElementById("VolunteerEmail");
					emailId.innerHTML = "Email ID : " + data["email"];
					var number = document.getElementById("VolunteerNumber");
					number.innerHTML = "Number : " + data["number"];
					var city = document.getElementById("VolunteerCity");
					city.innerHTML = "City : " + data["city"];
					
					alert("Volunteer found. Please click on view details");
				}
				//alert(xhr.responseText);
			}
			
	};
	xhr.send();
}

function deleteRequest()
{
	$dispRow = document.getElementById('dispRow');
	$dispRow.style.visibility = "hidden";
}