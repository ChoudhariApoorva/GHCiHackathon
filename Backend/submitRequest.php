<?php
	session_start();
	//header("Access-Control-Allow-Origin: *");
	//extract($_POST);

	$name = htmlspecialchars($_POST["name"]);
	$number = htmlspecialchars($_POST["number"]);
	$gender = htmlspecialchars($_POST["gender"]);
	$dob = date("Y-m-d",strtotime(htmlspecialchars($_POST["dob"])));
	$city = htmlspecialchars($_POST["city"]);
	$state = htmlspecialchars($_POST["state"]);
	$type = htmlspecialchars($_POST["type"]);
	$reqName = htmlspecialchars($_POST["requestName"]);
	$requiredBy = htmlspecialchars($_POST["requiredBy"]);
	$desc = htmlspecialchars($_POST["desc"]);
	$condition = htmlspecialchars($_POST["condition"]);
	
	echo "Hello" . $name;
	/*echo htmlspecialchars($_POST["name"]);
	echo htmlspecialchars($_POST["number"]);
	echo htmlspecialchars($_POST["dob"]);
	echo htmlspecialchars($_POST["city"]);
	echo htmlspecialchars($_POST["state"]);
	echo htmlspecialchars($_POST["type"]);
	echo htmlspecialchars($_POST["condition"]);
	echo htmlspecialchars($_POST["requestName"]);
	echo htmlspecialchars($_POST["requiredBy"]);
	echo htmlspecialchars($_POST["desc"]);*/
	error_log("hello");
	
	if(isset($_SESSION['UserID']))
		echo $_SESSION['UserID'];
	else
		echo 'Session problem';
	
	/*$servername = 'localhost';
	$username = 'root';
	$pwd = 'root';
	$dbname = 'HelpingHand';
	
	echo $servername. "  ". $requiredBy;*/

	// Create connection
    /*$conn = mysqli_connect($servername, $username, $pwd, $dbname);
	
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
	ob_flush();*/
?>
