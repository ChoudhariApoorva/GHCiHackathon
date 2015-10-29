<?php
	header("Access-Control-Allow-Origin: http://localhost/*");
	
	$name = htmlspecialchars($_POST["name"]);
	$emailId = htmlspecialchars($_POST["emailId"]);
	$number = htmlspecialchars($_POST["number"]);
	$gender = htmlspecialchars($_POST["gender"]);
	$dob = date("Y-m-d",strtotime(htmlspecialchars($_POST["dob"])));
	$city = htmlspecialchars($_POST["city"]);
	$state = htmlspecialchars($_POST["state"]);
	
	$servername = 'localhost';
	$username = 'root';
	$pwd = 'root';
	$dbname = 'HelpingHand';

	// Create connection
    $conn = mysqli_connect($servername, $username, $pwd, $dbname);
	
	// Check connection
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
	
	//echo "Connected". $dob. $name;	
	$sql = "INSERT INTO Users VALUES (DEFAULT, '$name', '$emailId', '$number', '$gender', '$dob', '$city', '$state');";
	
	if ($conn->query($sql) === TRUE) {
		error_log( "successfully!" );
	} 
	else {
		error_log("error");
	}
	error_log( "Hello, errors!" );						
	
	$conn->close();									
	echo "Successful";
	ob_flush();
?>
