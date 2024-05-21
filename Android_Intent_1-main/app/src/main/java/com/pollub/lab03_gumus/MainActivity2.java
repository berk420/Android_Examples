package com.pollub.lab03_gumus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String data = getIntent().getStringExtra("number");
        TextView mCounter =(TextView) findViewById(R.id.tx1);
        mCounter.setText(data);



        button2 = (Button) findViewById(R.id.button_2id);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int number= Integer.parseInt(data);
                number++;
                String sendstr=String.valueOf(number);
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

                intent.putExtra("number",sendstr);

                mCounter.setText(sendstr);

                startActivity(intent);
            }
        });
    }
}