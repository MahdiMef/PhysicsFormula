package com.example.mahdi.physicsformula;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class homePage extends AppCompatActivity {
    Button btnclass12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydrawer);
//        ConstraintLayout CL=findViewById(R.id.ConstraintLayoutHome);
//        Random rnd = new Random();
//        int color = Color.argb(175, rnd.nextInt(256), rnd.nextInt(255), rnd.nextInt(255));
//        CL.setBackgroundColor(color);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        //کلید باز و بسته شدن دراور
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView =  findViewById(R.id.nav_view);

    }

    public void btnClass12(View view) {
        Intent intent = new Intent(homePage.this, ListPage.class);
        startActivity(intent);
    }

}
