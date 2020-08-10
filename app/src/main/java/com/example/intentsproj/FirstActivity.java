package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class FirstActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "com.example.intentsproj.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.intentsproj.MESSAGE2";
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //Exercise
        //Creating the LayoutInflater instance
        LayoutInflater li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.custom_toast, (ViewGroup)
                findViewById(R.id.custom_toast_layout));

        //Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }

    public void viewCal(View view) {

        Context context = getApplicationContext(); //The context to use. Usually your Application or Activity object
        CharSequence message = "You just clicked the OK button";//Display string
        int duration = Toast.LENGTH_SHORT; //How long the toast message will lasts
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);

        Intent intent = new Intent(this, SecondActivity.class); //create intent to go to second activity

        EditText editText1 = (EditText) findViewById((R.id.editTv1));
        EditText editText2 = (EditText) findViewById((R.id.editTv2));

        String message1 = editText1.getText().toString();
        String message2 = editText2.getText().toString();    //get input from edit text views
        intent.putExtra(EXTRA_MESSAGE1,message1);
        intent.putExtra(EXTRA_MESSAGE2 ,message2);  //pass the inputs as extras
        startActivity(intent);  //start secondactivity

    }
}