<?php
header('Content-Type:application/json');
$con = mysqli_connect('localhost','root','');
mysqli_select_db($con,'test_db');
//echo("hello");

if(isset($_POST['email'],$_POST['password'])) {
		$email = $_POST['email'];
		$password = $_POST['password'];
		
		if(!empty($email) && !empty($password)){
			
			$encrypted_password = md5($password);
			$query = "Select * from users where email='$email' and password = '$password' ";
			$result = mysqli_query($con,$query);
			
			//$r=mysqli_query($con,$q);
			if(mysqli_num_rows($result)>0){
				$json['success'] = ' Welcome '.$email;
				echo json_encode($json);
				
			
			
		}else{
			echo json_encode("you must type both inputs");
		}
		
	}
}
// }else{
			// 	$query = "insert into users (email, password) values ( '$email','$password')";
			// 	$inserted = mysqli_query($con,$query);
			// 	if($inserted == 1 ){
			// 		$json['success'] = 'Acount created';
			// 	}else{
			// 		$json['error'] = 'not inserted';
			// 	}
			// 	echo json_encode($json);
				
			// }

?>

