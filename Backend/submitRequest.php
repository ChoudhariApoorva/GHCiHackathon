<?php
	session_start();
	header("Access-Control-Allow-Origin: *");
	//extract($_POST);

	$name = htmlspecialchars($_POST["name"]);
	$emailId = htmlspecialchars($_POST["emailId"]);
	$number = htmlspecialchars($_POST["number"]);
	$gender = htmlspecialchars($_POST["gender"]);
	$dob = date("Y-m-d",strtotime(htmlspecialchars($_POST["dob"])));
	$city = htmlspecialchars($_POST["city"]);
	$state = htmlspecialchars($_POST["state"]);
	$type = htmlspecialchars($_POST["type"]);
	$reqName = htmlspecialchars($_POST["requestName"]);
	$requiredBy = date("Y-m-d",strtotime(htmlspecialchars($_POST["requiredBy"])));
	$desc = htmlspecialchars($_POST["desc"]);
	$condition = htmlspecialchars($_POST["condition"]);

	error_log($name. " from submit");

	$servername = 'localhost';
	$username = 'root';
	$pwd = '';
	$dbname = 'HelpingHand';

	if(isset($_SESSION['UserID']))
	{
		$userId = $_SESSION['UserID'];
		echo $userId;
		 $conn = mysqli_connect($servername, $username, $pwd, $dbname);
	
		// Check connection
		if (!$conn) {
			error_log("connection failed");
			die("Connection failed: " . mysqli_connect_error());
		}
		
		$sql = "INSERT INTO Seeker VALUES (DEFAULT, '$name', '$emailId', '$number', '$gender', '$dob', '$city', '$state', '$condition', 0, '$requiredBy', '$desc', '$userId', '$reqName', NULL);";
		
		if ($conn->query($sql) === TRUE) {
			error_log( "successfully!" );
			echo "Successful Request";
		} 
		else {
			error_log($conn->error);
		}
	}
	else
	{	
		error_log('Session problem, Please Re login');
		echo 'Session problem, Please Re login';
	}
?>
