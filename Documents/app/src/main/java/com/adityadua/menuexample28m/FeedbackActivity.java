package com.adityadua.menuexample28m;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by AdityaDua on 16/06/18.
 */

public class FeedbackActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_main);

        textView = (TextView)findViewById(R.id.textView);

       registerForContextMenu(textView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu Example");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        /**
         * int : Group Id
         * Request Number or if numbrer will be ised.
         * Sequence Of Ordering
         *
         */
        menu.add(0,100,3,"Android Conctext - III - I");
        menu.add(0,100,1,"Android Contect - I");
        menu.add(0,100,2,"CM -2 Demo");
        menu.add(0,100,3,"Android Conctext -IV - III - I");


    }
}
