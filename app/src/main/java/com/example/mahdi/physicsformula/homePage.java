package com.example.mahdi.physicsformula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class homePage extends AppCompatActivity {
Button btnclass12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btnclass12=findViewById(R.id.btn_book12);


    }
    public void btnClass12(View view) {
        Intent intent= new Intent(homePage.this,ListPage.class);
        startActivity(intent);
    }

}
