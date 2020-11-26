package com.example.appdoan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appdoan.entiti.Addbook;
import com.example.appdoan.entiti.Book;
import com.example.appdoan.entiti.VNCharacterUtils;
import com.folioreader.Config;
import com.folioreader.FolioReader;
import com.folioreader.model.locators.ReadLocator;
import com.folioreader.util.AppUtil;
import com.folioreader.util.ReadLocatorListener;

import java.util.ArrayList;

public class Search extends AppCompatActivity implements ReadLocatorListener, FolioReader.OnClosedListener{
    public static final String LOG_TAG = "DO AN";

    private ViewPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    ActionBar actionBar;
    ListView ls;
    ArrayList<Book> lsbo;
    ArrayList<String> ls1;
    private static long back_pressed;
    private static final int TIME_DELAY = 2000;
    private FolioReader folioReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        folioReader = FolioReader.get()
                .setReadLocatorListener(this)
                .setOnClosedListener(this);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        actionBar.setTitle("Tìm kiếm");
        Intent inte = getIntent();
        String query = inte.getStringExtra("data");
        ls = findViewById(R.id.ls1);
        lsbo = Addbook.getListData();
         ls1 = new ArrayList<String>();
        for (Book b: lsbo){
            String s = VNCharacterUtils.removeAccent(b.getBookName());
            if(s.toLowerCase().contains(query.toLowerCase()))
                ls1.add(b.getBookName());

        }
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , ls1);
        ls.setAdapter(arrayAdapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int imageResId = 0;
                for (Book b: lsbo) {
                    if (ls1.get(i).equals(b.getBookName())) {
                        imageResId = getDrawableResIdByName1(b.getImageName());
                        break;
                    }
                }
                Config config = AppUtil.getSavedConfig(getApplicationContext());
                if (config == null)
                    config = new Config();
                config.setAllowedDirection(Config.AllowedDirection.VERTICAL_AND_HORIZONTAL);

                folioReader.setConfig(config, true)
                        .openBook(imageResId);
            }
        });

    }
    public int getDrawableResIdByName1(String resName)  {
        String pkgName = getPackageName();
        int resID;
        // Return 0 if not found.
        resID = getResources().getIdentifier(resName , "raw", pkgName);
        Log.i(MainActivity.LOG_TAG, "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.Search));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ls1 = new ArrayList<String>();
                for (Book b: lsbo){
                    String s = VNCharacterUtils.removeAccent(b.getBookName());
                    if(s.toLowerCase().contains(query.toLowerCase()))
                        ls1.add(b.getBookName());
                    ArrayAdapter<String> arrayAdapter
                            = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1 , ls1);
                    ls.setAdapter(arrayAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onFolioReaderClosed() {

    }

    @Override
    public void saveReadLocator(ReadLocator readLocator) {

    }
}
