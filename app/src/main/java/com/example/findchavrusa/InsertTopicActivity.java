package com.example.findchavrusa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.findchavrusa.Database.AppViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class InsertTopicActivity extends AppCompatActivity {
    private EditText mEmail;
    private EditText mTopic;
    AppViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_topic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mModel = new ViewModelProvider(this).get(AppViewModel.class);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mModel.insertTopic(getTnfo());

                Snackbar.make(view, "Topic added", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent intent = new Intent(this, BrowseActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_sbout:
                Intent intent2 = new Intent(this, AboutActivity.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public Topics_studied getTnfo() {
        mEmail = findViewById(R.id.et_email);
        mTopic = findViewById(R.id.et_topic);
        Topics_studied ts = new Topics_studied(mEmail.getText().toString(), mTopic.getText().toString());
        return ts;

    }

}
