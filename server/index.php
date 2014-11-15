<?php 
	if (isset($_POST['operasi'])) {
		$operation = $_POST['operasi'];
		if ($operation == 'beli') {
			echo $_POST['operator'].$_POST['nominal']." ".$_POST['nope']." 1234";
		}elseif ($operation == 'daftar') {
			$con=mysqli_connect('localhost',"root","","pushla");
			$query = "INSERT INTO `user`(`username`, `password`, `nohape`, `operator`) VALUES ('".$_POST['username']."','".$_POST['pass']."','".$_POST['nope']."','".$_POST['operator']."')";
			$result = mysqli_query($con, $query);
			if ($result) {
				echo '{ "operasi":"daftar", "status":"sukses"}';
			}else{
				echo '{ "operasi":"daftar", "status":"gagal", "error":"'.mysqli_error().'"}';
				//echo $query;
				//mysqli_error();
			}
		}
	}else{
		echo "eror broh";
	}
	
?>