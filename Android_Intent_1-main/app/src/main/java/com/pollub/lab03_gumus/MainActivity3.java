package com.pollub.lab03_gumus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String data = getIntent().getStringExtra("number");
        TextView mCounter =(TextView) findViewById(R.id.textView);
        mCounter.setText(data);




        button3 = (Button) findViewById(R.id.button_3id);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int number= Integer.parseInt(data);
                number++;
                String sendstr=String.valueOf(number);
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);

                intent.putExtra("number",sendstr);

                mCounter.setText(sendstr);

                startActivity(intent);
            }
        });

    }
}