package com.example.appperizinan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterStatus extends RecyclerView.Adapter<RecyclerViewAdapterStatus.ViewHolder>{
    private ArrayList<dataIzinAdmin> listMahasiswaIzin;
    private Context context;

    //Membuat Konstruktor, untuk menerima input dari Database
    public RecyclerViewAdapterStatus(ArrayList<dataIzinAdmin> listMahasiswaIzin, Context context) {
        this.listMahasiswaIzin = listMahasiswaIzin;
        this.context = context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Status, Date, NIM, Nama, Kelas, MatKuliah, JenisIzin, Alasan;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            Status = itemView.findViewById(R.id.status);
            Date = itemView.findViewById(R.id.date);
            NIM = itemView.findViewById(R.id.nim);
            Nama = itemView.findViewById(R.id.nama);
            Kelas = itemView.findViewById(R.id.kelas);
            MatKuliah = itemView.findViewById(R.id.matkul);
            JenisIzin = itemView.findViewById(R.id.jenisIzin);
            Alasan = itemView.findViewById(R.id.alasan);
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String Status = listMahasiswaIzin.get(position).getStatus();
        final String Data = listMahasiswaIzin.get(position).getDate();
        final String NIM = listMahasiswaIzin.get(position).getNim();
        final String Nama = listMahasiswaIzin.get(position).getNama();
        final String Kelas = listMahasiswaIzin.get(position).getKelas();
        final String MatKuliah = listMahasiswaIzin.get(position).getMatkul();
        final String JenisIzin = listMahasiswaIzin.get(position).getJenisIzin();
        final String Alasan = listMahasiswaIzin.get(position).getAlasan();

        //Memasukan Nilai/Value kedalam View (TextView: NIM, Nama, Jurusan)
        holder.Status.setText("Status: "+Status);
        holder.Date.setText("Tanggal: "+Data);
        holder.NIM.setText("NIM: "+NIM);
        holder.Nama.setText("Nama: "+Nama);
        holder.Kelas.setText("Kelas: "+Kelas);
        holder.MatKuliah.setText("Mata Kuliah: "+MatKuliah);
        holder.JenisIzin.setText("Jenis Izin: "+JenisIzin);
        holder.Alasan.setText("Alasan: "+Alasan);

    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listMahasiswaIzin.size();
    }
}
