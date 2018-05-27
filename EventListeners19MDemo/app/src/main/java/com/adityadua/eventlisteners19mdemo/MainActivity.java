package com.adityadua.eventlisteners19mdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // When a style is applied to an activity it is called theme

    // Take the object OF Views that you want to display

    EditText userNameET,pwdET;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameET = (EditText)findViewById(R.id.usrNameET);
        pwdET = (EditText)findViewById(R.id.pwdET);

        loginBtn = (Button)findViewById(R.id.signInBTN);

        // Adding a Listener
        // When we have views , there are chances that user will interact with them
        // typing a text
        // onfocuschange
        // onFocus
        // onClick
        // onLongClick
        //onTouch

        // If you want to activate them , you need to first define

        // you will take and set the listener
        // I take a view as Button , TextView

        // I define the action : what should happen when taht event is triggered
        // Ex : If you are talking about the onClick : we will use the onClick Method

        // I first set the Listener ::
        // Type of listener here is :: Annonmynus Inner Class Declaration

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userNameStr = userNameET.getText().toString();

                String pwdStr = pwdET.getText().toString();


                if(userNameStr.equals("aditya") && pwdStr.equals("Aditya")){
                   // Toast.
                    Toast.makeText(MainActivity.this, "Login success !", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Wrong ID / Pwd Combination", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    // another way of using onclick

    public void resetBtnClicked(View v){
        userNameET.setText("");
        pwdET.setText("");

    }
}
