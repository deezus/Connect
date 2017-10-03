package com.example.odile.connect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Odile on 30/09/2017.
 */
public class DeviceAdapter extends BaseAdapter{
    private Context context;
    private DeviceDataSource datasource;

    public List<Device> values;

    public DeviceAdapter(Context context, DeviceDataSource datasource) {
        this.context = context;
        this.datasource = datasource;
        try {
            this.datasource.open();
            this.values = datasource.getAllDevice();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Device currentDevice = (Device) getItem(position);
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        final View rowView = layoutInflater.inflate(
                R.layout.list_layout,
                parent,
                false
        );
        final TextView nameTextview = (TextView) rowView.findViewById(R.id.textView1);
        final TextView latTextview = (TextView) rowView.findViewById(R.id.textView2);
        final TextView lonTextview = (TextView) rowView.findViewById(R.id.textView3);
        //final TextView altTextview = (TextView) rowView.findViewById(R.id.textView5);
        //final TextView resuTextview = (TextView) rowView.findViewById(R.id.alt);

        nameTextview.setText(currentDevice.getName());
        latTextview.setText(currentDevice.getLatitude().toString());
        lonTextview.setText(currentDevice.getLongitude().toString());
        //gameTextview.setText(currentDevice.getLongitude());
        //resuTextview.setText(currentDevice.getAltitude());
        return rowView;
    }
}
