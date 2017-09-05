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
        if(title.get(position).length() > 0){
            titleText.setText(title.get(position));
            titleText.setVisibility(View.VISIBLE);
        }
        else{
            titleText.setVisibility(View.GONE);
        }

        TextView contentText = (TextView) vi.findViewById(R.id.content);
        if(content.get(position).length() > 0) {
            contentText.setText(content.get(position));
            contentText.setVisibility(View.VISIBLE);
        }
        else{
            contentText.setVisibility(View.GONE);
        }

        TextView dateText = (TextView) vi.findViewById(R.id.date);
        TextView datelabel = (TextView)vi.findViewById(R.id.dateLabel);
        if(date.get(position).length() > 0) {
            dateText.setText(date.get(position));
            dateText.setVisibility(View.VISIBLE);
            datelabel.setVisibility(View.VISIBLE);
        }
        else
        {
            dateText.setVisibility(View.GONE);
            datelabel.setVisibility(View.GONE);

        }
        return vi;
    }
}
