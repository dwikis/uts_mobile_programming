<?php
$kode = $_GET['kode'];
 
 //Import File Koneksi Database
 require_once('koneksi.php');
 
 //Membuat SQL Query
 $sql = "DELETE FROM tb_pegawai WHERE kode_makanan=$kode;";
 
 
 //Menghapus Nilai pada Database 
 if(mysqli_query($con,$sql)){
 echo 'Berhasil Menghapus Makanan';
 }else{
 echo 'Gagal Menghapus Makanan';
 }
 
 mysqli_close($con);
 ?>