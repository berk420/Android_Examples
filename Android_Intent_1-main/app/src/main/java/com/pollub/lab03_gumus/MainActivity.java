package com.pollub.lab03_gumus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    Button button1;
    TextView mCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String numberfrom3 =getIntent().getStringExtra("number");
        TextView mCounter =(TextView) findViewById(R.id.text);
        mCounter.setText(numberfrom3);
        if (numberfrom3 == null){
            numberfrom3 = "0";

        }
        button1 = (Button) findViewById(R.id.button_1id);
        String finalNumberfrom = numberfrom3;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int number= Integer.parseInt(finalNumberfrom);
                number++;
                String sendstr=String.valueOf(number);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("number",sendstr);

                mCounter.setText(sendstr);

                startActivity(intent);


            }
        });

        //setContentView(R.layout.activity_main);

    }
}


