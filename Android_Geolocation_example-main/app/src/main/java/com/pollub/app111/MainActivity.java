package com.pollub.app111;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button butn1;
    public EditText t1,t2;
    public String lon,lat;
    public TextView txt;

    public  int x,y;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        butn1 =findViewById(R.id.button);
        t1=(EditText)findViewById(R.id.editTextTextPersonName);
        t2=(EditText)findViewById(R.id.editTextTextPersonName2);
        lon = (t1.getText().toString());
        lat = (t1.getText().toString());

        butn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                lon = (t1.getText().toString());
                lat = (t1.getText().toString());

                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:"+lon+","+lat));
                Intent chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);






            }
        });






    }
}