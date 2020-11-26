package com.example.appdoan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoan.MainActivity;
import com.example.appdoan.R;
import com.example.appdoan.entiti.Book;
import com.folioreader.Config;
import com.folioreader.FolioReader;
import com.folioreader.model.locators.ReadLocator;
import com.folioreader.util.AppUtil;
import com.folioreader.util.ReadLocatorListener;

import java.util.ArrayList;


public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> implements  ReadLocatorListener, FolioReader.OnClosedListener{
    private static final String LOG_TAG = BookAdapter.class.getSimpleName();
    public static  final ArrayList<Book> mybook = new ArrayList<>();
    private FolioReader folioReader;
    private ArrayList<Book> books;
    private Context context;
    private LayoutInflater mLayoutInflater;
    //////
    public BookAdapter(Context context, ArrayList<Book> datas ) {
        this.context = context;
        this.books = datas;
        this.mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public BookViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // Inflate view from recyclerview_item_layout.xml
        View recyclerViewItem = mLayoutInflater.inflate(R.layout.item_book,parent,false);

        recyclerViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRecyclerItemClick( (RecyclerView)parent, v);
            }
        });
        recyclerViewItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                handleRecyclerItemClick( (RecyclerView)parent, view);
                return false;
            }
        });
        return new BookViewHolder(recyclerViewItem);
    }


    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        // Cet country in countries via position
        Book book = books.get(position);

        int imageResId = this.getDrawableResIdByName(book.getImageName());

        // Bind data to viewholder
        holder.flagimage.setImageResource(imageResId);
        holder.bookNameView.setText(book.getBookName());
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }



    // Click on RecyclerView Item.
    private void handleRecyclerItemClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        Book book = this.books.get(itemPosition);
        int imageResId = this.getDrawableResIdByName1(book.getImageName());
        folioReader = FolioReader.get()
                .setReadLocatorListener(this)
                .setOnClosedListener(this);
        Config config = AppUtil.getSavedConfig(context.getApplicationContext());
        if (config == null)
            config = new Config();
        config.setAllowedDirection(Config.AllowedDirection.VERTICAL_AND_HORIZONTAL);

        folioReader.setConfig(config, true)
                .openBook(imageResId);
    }
    private void handleRecyclerItemClick1(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        Book book = this.books.get(itemPosition);
        mybook.add(book);
        Toast.makeText(context,"yooooo",Toast.LENGTH_LONG);
    }
    // Find Image ID corresponding to the name of the image (in the directory drawable).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        int resID;
        // Return 0 if not found.
            resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i(MainActivity.LOG_TAG, "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
    public int getDrawableResIdByName1(String resName)  {
        String pkgName = context.getPackageName();
        int resID;
        // Return 0 if not found.
        resID = context.getResources().getIdentifier(resName , "raw", pkgName);
        Log.i(MainActivity.LOG_TAG, "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
    @Override
    public void saveReadLocator(ReadLocator readLocator) {
        Log.i(LOG_TAG, "-> saveReadLocator -> " + readLocator.toJson());
    }
    @Override
    public void onFolioReaderClosed() {
        Log.v(LOG_TAG, "-> onFolioReaderClosed");
    }
}
