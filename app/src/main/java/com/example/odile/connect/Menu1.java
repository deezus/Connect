package com.example.odile.connect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Odile on 01/10/2017.
 */
public class Menu1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        //String[] list = {"list1","list2","list3","list4","list5","list6","list7","list8","list9","list10"};
        //ListAdapter adapter = new ArrayAdapter<String>(getContext(), R.layout.fragment_one, list);
        //ListView adapterView = (ListView) rootView.findViewById(R.id.list_view);
        //adapterView.setAdapter(adapter);

        final DeviceDataSource deviceDataSource = new DeviceDataSource(this.getContext());
        DeviceAdapter da = new DeviceAdapter(this.getContext(), deviceDataSource);

        ListView list = (ListView) rootView.findViewById(R.id.list_view);
        list.setAdapter(da);

        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(getActivity(), AddDeviceActivity.class);
                startActivity(intent);
            }
        });
        getActivity().setTitle("Menu 1");
    }


}