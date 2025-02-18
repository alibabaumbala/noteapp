package com.example.appnote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity
{
    EditText emailsignup,passwordsignup,usernamesignup,repasswordsignup;
    private MaterialButton btnSignUp;
    private TextView haveAccount;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logup);

        usernamesignup=findViewById(R.id.usernamesignup);
        emailsignup=findViewById(R.id.emailusersignup);
        passwordsignup=findViewById(R.id.passworduser);
        repasswordsignup=findViewById(R.id.repassworduser);

        btnSignUp=findViewById(R.id.signbtn);
        haveAccount=findViewById(R.id.haveaccount);
        firebaseAuth=FirebaseAuth.getInstance();
        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=usernamesignup.getText().toString();
                String email=emailsignup.getText().toString();
                String pass=passwordsignup.getText().toString();
                String repass=repasswordsignup.getText().toString();
                if(username.isEmpty() || email.isEmpty() || pass.isEmpty() || repass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else if (email.isEmpty() || !email.contains("@"))
                {
                    Toast.makeText(getApplicationContext(),"Email không hợp lệ",Toast.LENGTH_SHORT).show();
                }
                else if (!repass.equals(pass)){
                    Toast.makeText(Signup.this, "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
                }
                else if (pass.length() < 5){
                    Toast.makeText(Signup.this, "Mật khẩu quá ngắn (< 5 kí tự)", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Signup.this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
                                sendEmail();
                            }
                            else
                            {
                                Toast.makeText(Signup.this, "Đăng ký tài khoản thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void sendEmail()
    {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(Signup.this, "Vui lòng kiểm tra email để kích hoạt tài khoản", Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(getApplicationContext(),Login.class));
                }
            });
        }
        else
        {
            Toast.makeText(this, "Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
        }
    }
}
