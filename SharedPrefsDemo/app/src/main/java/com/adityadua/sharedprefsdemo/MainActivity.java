package com.adityadua.sharedprefsdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText uNameET,pwdET;
    Button saveBtn;
    TextView textView;
    SharedPreferences sharedPreferences;

    public static final String MY_PREF_NAME="myPrefs";
    public static final String uNameKey ="userName";
    public static final String uPWDKey ="passWord";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uNameET = (EditText)findViewById(R.id.editText);
        pwdET = (EditText)findViewById(R.id.editText2);

        saveBtn = (Button)findViewById(R.id.button);

        textView = (TextView)findViewById(R.id.textView);

        sharedPreferences = getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(uNameKey)){
            textView.setText(sharedPreferences.getString(uNameKey,""));
            Toast.makeText(this, "Login Already Done Once", Toast.LENGTH_SHORT).show();
            uNameET.setText(sharedPreferences.getString(uNameKey,""));
            uNameET.setEnabled(false);
        }else{
            uNameET.setText("");
            textView.setText("");
            uNameET.setEnabled(true);
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Save Btn Clicked", Toast.LENGTH_SHORT).show();
                String userStr  = uNameET.getText().toString();
                String pwdStr  = pwdET.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(uNameKey,userStr);
                editor.putString(uPWDKey,pwdStr);

                editor.commit();



            }
        });



    }
}
