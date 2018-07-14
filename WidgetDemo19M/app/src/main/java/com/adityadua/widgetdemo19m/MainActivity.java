package com.adityadua.widgetdemo19m;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView textView;
    int year,month,day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker);

        textView = (TextView)findViewById(R.id.date_selected_TV);
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
   }

    public void showDateDailog(View v){

        showDialog(101);
        Toast.makeText(this, "Date Dailog Created", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == 100){

            return new DatePickerDialog(this,myDateListener,year,month,day);

        }


        if(id == 101){

            return new TimePickerDialog(this,null,12,12,false);

        }


        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

            textView.setText(i2+"/"+(i1+1)+"/"+i);

        }


    };


}
