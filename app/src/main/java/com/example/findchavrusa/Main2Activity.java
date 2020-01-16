package com.example.findchavrusa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void load(View view) {
        Object o =  getIntent().getSerializableExtra("user");
Users u =(Users) o;

        String s = u.getEmail();
        String b=u.getPassword();

        System.out.println(s);
        Log.i("state of s", s);

        TextView tv = findViewById(R.id.textView);
        tv.setText(b);


    }
}
