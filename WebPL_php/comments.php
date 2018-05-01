<?php
	header('Content-type: application/json');
	$servername = "localhost";
	$username   = "rht6nf";
	$password   = "Kiwicat1!";
	$dbname     = "rht6nf";

	$db	=	new	mysqli($servername,	$username,	$password, $dbname);
	if	($db->connect_error) {	
	die	("Could	not	connect	to	db	"	.	$db->connect_error);
	}

	$sql = "SELECT * FROM comments";

	$result = $db->query($sql);
	

	if ($result->num_rows > 0) {
    // output data of each row
		$data = array();
		while($row = $result->fetch_assoc()){
			$item = ['user'=> $row['username'],'title'=> $row['title'],'text'=> $row['text']];
			array_push($data, $item);
		}
	    print json_encode($data);
	} else {
	    print 'error';
	}
	$db->close();


?>