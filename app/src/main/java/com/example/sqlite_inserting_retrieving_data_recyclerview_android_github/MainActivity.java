package com.example.sqlite_inserting_retrieving_data_recyclerview_android_github;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.database.DBHelper;
import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.model.DataItem;
import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.sample.SampleDataProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteOpenHelper sqLiteOpenHelper = new DBHelper(this);
        database = sqLiteOpenHelper.getWritableDatabase();
        Toast.makeText(getApplicationContext(),"Database Acquired",Toast.LENGTH_SHORT).show();

        DataItemAdapter dataItemAdapter = new DataItemAdapter(this,dataItemList);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(dataItemAdapter);

    }
}
