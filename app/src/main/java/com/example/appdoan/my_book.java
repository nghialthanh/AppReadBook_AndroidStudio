package com.example.appdoan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appdoan.adapter.BookAdapter;
import com.example.appdoan.entiti.Addbook;
import com.example.appdoan.entiti.Book;

import java.util.ArrayList;


public class my_book extends Fragment {
    private RecyclerView recyclerView;
    public my_book() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book_store, container, false);
//        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rl_fragment);
//
        ArrayList<Book> book = Addbook.getListData();
        this.recyclerView = rootView.findViewById(R.id.rl_list);
        recyclerView.setAdapter(new BookAdapter(getActivity().getApplicationContext(), BookAdapter.mybook));

        // RecyclerView scroll vertical
        StaggeredGridLayoutManager mStaggeredLayoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredLayoutManager1.supportsPredictiveItemAnimations();
        mStaggeredLayoutManager1.requestSimpleAnimationsInNextLayout();
        mStaggeredLayoutManager1.isSmoothScrolling();
        recyclerView.setLayoutManager(mStaggeredLayoutManager1);
        return rootView;

    }
}
