package com.adityadua.filestoragedemo19m;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText fileET;
    Button readBtn,writeBtn;
    TextView fileText;
    String fileName = "file1.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileET = (EditText)findViewById(R.id.editText);

        readBtn = (Button)findViewById(R.id.button2);
        writeBtn = (Button)findViewById(R.id.button);

        fileText = (TextView)findViewById(R.id.textView2);

        readBtn.setOnClickListener(this);
        writeBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(view.getId()== R.id.button){

            try {
                FileOutputStream fileOutputStream = openFileOutput(fileName,MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(fileET.getText().toString());

                outputStreamWriter.close();
                Toast.makeText(this, "File Saved Successfully", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(view.getId() == R.id.button2){

            try {
                FileInputStream fileinputStream = openFileInput(fileName);
                InputStreamReader inputReader = new InputStreamReader(fileinputStream);

                char [] inputText = new char[100];
                String finalFileText = "";
                int charCount ;

                // 535 chars
                while((charCount = inputReader.read(inputText))>0){
                    finalFileText = finalFileText+String.copyValueOf(inputText);
                }

                inputReader.close();
                fileText.setText(finalFileText);

                Toast.makeText(this, "File has been read Successfully !", Toast.LENGTH_SHORT).show();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    }
}
