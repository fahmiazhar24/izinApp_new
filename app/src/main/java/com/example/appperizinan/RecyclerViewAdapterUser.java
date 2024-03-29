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

public class RecyclerViewAdapterUser extends RecyclerView.Adapter<RecyclerViewAdapterUser.ViewHolder>{
    //Deklarasi Variable
    private ArrayList<dataIzin> listMahasiswa;
    private Context context;

    //Membuat Konstruktor, untuk menerima input dari Database
    public RecyclerViewAdapterUser(ArrayList<dataIzin> listMahasiswa, Context context) {
        this.listMahasiswa = listMahasiswa;
        this.context = context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Date, NIM, Nama, Kelas, MatKuliah, JenisIzin, Alasan;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);

            Date = itemView.findViewById(R.id.date);
            NIM = itemView.findViewById(R.id.nim);
            Nama = itemView.findViewById(R.id.nama);
            Kelas = itemView.findViewById(R.id.kelas);
            MatKuliah = itemView.findViewById(R.id.matkul);
            JenisIzin = itemView.findViewById(R.id.jenisIzin);
            Alasan = itemView.findViewById(R.id.alasan);
            ListItem = itemView.findViewById(R.id.list_item_user);
        }
    }

    @Override
    public RecyclerViewAdapterUser.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design_user, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecyclerViewAdapterUser.ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String Date = listMahasiswa.get(position).getDate();
        final String NIM = listMahasiswa.get(position).getNim();
        final String Nama = listMahasiswa.get(position).getNama();
        final String Kelas = listMahasiswa.get(position).getKelas();
        final String MatKuliah = listMahasiswa.get(position).getMatkul();
        final String JenisIzin = listMahasiswa.get(position).getJenisIzin();
        final String Alasan = listMahasiswa.get(position).getAlasan();

        //Memasukan Nilai/Value kedalam View (TextView: NIM, Nama, Jurusan)
        holder.Date.setText("Tanggal: "+Date);
        holder.NIM.setText("NIM: "+NIM);
        holder.Nama.setText("Nama: "+Nama);
        holder.Kelas.setText("Kelas: "+Kelas);
        holder.MatKuliah.setText("Mata Kuliah: "+MatKuliah);
        holder.JenisIzin.setText("Jenis Izin: "+JenisIzin);
        holder.Alasan.setText("Alasan: "+Alasan);

        holder.ListItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listMahasiswa.size();
    }
}
