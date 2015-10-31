<?php
	session_start();
	header("Access-Control-Allow-Origin:*");
	
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

	
	$result = $conn->query("SELECT UserID FROM USERS WHERE mobilenumber='$number'");
	if( !$result)
		die($conn->error);

	$row = $result->fetch_object();
    error_log($row->UserID);
	$UserID = $row->UserID;
	
	$_SESSION['UserID'] = $UserID;
	error_log($_SESSION['UserID']);
	
	
	$conn->close();									
	echo "Successful";
	error_log("Success");
	ob_flush();
?>
