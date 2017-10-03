package com.example.odile.connect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Odile on 30/09/2017.
 */
public class DeviceSQL extends SQLiteOpenHelper{
    public static final String TABLE_DEVICE = "device";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";
    //public static final String COLUMN_ALTITUDE = "altitude";

    private static final String DATABASE_NAME = "device.db";
    private static int DATABASE_VERSION = 3;

    public DeviceSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_DEVICE
                + "(" + COLUMN_ID + " integer primary key autoincrement, "
                + COLUMN_TIME + " text, "
                + COLUMN_NAME + " text not null, "
                + COLUMN_LATITUDE + " text not null, "
                + COLUMN_LONGITUDE + " text not null); ");
                //+ COLUMN_ALTITUDE + "text not null); ");
        //System.out.println("created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
