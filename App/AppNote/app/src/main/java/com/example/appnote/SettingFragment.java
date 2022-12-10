package com.example.appnote;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class SettingFragment extends Fragment {
    Button btnGreen, btnWhite, btnBrown, btnRed, btnBold, btnItalic;
    DrawerLayout drawerLayout;
    LinearLayout linearLayout;
    EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.settingfragment,container,false);

        btnBold=view.findViewById(R.id.btnBold);
        btnItalic=view.findViewById(R.id.btnItalic);

        btnGreen=view.findViewById(R.id.btnGreen);
        btnWhite=view.findViewById(R.id.btnWhite);
        btnBrown=view.findViewById(R.id.btnBrown);
        btnRed=view.findViewById(R.id.btnRed);

        View view1 = getActivity().findViewById(R.id.drawarLayout);
        View view2 = getActivity().findViewById(R.id.navHeader);

        Typeface boldType = Typeface.defaultFromStyle(Typeface.BOLD);
        Typeface italicType = Typeface.defaultFromStyle(Typeface.ITALIC);

        btnBold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Áp dụng font BOLD thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnItalic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Áp dụng font ITALIC thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout = view1.findViewById(R.id.drawarLayout);
                linearLayout = view2.findViewById(R.id.navHeader);

                drawerLayout.setBackgroundResource(R.color.green);
                linearLayout.setBackgroundResource(R.color.green);
                Toast.makeText(getActivity(), "Áp dụng màu XANH LÁ thành công", Toast.LENGTH_SHORT).show();
            }
        });
        btnWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout = view1.findViewById(R.id.drawarLayout);
                linearLayout = view2.findViewById(R.id.navHeader);

                drawerLayout.setBackgroundResource(R.color.white);
                linearLayout.setBackgroundResource(R.drawable.toolbar_background);
                Toast.makeText(getActivity(), "Áp dụng màu MẶC ĐỊNH thành công", Toast.LENGTH_SHORT).show();
            }
        });
        btnBrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout = view1.findViewById(R.id.drawarLayout);
                linearLayout = view2.findViewById(R.id.navHeader);

                drawerLayout.setBackgroundResource(R.color.brown);
                linearLayout.setBackgroundResource(R.color.brown);
                Toast.makeText(getActivity(), "Áp dụng màu NÂU NHẠT thành công", Toast.LENGTH_SHORT).show();
            }
        });
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout = view1.findViewById(R.id.drawarLayout);
                linearLayout = view2.findViewById(R.id.navHeader);

                drawerLayout.setBackgroundResource(R.color.red);
                linearLayout.setBackgroundResource(R.color.red);
                Toast.makeText(getActivity(), "Áp dụng màu ĐỎ HỒNG thành công", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}

