package com.example.findchavrusa;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findchavrusa.Database.AppViewModel;

import java.util.List;

public class DisplayTopicsActivity extends AppCompatActivity {
    private AppViewModel mUserViewModel;
    String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        load();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final UserListAdapter adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUserViewModel = new ViewModelProvider(this).get(AppViewModel.class);
        mUserViewModel.setRepositoryTopics(topic);
        mUserViewModel.getmTopics(topic).observe(this, new Observer<List<Topics_studied>>() {
            @Override
            public void onChanged(List<Topics_studied> topics) {

                adapter.setTopics(topics);

             /*   for (Topics_studied a : users
                ) {
                    Log.d("stuff from db", a.getUserName());
                    System.out.println(a.getUserName());
                }

              */

            }
        });
    }


    public void load() {
        Object o = getIntent().getSerializableExtra("topic");


        String s = o.toString();
        Log.d("topic", s);
        topic = s;


    }


}
