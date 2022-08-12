package com.uts.a10119276_myuas.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uts.a10119276_myuas.Model.Diary;
import com.uts.a10119276_myuas.View.DiaryInterface;

/**
 *  NIM   : 10119276
 *  Nama  : Nasthasa Wulan Ghani Sopian
 *  Kelas : IF-7
 */

public class DiaryInt extends SQLiteOpenHelper implements DiaryInterface {

    public DiaryInt(Context context) {
        super(context, "diaryDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {
        sql.execSQL("CREATE TABLE diaryDB(id TEXT, judul TEXT, kategori TEXT,  isi TEXT, tanggal TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int oldVersion, int newVersion) {
        sql.execSQL("DROP TABLE diaryDB");
    }

    @Override
    public Cursor read() {
        SQLiteDatabase sql = getReadableDatabase();
        return sql.rawQuery("SELECT * FROM diaryDB",null);
    }

    @Override
    public boolean create(Diary diary) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("INSERT INTO diaryDb VALUES ('"+diary.getId()+"','"+diary.getJudul()+"','"+diary.getKategori()+"','"+diary.getIsi()+"','"+diary.getTanggal()+"')");
        return true;
    }

    @Override
    public boolean update (Diary diary){
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("UPDATE diaryDb SET judul ='"+diary.getJudul()+"', kategori ='"+diary.getKategori()+"', isi='"+diary.getIsi()+"', tanggal ='"+diary.getTanggal()+"' WHERE id='"+diary.getId()+"'");
        return true;
    }

    @Override
    public boolean delete(String id) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("DELETE FROM diaryDb WHERE id='"+id+"'");
        return true;
    }
}
