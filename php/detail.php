<?php
//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$kode = $_GET['kode_makanan'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT * FROM tb_makanan WHERE kode_makanan=$kode";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
		"kode"=>$row['kode_makanan'],
		"nama"=>$row['nama_makanan'],
		"kategori"=>$row['kategori'],
		"stok"=>$row['stok']
		));
 
	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>