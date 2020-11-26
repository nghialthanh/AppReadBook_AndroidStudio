package com.example.appdoan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appdoan.adapter.BookAdapter;
import com.example.appdoan.adapter.BookCatagoryAdapter;
import com.example.appdoan.entiti.AddCatagory;
import com.example.appdoan.entiti.Addbook;
import com.example.appdoan.entiti.Book;
import com.example.appdoan.entiti.Catagory;

import java.util.ArrayList;


public class BookCatagory extends Fragment {
    private static final String LOG_TAG = BookCatagory.class.getSimpleName();
    RecyclerView recyclerView;
    private Spinner spinner;
    private ArrayList<Catagory> list;
    private ArrayList<Book> b1 = new ArrayList<>();
    private ArrayList<Book> b2 = new ArrayList<>();
    private ArrayList<Book> b3 = new ArrayList<>();
    private ArrayList<Book> b4 = new ArrayList<>();
    public BookCatagory() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_book_catagory, container, false);

        ArrayList<Book> book = Addbook.getListData();
        this.list = AddCatagory.getCata(book);
        //////Phan chia list book


        for (Book b: book){
            if(b.getCategoryID()==1)
                b1.add(b);
            else if (b.getCategoryID()==2)
                b2.add(b);
            else if (b.getCategoryID()==3)
                b3.add(b);
            else
                b4.add(b);

        }
        /////////spinner
        spinner = rootView.findViewById(R.id.spinner_cata);

        // Adapter"
        BookCatagoryAdapter adapter = new BookCatagoryAdapter(getActivity().getApplicationContext(), list);
        spinner.setAdapter(adapter);
        this.recyclerView = rootView.findViewById(R.id.rl_list);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Book> b;
                if(list.get(i).getId()==1)
                    b=b1;
                else if(list.get(i).getId()==2)
                    b=b2;
                else if(list.get(i).getId()==3)
                    b=b3;
                else b=b4;
                recyclerView.setAdapter(new BookAdapter(getActivity().getApplicationContext(), b));

                // RecyclerView scroll vertical
                StaggeredGridLayoutManager mStaggeredLayoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                mStaggeredLayoutManager1.supportsPredictiveItemAnimations();
                mStaggeredLayoutManager1.requestSimpleAnimationsInNextLayout();
                mStaggeredLayoutManager1.isSmoothScrolling();
                recyclerView.setLayoutManager(mStaggeredLayoutManager1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        return rootView;

    }

}