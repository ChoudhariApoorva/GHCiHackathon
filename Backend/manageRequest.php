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
	error_log("SQL: " + $sql);

	if($result = mysqli_query($conn, $sql))
	{
		$list = array();
		while ($row = mysqli_fetch_row($result)) {
        	array_push($list, $row[8]);
    	}

		echo json_encode($list);
		//error_log("manage" . $list[0]);
	}
?>