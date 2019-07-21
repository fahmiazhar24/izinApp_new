package com.example.appperizinan;

//@IgnoreExtraProperties
public class dataIzin {
    private String nama;
    private String nim;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public dataIzin(){

    }

    public dataIzin(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }
}
