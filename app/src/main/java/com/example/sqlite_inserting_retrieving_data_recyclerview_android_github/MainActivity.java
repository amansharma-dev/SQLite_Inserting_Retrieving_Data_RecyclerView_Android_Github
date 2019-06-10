package com.example.sqlite_inserting_retrieving_data_recyclerview_android_github;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.database.DBHelper;
import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.database.DataSource;
import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.model.DataItem;
import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.sample.SampleDataProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;

    DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new DataSource(this);
        dataSource.open();
        dataSource.seedDatabase(dataItemList);
        Toast.makeText(getApplicationContext(),"Database Acquired",Toast.LENGTH_SHORT).show();

        List<DataItem> listFromDb = dataSource.getAllItems();


        DataItemAdapter dataItemAdapter = new DataItemAdapter(this,listFromDb);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(dataItemAdapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        dataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataSource.open();
    }
}
