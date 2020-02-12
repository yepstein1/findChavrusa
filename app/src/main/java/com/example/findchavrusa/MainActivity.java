package com.example.findchavrusa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.findchavrusa.Database.AppViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    EditText mEmail;
    EditText mPassword;
    String email;
    AppViewModel mModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mModel = new ViewModelProvider(this).get(AppViewModel.class);
        final Intent intent = new Intent(this, DisplayTopicsActivity.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users u = getUserInfo();
                //  intent.putExtra("user",u);
                mModel.insert(u);

                startActivity(intent);
                //hopefully send to db

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public Users getUserInfo() {
        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        email = mEmail.getText().toString();
        Log.i( "getUserInfo: ",email);
        password = mPassword.getText().toString();
        //  email= "nnn";
        Users user = new Users(email, password);
        return user;


    }


}
