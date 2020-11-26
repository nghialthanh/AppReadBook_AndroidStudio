package com.example.appdoan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appdoan.R;
import com.example.appdoan.entiti.Book;
import com.example.appdoan.entiti.Catagory;

import java.util.ArrayList;

public class BookCatagoryAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private ArrayList<Catagory> list;


    public BookCatagoryAdapter(Context context, ArrayList<Catagory> list) {
        this.list = list;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(this.list == null)  {
            return 0;
        }
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        Catagory bo = list.get(position);
        return bo.getId();
        // return position; (Return position if you need).
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Catagory book = list.get(i);


        View rowView = this.mLayoutInflater.inflate(R.layout.item_spinner, viewGroup,false);

        TextView textViewItemName = (TextView) rowView.findViewById(R.id.textView_item_name);
        textViewItemName.setText(book.getCatagoryName());

        TextView textViewItemPercent = (TextView) rowView.findViewById(R.id.textView_item_percent);
        textViewItemPercent.setText(String.valueOf(book.getCount()));

        return rowView;
    }

}
