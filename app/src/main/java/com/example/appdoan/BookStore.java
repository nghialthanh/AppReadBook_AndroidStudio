package com.example.appdoan;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.appdoan.adapter.BookAdapter;
import com.example.appdoan.entiti.Addbook;
import com.example.appdoan.entiti.Book;

import java.util.ArrayList;
import java.util.List;

//Show view
public class BookStore extends Fragment {
    private RecyclerView recyclerView;
    public BookStore() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_store, container, false);
//        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rl_fragment);
//
        ArrayList<Book> book = Addbook.getListData();
        this.recyclerView = rootView.findViewById(R.id.rl_list);
        recyclerView.setAdapter(new BookAdapter(getActivity().getApplicationContext(), book));

        // RecyclerView scroll vertical
        StaggeredGridLayoutManager mStaggeredLayoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredLayoutManager1.supportsPredictiveItemAnimations();
        mStaggeredLayoutManager1.requestSimpleAnimationsInNextLayout();
        mStaggeredLayoutManager1.isSmoothScrolling();
        recyclerView.setLayoutManager(mStaggeredLayoutManager1);
        return rootView;

    }

}

