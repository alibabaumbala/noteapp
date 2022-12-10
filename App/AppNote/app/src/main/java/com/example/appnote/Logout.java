package com.example.appnote;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


public class Logout extends Fragment {

    FirebaseAuth firebaseAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homefragment,container,false);

        firebaseAuth.getInstance().signOut();
        Intent intent=new Intent(getActivity(),Login.class);
        startActivity(intent);
        getActivity().finishAffinity();

        return view;
    }
}