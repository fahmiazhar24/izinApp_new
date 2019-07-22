package com.example.appperizinan;

//@IgnoreExtraProperties
public class dataIzin {
    private String nama;
    private String nim;
    private String kelas;
    private String matkul;
    private String jenisIzin;
    private String alasan;
    private String key;
    private String data;
    private String status;

    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }

    public String getData() {
        return data;
    }

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

    public dataIzin(String status, String data, String nama, String nim, String kelas, String matkul, String jenisIzin, String alasan){
        this.status = status;
        this.data = data;
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.matkul = matkul;
        this.jenisIzin = jenisIzin;
        this.alasan = alasan;
    }
}
