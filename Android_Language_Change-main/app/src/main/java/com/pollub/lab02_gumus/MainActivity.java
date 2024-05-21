package com.pollub.change;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.support.v4.app.*;
import android.support.v4.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.pollub.lab02_gumus.LanguageManager;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText et;
    ToggleButton tb;
    Double x;

    EditText et_a, et_b, et_c;
    Button b_go;
    TextView tv_result;
    double a, b, c, d, x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tr=findViewById(R.id.btn_tr);
        Button en=findViewById(R.id.btn_en);
        LanguageManager lang = new LanguageManager(this);

        en.setOnClickListener(view ->{
            lang.updateResource("en");
            recreate();

        });
        tr.setOnClickListener(view ->{
            lang.updateResource("tr");
            recreate();

        });



        et=(EditText) findViewById(R.id.editText);
        b1=(Button) findViewById(R.id.button);
        tb=(ToggleButton) findViewById(R.id.toggleButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter the temperature",Toast.LENGTH_SHORT).show();
                }

                else if(tb.isChecked())
                {
                    x=Double.parseDouble(String.valueOf(et.getText()));
                    Double b=x*9/5+32;
                    String r=String.valueOf(b);
                    Toast.makeText(MainActivity.this,r+"°F",Toast.LENGTH_SHORT).show();
                }

                else
                {
                    x=Double.parseDouble(String.valueOf(et.getText()));
                    Double b=x-32;
                    Double c=b*5/9;
                    String r=String.valueOf(c);
                    Toast.makeText(MainActivity.this,r+"°C",Toast.LENGTH_SHORT).show();
                }
            }
        });
        et_a =(EditText) findViewById(R.id.et_a);
        et_b =(EditText) findViewById(R.id.et_b);
        et_c =(EditText) findViewById(R.id.et_c);
        b_go = (Button) findViewById(R.id.b_go);
        tv_result =(TextView) findViewById(R.id.tv_result);
        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_a.getText().toString().equals("") && !et_b.getText().toString().equals("")
                        && !et_c.getText().toString().equals("")) {
                    a = Double.parseDouble(et_a.getText().toString());
                    b = Double.parseDouble(et_b.getText().toString());
                    c = Double.parseDouble(et_c.getText().toString());
                    d = Math.pow(b,2) - 4 * a * c;
                    try {
                        if (d == 0) {
                            x = b / (2 * a);
                            tv_result.setText("d = " + d + "\nx = " + x1);
                        } else if (d < 0) {
                            tv_result.setText("No roots");
                        } else if (d > 0) {
                            x1 = (b + Math.sqrt(d)) / (2 * a);
                            x2 = (-b - Math.sqrt(d)) / (2 * a);
                            tv_result.setText("d = " + d + "\nx1 = " + x1 + "\nx2 = " + x2);
                        }
                    }
                    catch (NumberFormatException e)
                    {

                    }

                }
            }
        });


    }
    public void calculateButtonClick(View v) {
        EditText firstNumberEditText = (EditText) findViewById(R.id.firstNumberEditText);
        EditText secondNumberEditText = (EditText) findViewById(R.id.secondNumberEditText);
        int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
        int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
        RadioButton addRadioButton = (RadioButton) findViewById(R.id.addRadioButton);
        RadioButton subtractRadioButton = (RadioButton) findViewById(R.id.subtractRadioButton);
        RadioButton multiplyRadioButton = (RadioButton) findViewById(R.id.multiplyRadioButton);
        RadioButton divideRadioButton = (RadioButton) findViewById(R.id.divideRadioButton);
        int result = 0;
        try {
            if (addRadioButton.isChecked()) {
                result = firstNumber + secondNumber;
            } else if (subtractRadioButton.isChecked()) {
                result = firstNumber - secondNumber;
            } else if (multiplyRadioButton.isChecked()) {
                result = firstNumber * secondNumber;
            } else if (divideRadioButton.isChecked()) {
                result = firstNumber / secondNumber;
            }
        }
        catch (ArithmeticException e) {

        }
        TextView resultTextView= (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText("Result:" +result);
    }







}