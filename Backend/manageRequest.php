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
	$sql = "SELECT * FROM Seeker WHERE UserID = '$userID'";

	if($result = mysqli_query($conn, $sql))
	{
		$row = mysqli_fetch_row($result);
	
		error_log($row[1]);
	}
?>