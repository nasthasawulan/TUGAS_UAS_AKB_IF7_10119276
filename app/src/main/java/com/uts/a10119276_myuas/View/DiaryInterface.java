package com.uts.a10119276_myuas.View;

import android.database.Cursor;

import com.uts.a10119276_myuas.Model.Diary;

/**
 *  NIM   : 10119276
 *  Nama  : Nasthasa Wulan Ghani Sopian
 *  Kelas : IF-7
 */

public interface DiaryInterface {
    public Cursor read();
    public boolean create(Diary diary);
    public boolean update(Diary diary);
    public boolean delete(String id);
}
