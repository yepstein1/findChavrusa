package com.example.findchavrusa;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findchavrusa.Database.AppViewModel;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private AppViewModel mUserViewModel;
    Users u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UserListAdapter adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUserViewModel = new ViewModelProvider(this).get(AppViewModel.class);
        mUserViewModel.getmUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> users) {

                adapter.setUsers(users);

                for (Users a : users
                ) {
                    Log.d("stuff from db", a.getUserName());
                    System.out.println(a.getUserName());
                }

            }
        });
    }

    // this code is nit being used currently
    public void load(View view) {
        Object o =  getIntent().getSerializableExtra("user");
Users u =(Users) o;

        String s = u.getUserName();
        String b=u.getPassword();

        System.out.println(s);
        Log.i("state of s", s);

        TextView tv = findViewById(R.id.textView);
        tv.setText(b);


    }


}
