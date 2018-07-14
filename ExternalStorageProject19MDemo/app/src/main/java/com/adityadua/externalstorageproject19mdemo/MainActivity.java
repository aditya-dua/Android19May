package com.adityadua.externalstorageproject19mdemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText fileET;
    Button writeBtn,fetchBtn;
    TextView fileTV;
    String FILENAME="myExternalFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeBtn = (Button)findViewById(R.id.button);
        fetchBtn = (Button)findViewById(R.id.button2);

        fileTV = (TextView)findViewById(R.id.textView2);

        fileET = (EditText)findViewById(R.id.editText);

        writeBtn.setOnClickListener(this);
        fetchBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.button){
            // write to File

            try {
                File f = new File(Environment.getExternalStorageDirectory()+"/"+FILENAME);


                Toast.makeText(this, "File Path Is:"+Environment.getExternalStorageDirectory()+"/"+FILENAME, Toast.LENGTH_SHORT).show();
                f.createNewFile();

                FileOutputStream fileOutputStream = new FileOutputStream(f);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.append(fileET.getText().toString());
                
                outputStreamWriter.close();
                fileOutputStream.close();

                Toast.makeText(this, "Text saved to the File", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(view.getId() == R.id.button2){
            File f = new File(Environment.getExternalStorageDirectory()+"/"+FILENAME);
            String aRow ="";
            String textFinal = "";
            try{
                FileInputStream fin = new FileInputStream(f);
                InputStreamReader in = new InputStreamReader(fin);
                BufferedReader bReader = new BufferedReader(in);

                while((aRow = bReader.readLine())!= null){

                    textFinal = textFinal+aRow;
                }

                fileTV.setText(textFinal);
                bReader.close();
                in.close();
                fin.close();

                Toast.makeText(this, "File data and shown", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
