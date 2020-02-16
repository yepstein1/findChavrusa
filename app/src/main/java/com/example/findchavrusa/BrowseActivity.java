package com.example.findchavrusa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class BrowseActivity extends AppCompatActivity {
    public static final String LAST_SEARCH = "last_search";
    EditText et;

    public void togglemPrefUseAutoSave() {
        this.mPrefUseAutoSave = !this.mPrefUseAutoSave;
    }

    boolean mPrefUseAutoSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        Toolbar toolbar = findViewById(R.id.toolbar);
        et = findViewById(R.id.et_topic);
        et.setText(loadSavedPreviousSearch());
        setSupportActionBar(toolbar);
        final Intent intent = new Intent(this, DisplayTopicsActivity.class);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("topic", getSearchTopic());
                Autosave();

                startActivity(intent);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void Autosave() {
        if (mPrefUseAutoSave) {
            SharedPreferences sharedPref = getSharedPreferences("searches", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(LAST_SEARCH, et.getText().toString());
            editor.apply();
        }

    }

    private String loadSavedPreviousSearch() {
        SharedPreferences sharedPref = getSharedPreferences("searches", Context.MODE_PRIVATE);
        String s = sharedPref.getString(LAST_SEARCH, "");
        return s;
    }

    private void toggleMenuItem(MenuItem item) {
        item.setChecked(!item.isChecked());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_browse, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_insert:
                Intent intent = new Intent(this, InsertTopicActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_sbout:
                Intent intent2 = new Intent(this, AboutActivity.class);
                startActivity(intent2);
                return true;

            case R.id.action_toggle_auto_save:
                toggleMenuItem(item);
                togglemPrefUseAutoSave();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    public String getSearchTopic() {
        return et.getText().toString();
    }

}
