package com.example.appdoan.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoan.R;

public class BookViewHolder extends   RecyclerView.ViewHolder {
    ImageView flagimage;
    TextView bookNameView;

    // @itemView: recyclerview_item_layout.xml
    public BookViewHolder(View itemView) {
        super(itemView);

        flagimage =  itemView.findViewById(R.id.placeImage);
        bookNameView = itemView.findViewById(R.id.placeName);
    }
}
