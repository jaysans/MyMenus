package com.example.jaysan.mymenus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class MenuClickListener implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                Intent openAddMenu = new Intent(getApplicationContext(), RestaurantActivity.class);

                switch (v.getId()) {
                    case R.id.alexey:
                        openAddMenu.putExtra("info", 1);
                        Log.i("tag2", "wtf its" + openAddMenu.getIntExtra("info", 0));
                        break;

                    case R.id.he:
                        openAddMenu.putExtra("info", 2);
                        Log.i("tag2", "wtf its" + openAddMenu.getIntExtra("info", 0));
                        break;

                        default:
                            break;
                }
                startActivity(openAddMenu);
            }
        }

        MenuClickListener click = new MenuClickListener();
        View addbutton = findViewById(R.id.addbutton);
        addbutton.setOnClickListener(click);

        View hebutton = findViewById(R.id.he);
        hebutton.setOnClickListener(click);

        View alexbutton = findViewById(R.id.alexey);
        alexbutton.setOnClickListener(click);




    }

}
