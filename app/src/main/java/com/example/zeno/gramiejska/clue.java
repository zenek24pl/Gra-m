package com.example.zeno.gramiejska;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by zeno on 2016-04-24.
 */
public class clue extends ArrayAdapter<String> {
    private Activity context;
    private String[] jezyki;

    public clue(Activity context, String[] jezyki) {
        super(context, R.layout.custom_list_item, jezyki);
        this.context = context;
        this.jezyki = jezyki;
    }

    static class ViewHolder {
        public TextView tvLanguage;
        public TextView tvItemNumber;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View rowView = convertView;
        if(rowView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            rowView = layoutInflater.inflate(R.layout.custom_list_item, null, true);
            viewHolder = new ViewHolder();
            viewHolder.tvLanguage = (TextView) rowView.findViewById(R.id.tvLanguage);
            viewHolder.tvItemNumber = (TextView) rowView.findViewById(R.id.tvItemNumber);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }
        viewHolder.tvItemNumber.setText(Integer.toString(position));
        viewHolder.tvLanguage.setText(jezyki[position]);
        return rowView;
    }
}
