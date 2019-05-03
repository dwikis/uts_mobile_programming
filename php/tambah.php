<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$nama = $_POST['nama_makanan'];
		$kategori = $_POST['kategori'];
		$stok = $_POST['stok'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_makanan (nama_makanan,kategori,stok) VALUES ('$nama','$kategori','$stok')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
		echo 'Berhasil Menambahkan Pegawai';
		}else{
		echo 'Gagal Menambahkan Pegawai';
		}
		
		mysqli_close($con);
	}
?>