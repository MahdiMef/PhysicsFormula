package com.example.mahdi.physicsformula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListPage extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        setupe_recycleView();
        getItems_from_database();
    }

    private void setupe_recycleView() {
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListPage.this));

    }

    private void getItems_from_database() {
        Database_asset_helper databaseAssetHelper = new Database_asset_helper(this);
        List<items> items=databaseAssetHelper.getitems();
        AdapterRV_formula adapterRV_formula = new AdapterRV_formula(ListPage.this, items);
        recyclerView.setAdapter(adapterRV_formula);
    }
}
