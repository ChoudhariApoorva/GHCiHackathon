<?php
	session_start();
	header("Access-Control-Allow-Origin:*");

	$servername = 'localhost';
	$username = 'root';
	$pwd = '';
	$dbname = 'HelpingHand';
	

	// Create connection
    $conn = mysqli_connect($servername, $username, $pwd, $dbname);
	// Check connection
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
	
	$userID = $_SESSION['UserID'];
	$cond = $_GET["cond"];
	
	$sql = "SELECT * FROM Volunteer WHERE reqcondition = '$cond'";
	error_log("DATA_-------------");
	error_log($sql);


	if($result = mysqli_query($conn, $sql))
	{
		$row = mysqli_fetch_row($result);
	
		$data = array('name' => $row[0], 
				  'email' => $row[1],
				  'number' => $row[2],
				  'city' => $row[5]
				  	);
		
		
		error_log($data["email"]);
		echo json_encode($data);
	}
?>