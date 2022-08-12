package com.uts.a10119276_myuas.View.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uts.a10119276_myuas.Data.DiaryInt;
import com.uts.a10119276_myuas.Model.Diary;
import com.uts.a10119276_myuas.Presenter.DiaryAdapter;
import com.uts.a10119276_myuas.Presenter.MainActivity;
import com.uts.a10119276_myuas.R;
import com.uts.a10119276_myuas.View.DiaryInterface;
import com.uts.a10119276_myuas.View.InputActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *  NIM   : 10119276
 *  Nama  : Nasthasa Wulan Ghani Sopian
 *  Kelas : IF-7
 */

public class DiaryFragment extends Fragment {
    private MainActivity mainActivity;
    private List<Diary> diary;
    private DiaryInterface diaryInterface;
    private RecyclerView recyclerView;
    private DiaryAdapter diaryAdapter;
    private FloatingActionButton addButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView =  inflater.inflate(R.layout.fragment_diary, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().hide();

        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.mydiary);
        addButton = view.findViewById(R.id.button_add);
        addButton.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), InputActivity.class));
        });

        read();
    }

    @Override
    public void onResume() {
        super.onResume();
        read();
    }

    private void read(){
        diary=new ArrayList<Diary>();
        diaryInterface = new DiaryInt(getContext());
        Cursor cursor = diaryInterface.read();
        if(cursor.moveToFirst()){
            do{
                Diary d = new Diary(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)

                );
                diary.add(d);
            }while (cursor.moveToNext());
        }
        diaryAdapter = new DiaryAdapter(diary);
        recyclerView.setAdapter(diaryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}
