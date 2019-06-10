package com.example.sqlite_inserting_retrieving_data_recyclerview_android_github.database;

public class ItemsTable {

    public static final String TABLE_NAME = "items";
    public static final String COLUMN_ID = "itemId";
    public static final String COLUMN_ARTIST_IMAGE = "artistImage";
    public static final String COLUMN_SONG_NAME = "songName";
    public static final String COLUMN_ARTIST_NAME = "artistName";
    public static final String COLUMN_ARTIST_GENRE = "artistGenre";
    public static final String COLUMN_SONG_PRICE = "songPrice";

    public static final String[] ALL_COLUMNS = {COLUMN_ID,
            COLUMN_ARTIST_IMAGE,COLUMN_SONG_NAME,COLUMN_ARTIST_NAME,
            COLUMN_ARTIST_GENRE,COLUMN_SONG_PRICE};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_ARTIST_IMAGE + " TEXT," +
                    COLUMN_SONG_NAME + " TEXT," +
                    COLUMN_ARTIST_NAME + " TEXT," +
                    COLUMN_ARTIST_GENRE + " TEXT," +
                    COLUMN_SONG_PRICE + " REAL" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_NAME;

}
