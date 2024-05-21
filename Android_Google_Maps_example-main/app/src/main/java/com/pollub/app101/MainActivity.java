package com.pollub.app101;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
private ImageButton launch_btn1,launch_btn2,launch_btn3;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        launch_btn1 =findViewById(R.id.imageButton);
        launch_btn2 =findViewById(R.id.imageButton2);
        launch_btn3 =findViewById(R.id.imageButton3);


        launch_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:60.47201,8.4689"));
                Intent chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        launch_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:39.0742,21.8243"));
                Intent chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
        launch_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:39.925533,32.866287"));
                Intent chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);

            }
        });
    }
}