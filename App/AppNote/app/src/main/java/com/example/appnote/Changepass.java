package com.example.appnote;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Changepass extends Fragment {

    EditText newpass,renewpass;
    Button changepass;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.changepass,container,false);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

        newpass=view.findViewById(R.id.newpass);
        renewpass=view.findViewById(R.id.renewpass);

        changepass=view.findViewById(R.id.changepassbtn);
        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newpass.getText().toString().isEmpty() || renewpass.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(), "Vui lòng nhập đày đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(newpass.getText().toString().length() < 5 || renewpass.getText().toString().length() < 5)
                {
                    Toast.makeText(getActivity(), "Mật khẩu phải > 5 kí tự", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!newpass.getText().toString().equals(renewpass.getText().toString()))
                {
                    Toast.makeText(getActivity(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(newpass.getText().toString().equals(renewpass.getText().toString()))
                {
                    user.updatePassword(newpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getActivity(), "Cập nhật mật khẩu mới thành công", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getActivity(),Login.class);
                                startActivity(intent);
                                getActivity().finishAffinity();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        return view;
    }
}