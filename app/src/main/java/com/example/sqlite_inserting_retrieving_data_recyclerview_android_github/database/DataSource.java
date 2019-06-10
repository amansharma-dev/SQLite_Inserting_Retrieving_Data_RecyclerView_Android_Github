package com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.model.DataItem;

import java.util.ArrayList;
import java.util.List;

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

    public void seedDatabase(List<DataItem> dataItemList){
        long num = getDataItemCount();
        if(num == 0){
            for (DataItem item : dataItemList){
                try {
                    createItem(item);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
            Toast.makeText(context,"Data inserted.",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"Data already inserted.",Toast.LENGTH_LONG).show();
        }
    }

    public List<DataItem> getAllItems(){
        List<DataItem> dataItemList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(ItemsTable.TABLE_NAME,ItemsTable.ALL_COLUMNS,null,null,null,null,null);
        while (cursor.moveToNext()){
            DataItem dataItem = new DataItem();
            dataItem.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            dataItem.setArtistImage(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ARTIST_IMAGE)));
            dataItem.setSongName(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_SONG_NAME)));
            dataItem.setArtistName(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ARTIST_NAME)));
            dataItem.setArtistGenre(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ARTIST_GENRE)));
            dataItem.setSongPrice(cursor.getDouble(cursor.getColumnIndex(ItemsTable.COLUMN_SONG_PRICE)));

            dataItemList.add(dataItem);
        }
        return dataItemList;
    }
}
