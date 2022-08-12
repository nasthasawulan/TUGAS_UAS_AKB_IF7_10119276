package com.uts.a10119276_myuas.Presenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.uts.a10119276_myuas.Auth.ResetPassword;
import com.uts.a10119276_myuas.Auth.SignInActivity;
import com.uts.a10119276_myuas.R;
import com.uts.a10119276_myuas.View.fragment.DiaryFragment;
import com.uts.a10119276_myuas.View.fragment.Fragment0;
import com.uts.a10119276_myuas.View.fragment.Profil;
import com.uts.a10119276_myuas.View.fragment.SignOut;

/**
 *  NIM   : 10119276
 *  Nama  : Nasthasa Wulan Ghani Sopian
 *  Kelas : IF-7
 */

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        getFragmentPage(new Profil());

        botNav = findViewById(R.id.botNav);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case
                            R.id.info:
                        fragment = new Fragment0();
                        break;
                    case
                            R.id.diary:
                        fragment = new DiaryFragment();
                        break;
                    case
                            R.id.profil:
                        fragment = new Profil();
                        break;
                    case
                            R.id.logout:
                        fragment = new SignOut();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });

    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.rv_diary, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}