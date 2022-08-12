package com.uts.a10119276_myuas.Presenter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uts.a10119276_myuas.Model.Diary;
import com.uts.a10119276_myuas.R;
import com.uts.a10119276_myuas.View.InputActivity;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {

    private List<Diary> diaryList;

    public DiaryAdapter(List<Diary> diaryList) {
        this.diaryList = diaryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_diary, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.judul.setText(diaryList.get(position).getJudul());
        holder.kategori.setText(diaryList.get(position).getKategori());
        holder.isi.setText(diaryList.get(position).getIsi());
        holder.tanggal.setText(diaryList.get(position).getTanggal());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), InputActivity.class);
            intent.putExtra( "Diary", diaryList.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView judul;
        TextView kategori;
        TextView isi;
        TextView tanggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul_diary);
            kategori = itemView.findViewById(R.id.kategori_diary);
            isi = itemView.findViewById(R.id.isi_diary);
            tanggal = itemView.findViewById(R.id.tanggal_diary);
        }
    }
}