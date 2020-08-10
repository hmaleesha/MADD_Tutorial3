package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        final String message1 = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE1);
        final String message2 = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE2);    //get the extras
        EditText editText = findViewById(R.id.edTxt1);
        editText.setText(message1);     //pass extras to edit text

        EditText editText2 = findViewById(R.id.edTxt2);
        editText2.setText(message2);

        btn1 = (Button)findViewById(R.id.btnmul);
        btn2 = (Button)findViewById(R.id.btnadd);
        btn3 = (Button)findViewById(R.id.btnmin);
        btn4 = (Button)findViewById(R.id.btndiv);

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                int result;
                result = Integer.parseInt(message1) * Integer.parseInt(message2);

                TextView textView = findViewById(R.id.tvResult);
                textView.setText(message1+"*"+message2+"="+result);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                int result;

                result = Integer.parseInt(message1) + Integer.parseInt(message2);

                TextView textView = findViewById(R.id.tvResult);
                textView.setText(message1+"+"+message2+"="+result);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                int result;
                result = Integer.parseInt(message1) - Integer.parseInt(message2);

                TextView textView = findViewById(R.id.tvResult);
                textView.setText(message1+"-"+message2+"="+result);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                double result;
                result = (double)Integer.parseInt(message1) / Integer.parseInt(message2);

                TextView textView = findViewById(R.id.tvResult);
                textView.setText(message1 + "/" + message2 + "=" + result);

            }
        });
    }
}