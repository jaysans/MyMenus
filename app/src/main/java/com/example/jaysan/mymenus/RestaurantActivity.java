package com.example.jaysan.mymenus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant);

      final ArrayList<Integer> menuList = new ArrayList<>();
        menuList.add(R.drawable.sarah_deremer);
        menuList.add(R.drawable.alexey_kondakov);
        menuList.add(R.drawable.he_jiaying);

        Intent what = getIntent();
        int i = what.getIntExtra("info", 0);
        Log.i("tag", "omg it's"+ i);

        ImageView menuImage = (ImageView) findViewById(R.id.menuImage);
        menuImage.setImageResource(menuList.get(i));

        final ImageView enlargeImage = (ImageView) findViewById(R.id.expandedMenu);
        enlargeImage.setImageResource(menuList.get(i));


        class ImageClickListener implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                enlargeImage.setOnClickListener(this);

                switch (v.getId()) {

                    case R.id.expandedMenu:
                        enlargeImage.setVisibility(View.GONE);
                        break;

                    case R.id.menuImage:
                        enlargeImage.setVisibility(View.VISIBLE);
                        enlargeImage.setBackgroundColor(0xff000000);
                        break;

                    default:
                        break;
                }
            }
        }
        ImageClickListener expandClick = new ImageClickListener();
        menuImage.setOnClickListener(expandClick);

    }
}
