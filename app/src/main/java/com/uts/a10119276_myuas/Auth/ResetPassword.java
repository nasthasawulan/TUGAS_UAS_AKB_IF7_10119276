package com.uts.a10119276_myuas.Auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.uts.a10119276_myuas.R;

public class ResetPassword extends AppCompatActivity {

    private EditText inputEmail;
    private Button btnSendResetEmail, btnBack;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        inputEmail = (EditText) findViewById(R.id.email);
        btnSendResetEmail = (Button) findViewById(R.id.button_reset_email);
        btnBack = (Button) findViewById(R.id.back);

        auth = FirebaseAuth.getInstance();


        btnSendResetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(inputEmail.getText().toString())) {
                    inputEmail.setError("Email harus diisi");
                } else {
                    auth.sendPasswordResetEmail(inputEmail.getText().toString()).addOnCompleteListener(ResetPassword.this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ResetPassword.this, "Instruksi reset password berhasil dikirim ke email", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ResetPassword.this, "Instruksi reset password gagal dikirim ke email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResetPassword.this, SignInActivity.class));
            }
        });
    }

}