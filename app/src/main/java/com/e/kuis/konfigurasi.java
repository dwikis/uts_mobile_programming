package com.e.kuis;

public class konfigurasi {
    public static final String URL_ADD="http://192.168.43.191/php/tambah.php";
    public static final String URL_GET_ALL = "http://192.168.43.191/php/tampil.php";
    public static final String URL_GET_EMP = "http://192.168.43.191/php/detail.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.43.191/php/update.php";
    public static final String URL_DELETE_EMP = "http://192.168.43.191/php/hapus.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_KODE = "kode";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_KATEGORI = "kategori";
    public static final String KEY_EMP_STOK = "stok";
    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_KODE = "kode";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_KATEGORI = "kategori";
    public static final String TAG_STOK = "stok";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_KODE = "emp_kode";
}
