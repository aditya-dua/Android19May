package com.adityadua.gcpvisionbarcodescannerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button barcodeBtn;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        barcodeBtn = (Button)findViewById(R.id.button);
        tvResult = (TextView)findViewById(R.id.textView2);
        barcodeBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(MainActivity.this,BarcodeScannerActivity.class);
        startActivityForResult(i,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 100){
            if(resultCode == CommonStatusCodes.SUCCESS){
                if(data !=null){

                    Barcode barcode = data.getParcelableExtra("barcode");
                    tvResult.setText("Barcode Read is :"+barcode.displayValue);

                }else{
                    tvResult.setText("Barcode Read is : NONE");

                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}
