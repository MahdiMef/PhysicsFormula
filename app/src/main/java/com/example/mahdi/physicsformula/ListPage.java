package com.example.mahdi.physicsformula;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.List;

public class ListPage extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_lists);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //کلید برگشت صفحه لیست ها
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();     //تعریف کاستوم اکشن بار
        actionBar.setDisplayHomeAsUpEnabled(true);      //ست کردن کلید برگشت



        //گرفتن دیتا
        setupe_recycleView();
        getItems_from_database();
    }


    // فعال کردن کلید بازگشت به صفحه قبل
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupe_recycleView() {
        recyclerView = findViewById(R.id.recycleView);
        int spancount = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(ListPage.this, spancount));

    }

    private void getItems_from_database() {
        Database_asset_helper databaseAssetHelper = new Database_asset_helper(this);
        List<items> items = databaseAssetHelper.getitems();
        AdapterRV_formula adapterRV_formula = new AdapterRV_formula(ListPage.this, items);
        recyclerView.setAdapter(adapterRV_formula);
    }
}
