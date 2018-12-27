package com.example.mahdi.physicsformula;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

import java.util.List;
import java.util.Random;

public class homePage extends AppCompatActivity {
    Button btnclass12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ConstraintLayout CL=findViewById(R.id.ConstraintLayoutHome);
        Random rnd = new Random();
        int color = Color.argb(175, rnd.nextInt(256), rnd.nextInt(255), rnd.nextInt(255));
        CL.setBackgroundColor(color);
    }

    public void btnClass12(View view) {
        Intent intent = new Intent(homePage.this, ListPage.class);
        startActivity(intent);
    }

}
