package com.example.appperizinan;

//@IgnoreExtraProperties
public class dataIzin {
    private String nama;
    private String nim;
    private String kelas;
    private String matkul;
    private String jenisIzin;
    private String alasan;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getKelas() {
        return kelas;
    }

    public String getMatkul() {
        return matkul;
    }

    public String getJenisIzin() {
        return jenisIzin;
    }

    public String getAlasan() {
        return alasan;
    }



    public dataIzin(){

    }

    public dataIzin(String nama, String nim, String kelas, String matkul, String jenisIzin, String alasan){
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.matkul = matkul;
        this.jenisIzin = jenisIzin;
        this.alasan = alasan;
    }
}
