package com.pollub.lab03_gumusapp32;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    int add,sub,multi,divi;

    EditText et1,et2;
    TextView text1,text2,text3,text4;

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("Main activity");

        et1= findViewById(R.id.numb1);
        et2= findViewById(R.id.numb2);

        send =findViewById(R.id.send_but);

        text1 =findViewById(R.id.add);
        text2 =findViewById(R.id.sub);
        text3 =findViewById(R.id.mul);
        text4 =findViewById(R.id.div);

        add=getIntent().getIntExtra("add",0);
        sub=getIntent().getIntExtra("sub",0);
        multi=getIntent().getIntExtra("multi",0);
        divi=getIntent().getIntExtra("divi",0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstnumber = Integer.parseInt(et1.getText().toString());
                int secondnumber = Integer.parseInt(et2.getText().toString());


                add = firstnumber + secondnumber;
                sub = firstnumber - secondnumber;
                multi=firstnumber*secondnumber;
                divi= firstnumber/secondnumber;

                String add_txt=String.valueOf(add);
                String sub_txt=String.valueOf(sub);
                String multi_txt=String.valueOf(multi);
                String divi_txt=String.valueOf(divi);

                String resulttxt = "add:"+add_txt+" sub:"+sub_txt+" multi:"+multi_txt+" divi:"+divi_txt;



                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("firstnumber", firstnumber);
                i.putExtra("secondnumber", secondnumber);
                i.putExtra("resulttxt",resulttxt);

                startActivityForResult(i, REQUEST_CODE);
            }
        });

    }


    public void onActivityResult(int requestCode,int resultCode, Intent i) {
        super.onActivityResult(requestCode,resultCode,i);
        if (resultCode==RESULT_OK && requestCode== REQUEST_CODE){
            text1.setText(String.valueOf(add));
            text2.setText(String.valueOf(sub));
            text3.setText(String.valueOf(multi));
            text4.setText(String.valueOf(divi));




        }
    }
}