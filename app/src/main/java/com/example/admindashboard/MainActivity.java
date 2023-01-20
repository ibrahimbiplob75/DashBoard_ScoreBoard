package com.example.admindashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView addImage,addNotice;
        addNotice = findViewById(R.id.addNotice);
        addImage=findViewById(R.id.addimage);

        addNotice.setOnClickListener(this);
    }

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.addNotice: {
                        Intent NoticeIntent = (new Intent(MainActivity.this, uploadNotice.class));
                        startActivity(NoticeIntent);
                        break;
                    }

                    case R.id.addimage: {
                        Intent imageIntent = (new Intent(MainActivity.this, addImage.class));
                        startActivity(imageIntent);
                        break;
                    }
                }

            }



}