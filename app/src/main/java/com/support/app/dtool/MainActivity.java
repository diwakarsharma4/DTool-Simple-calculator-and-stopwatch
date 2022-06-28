package com.support.app.dtool;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatDelegate;
import android.annotation.SuppressLint;

public class MainActivity extends AppCompatActivity {


    CardView card1,card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity);



        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.teal_200));

        card1 = findViewById(R.id.first);
        card2 = findViewById(R.id.two);

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        SwitchCompat themeBtn = findViewById(R.id.themeBtn);
        themeBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else{
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }



    public void card1(View view) {
        Intent intent = new Intent(this,calculator.class);
        startActivity(intent);
    }

    public void card2(View view) {
        Intent intent = new Intent(this,stopWatch.class);
        startActivity(intent);
    }

}