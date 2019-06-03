package com.example.sqlite_inserting_retrieving_data_recyclerview_android_github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.model.DataItem;
import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.sample.SampleDataProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

    }
}
