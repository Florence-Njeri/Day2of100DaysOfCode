package com.example.android.day_2_of100_days_of_code;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Get the Intent that started this activity and extract the email string
        Intent emailIntent = getIntent();
        String email2 = emailIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView emailTextView = findViewById(R.id.emailTextView);
        emailTextView.setText(email2);

        // Get the Intent that started this activity and extract the password  string
        Intent passwordIntent = getIntent();
        String password2 = passwordIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
       TextView passwordTextView = findViewById(R.id.passwordTextView);
        passwordTextView.setText(password2);
    }
}
