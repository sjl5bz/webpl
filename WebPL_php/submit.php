<?php
	
	$servername = "localhost";
	$username   = "rht6nf";
	$password   = "Kiwicat1!";
	$dbname     = "rht6nf";

	$CID = $_GET['CID'];
	$user = $_GET['user'];
	$title = $_GET['title'];
	$text = $_GET['text'];

	$db	=	new	mysqli($servername,	$username,	$password, $dbname);
	if	($db->connect_error) {	
	die	("Could	not	connect	to	db	"	.	$db->connect_error);
	}
	
	$sql = "INSERT INTO `comments` (`CID`, `username`, `title`, `text`) VALUES ('$CID', '$user', '$title', '$text');";
	echo $sql;
	$result = $db->query($sql);
	$db->close();


?>