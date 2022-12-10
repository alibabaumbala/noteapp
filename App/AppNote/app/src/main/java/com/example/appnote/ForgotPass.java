package com.example.appnote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

public class ForgotPass extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    EditText inputEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpass);
        inputEmail=findViewById(R.id.inputEmailToSendOTP);
        firebaseAuth = FirebaseAuth.getInstance();

        Button btnsendOTP=findViewById(R.id.btnSendOTP);
        btnsendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                sendOTP();
            }
        });
    }
    private void sendOTP(){
        String email = inputEmail.getText().toString().trim();

        if(email.isEmpty())
        {
            Toast.makeText(ForgotPass.this, "Vui lòng nhập địa chỉ email", Toast.LENGTH_SHORT).show();
        }


        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(ForgotPass.this,"Đã gửi xác minh đến email khôi phục mật khẩu",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ForgotPass.this,"Địa chỉ email không chính xác",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}