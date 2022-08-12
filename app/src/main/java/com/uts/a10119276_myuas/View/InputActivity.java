package com.uts.a10119276_myuas.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.uts.a10119276_myuas.Data.DiaryInt;
import com.uts.a10119276_myuas.Model.Diary;
import com.uts.a10119276_myuas.R;

import java.util.Date;

public class InputActivity extends AppCompatActivity {

    private DiaryInterface diaryInterface;
    private ImageButton button;
    private EditText et_judul;
    private EditText et_kategori;
    private EditText et_isi;
    private Button btn_simpan;
    private Button deleteButton;
    private TextView titleAdd;
    Diary diary = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getSupportActionBar().hide();

        init();
    }

    private void init() {
        diary = (Diary) getIntent().getSerializableExtra("Diary");
        et_judul = findViewById(R.id.et_judul);
        et_kategori = findViewById(R.id.et_kategori);
        et_isi = findViewById(R.id.et_isi);
        button = findViewById(R.id.back);
        btn_simpan = findViewById(R.id.btn_simpan);
        deleteButton = findViewById(R.id.buttonDelete);
        titleAdd = findViewById(R.id.txt_add);
        diaryInterface = new DiaryInt(this);

        button.setOnClickListener(v -> {
            finish();
        });

        if (diary == null){
            deleteButton.setVisibility(View.GONE);

            btn_simpan.setOnClickListener(v -> {
                if (et_judul.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Judul Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_kategori.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Kategori Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_isi.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Isi Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }
                Date d = new Date();
                CharSequence date = DateFormat.format("d MMM yyyy HH:mm", d.getTime());
                Diary n = new Diary(
                        d.getTime() + "",
                        et_judul.getText().toString(),
                        et_kategori.getText().toString(),
                        et_isi.getText().toString() ,
                        date + ""
                );

                diaryInterface.create(n);
                finish();
                Toast.makeText(this, "Catatan berhasil di tambah", Toast.LENGTH_SHORT).show();
            });
        } else {
            et_judul.setText(diary.getJudul());
            et_kategori.setText(diary.getKategori());
            et_isi.setText(diary.getIsi());

            deleteButton.setVisibility(View.VISIBLE);
            titleAdd.setText("Edit Catatan");

            btn_simpan.setOnClickListener(v -> {
                if (et_judul.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Judul Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_kategori.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Kategori Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_isi.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Isi Catatan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }

                Date d = new Date();
                CharSequence date = DateFormat.format("d MMMM yyyy HH:mm",d.getTime());

                diary.setJudul(et_judul.getText().toString());
                diary.setKategori(et_kategori.getText().toString());
                diary.setIsi(et_isi.getText().toString());
                diary.setTanggal("Edited in " + date + "");
                diaryInterface.update(diary);
                finish();
                Toast.makeText(this, "Catatan berhasil di edit", Toast.LENGTH_SHORT).show();
            });
        }

        deleteButton.setOnClickListener(v-> {
            diaryInterface.delete(diary.getId());
            finish();
            Toast.makeText(this, "Catatan berhasil di hapus", Toast.LENGTH_SHORT).show();
        });

    }
}