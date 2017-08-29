package com.azharchara.noteitdown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Azhar Chara on 21/08/17.
 */

public class Row_item extends BaseAdapter {
    Context context;
    ArrayList<String> title;
    ArrayList<String> content;
    ArrayList<String> date;
    int size;

    private static LayoutInflater inflater = null;

    public Row_item(Context context,int size, ArrayList<String> title, ArrayList<String> content, ArrayList<String> date) {

        this.context = context;
        this.title = title;
        this.content = content;
        this.date = date;
        this.size = size;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row_item, null);

        TextView titleText = (TextView) vi.findViewById(R.id.title);
        titleText.setText(title.get(position));

        TextView contentText = (TextView) vi.findViewById(R.id.content);
        contentText.setText(content.get(position));

        TextView dateText = (TextView) vi.findViewById(R.id.date);
        dateText.setText(date.get(position));

        return vi;
    }
}
