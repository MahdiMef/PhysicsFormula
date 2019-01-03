package com.example.mahdi.physicsformula;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class item_activity extends AppCompatActivity {
    Context context;
    TextView txt_title;
    TextView txt_content;
    ImageView img_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_items);

        //گرفتن دیتا
        setup_objects();
        getData();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //کلید برگشت صفحه لیست ها
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();     //تعریف کاستوم اکشن بار
        actionBar.setDisplayHomeAsUpEnabled(true);      //ست کردن کلید برگشت

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

    private void getData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra(DatabaseOpenHelper.COL_TITLE);
        String content = intent.getStringExtra(DatabaseOpenHelper.COL_CONTENT);
        String imageDB = intent.getStringExtra(Database_asset_helper.COL_IMG);
        txt_title.setText(title);
        txt_content.setText(content);

        //ست کردن عکس در اکتیویتی
        try {
            String uri = "drawable/" + imageDB;
            // int imageResource = R.drawable.icon;
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable imgdrawebale = getResources().getDrawable(imageResource);
            img_view.setImageDrawable(imgdrawebale);
        } catch (Exception e) {
            Toast toast = Toast.makeText(this, "عکس لود نشده *بررسی کنید", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    private void setup_objects() {
        txt_title = findViewById(R.id.Title);
        txt_content = findViewById(R.id.Content);
        img_view = findViewById(R.id.img_IA);
    }




}
