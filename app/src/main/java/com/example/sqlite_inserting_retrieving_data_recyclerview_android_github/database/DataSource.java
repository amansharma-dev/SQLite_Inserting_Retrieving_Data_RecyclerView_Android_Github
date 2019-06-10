package com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.model.DataItem;

public class DataSource {

    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;


    public DataSource(Context context) {
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public DataItem createItem(DataItem item){
        ContentValues contentValues = item.contentValues();
        sqLiteDatabase.insert(ItemsTable.TABLE_NAME,null,contentValues);
        return item;
    }


    public long getDataItemCount(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,ItemsTable.TABLE_NAME);
    }


}
