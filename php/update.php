<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable 
		$kode = $_POST['kode_makanan'];
		$nama = $_POST['nama_makanan'];
		$kategori = $_POST['kategori'];
		$stok = $_POST['stok'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE tb_makanan SET nama_makanan = '$nama', kategori = '$kategori', stok = '$sal' WHERE kode_makanan = $kode;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
		echo 'Berhasil Update Data Makanan';
		}else{
		echo 'Gagal Update Data Makanan;
		}
		
		mysqli_close($con);
	}
?>