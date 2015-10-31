<?php
	session_start();
	header("Access-Control-Allow-Origin:*");
	
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
	
	$userID = $_SESSION['UserID'];
	$sql = "SELECT * FROM USERS WHERE UserID = '$userID'";
	
	if($result = mysqli_query($conn, $sql))
	{
		$row = mysqli_fetch_row($result);
	
		$data = array('name' => $row[1], 
				  'email' => $row[2],
				  'number' => $row[3],
				  'gender' => $row[4],
				  'dob' => $row[5],
				  'city' => $row[6],
				  'state' => $row[7],
				  	);
		echo json_encode($data);
	}
	
?>