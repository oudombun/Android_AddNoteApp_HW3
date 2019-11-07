package com.example.homework3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<DataModel> items;

    public CustomAdapter(Context context, ArrayList<DataModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.note_item_layout, parent, false);
        }
        // get current item to be displayed
        DataModel currentItem = (DataModel) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.txt1);
        TextView textViewItemDescription = (TextView)
                convertView.findViewById(R.id.txt2);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getTitle());
        textViewItemDescription.setText(currentItem.getDescription());
        return convertView;
    }
}
