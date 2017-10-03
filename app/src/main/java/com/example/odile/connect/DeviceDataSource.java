package com.example.odile.connect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odile on 30/09/2017.
 */
public class DeviceDataSource {
    private SQLiteDatabase database;
    private DeviceSQL sd;
    private String[] allColumns = {
            DeviceSQL.COLUMN_ID,
            DeviceSQL.COLUMN_TIME,
            DeviceSQL.COLUMN_NAME,
            DeviceSQL.COLUMN_LATITUDE,
            DeviceSQL.COLUMN_LONGITUDE
            //DeviceSQL.COLUMN_ALTITUDE
    };

    public DeviceDataSource(Context context) {
        sd = new DeviceSQL(context);
    }

    public void open() throws SQLException {
        database = sd.getWritableDatabase();
    }

    public void close() {
        sd.close();
    }

    public Device createDevice(String Time, String Name, Double Latitude, Double Longitude/*, Double Altitude*/) {
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ContentValues values = new ContentValues();
        values.put(DeviceSQL.COLUMN_TIME, Time);
        values.put(DeviceSQL.COLUMN_NAME, Name);
        values.put(DeviceSQL.COLUMN_LATITUDE, Latitude);
        values.put(DeviceSQL.COLUMN_LONGITUDE, Longitude);
        //values.put(DeviceSQL.COLUMN_ALTITUDE, Altitude);
        long insertId = database.insert(DeviceSQL.TABLE_DEVICE, null, values);
        //sc = database;
        Cursor cursor = database.query(DeviceSQL.TABLE_DEVICE,
                allColumns, DeviceSQL.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Device newDevice = cursorToComment(cursor);
        cursor.close();
        close();
        System.out.println("Comment created with id: " + insertId);
        return newDevice;
    }

    public void deleteDevice(Device device) {
        long id = device.getId();
        //System.out.println("Comment deleted with id: " + id);
        database.delete(DeviceSQL.TABLE_DEVICE, DeviceSQL.COLUMN_ID + " = " + id, null);
    }

    public List<Device> getAllDevice() {
        List<Device> comments = new ArrayList<Device>();

        Cursor cursor = database.query(DeviceSQL.TABLE_DEVICE,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Device device = cursorToComment(cursor);
            comments.add(device);
            cursor.moveToNext();
        }
        cursor.close();
        return comments;
    }

    private Device cursorToComment(Cursor cursor) {
        Device device = new Device();
        device.setId(cursor.getLong(0));
        device.setTime(cursor.getString(1));
        device.setName(cursor.getString(2));
        device.setLongitude(cursor.getDouble(3));
        device.setLatitude(cursor.getDouble(4));
        //device.setAltitude(cursor.getDouble(5));

        return device;
    }
}
