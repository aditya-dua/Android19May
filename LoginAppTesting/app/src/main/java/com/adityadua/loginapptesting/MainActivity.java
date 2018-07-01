package com.adityadua.loginapptesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et1;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView1);
        et1 = (EditText)findViewById(R.id.userNameEditText);
        et2 = (EditText)findViewById(R.id.passwordET);

    }

    public void loginButtonClicked(View v){

        if(et1.getText().toString().equals("aditya") && et2.getText().toString().equals("aditya")) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            tv.setText("Button Clicked");
        }else{
            Toast.makeText(this, "Logiin Failure", Toast.LENGTH_SHORT).show();
        }
        
    }
}
