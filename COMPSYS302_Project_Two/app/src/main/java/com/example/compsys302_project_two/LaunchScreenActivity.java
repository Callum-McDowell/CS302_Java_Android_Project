package com.example.compsys302_project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // setTheme(R.style.Theme_COMPSYS302_Project_Two_LaunchScreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        Intent mainActivity = new Intent(getBaseContext(), MainActivity.class);
        startActivity(mainActivity);
    }
}