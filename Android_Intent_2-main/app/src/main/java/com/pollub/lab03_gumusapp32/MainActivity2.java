package com.pollub.lab03_gumusapp32;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    int  firstnumber,secondnumber;
    int add,sub,multi,divi;
    String resulttxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("SubActivity");

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("resulttxt");

        TextView numbershow1 =findViewById(R.id.result1);
        TextView numbershow2 =findViewById(R.id.result2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView resultshow=findViewById(R.id.textView8);

        firstnumber= getIntent().getIntExtra("firstnumber",0);
        secondnumber= getIntent().getIntExtra("secondnumber",0);
        resulttxt= String.valueOf(getIntent().getIntExtra("resulttxt",0));




        numbershow1.setText(String.valueOf(firstnumber));
        numbershow2.setText(String.valueOf(secondnumber));
        resultshow.setText(String.valueOf(message));



    }

    public void finish(){

        Intent i =new Intent();
        i.putExtra("add",add);
        i.putExtra("sub",sub);
        i.putExtra("multi",multi);
        i.putExtra("divi",divi);
        setResult(RESULT_OK,i);
        super.finish();


    }

}