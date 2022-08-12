package com.uts.a10119276_myuas.View;

import android.database.Cursor;

import com.uts.a10119276_myuas.Model.Diary;

public interface DiaryInterface {
    public Cursor read();
    public boolean create(Diary diary);
    public boolean update(Diary diary);
    public boolean delete(String id);
}
