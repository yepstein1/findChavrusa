package com.example.findchavrusa;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class InsertTopicActivity extends AppCompatActivity {
    private EditText mEmail;
    private EditText mTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_topic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public Topics_studied getTnfo() {
        mEmail = findViewById(R.id.et_email);
        mTopic = findViewById(R.id.et_topic);
        Topics_studied ts = new Topics_studied(mEmail.getText().toString(), mTopic.getText().toString());
        return ts;

    }

}
