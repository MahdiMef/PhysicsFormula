package com.example.mahdi.physicsformula;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class item_activity extends AppCompatActivity {
    Context context;
    TextView txt_title;
    TextView txt_content;
    Button btn_back;
    ImageView img_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);

        setup_objects();
        getData();


    }

    private void btn_back(View view) {

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
            Toast toast = Toast.makeText(this,"عکس لود نشده *بررسی کنید",Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    private void setup_objects() {
        btn_back = findViewById(R.id.btn_back);
        txt_title = findViewById(R.id.Title);
        txt_content = findViewById(R.id.Content);
        img_view = findViewById(R.id.img_IA);
    }
}
