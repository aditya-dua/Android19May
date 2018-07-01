package com.adityadua.sqlitedbexample;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.adityadua.sqlitedbexample.database.DBHelper;
import com.adityadua.sqlitedbexample.model.BookData;
import com.adityadua.sqlitedbexample.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String [] book_name = {
            "The pursuit Of Happyness",
            "Let us C",
            "Head First Java",
            "Gitanjali",
            "My Experiments With Truth"
    };

    String [] author_name = {
            "Chris Gardner",
            "Yeshwant Kanetkar",
            "Kathy Seirra",
            "Rabindra Nath Tagore",
            "M.K. Gandhi"
    };

    String [] book_id = {
            "123456",
            "345698",
            "987678",
            "656124",
            "863514"
    };

    DBHelper dbHelper;
    List<BookData> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = DBHelper.getInstance(this);

        // is data  present in this DB
        int count = dbHelper.getFullContent(Constants.BOOK_TABLE,null);

        if(count == 0){
            insertDataInDB();

            Toast.makeText(this, "Data Inserted Successfull", Toast.LENGTH_SHORT).show();
        }

        dataList = dbHelper.getAllBooks();

        List<String> listTitle = new ArrayList<>();

        for (int i=0;i<dataList.size();i++){
            listTitle.add(dataList.get(i).getBookName());
        }

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listTitle);
        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(myAdapter);


    }

    private void insertDataInDB(){
        ContentValues cv;
        for(int i = 0;i<book_name.length;i++) {
            cv = new ContentValues();
            cv.put(Constants.BOOK_NAME, book_name[i]);
            cv.put(Constants.BOOK_AUTHOR, author_name[i]);
            cv.put(Constants.BOOK_ID, book_id[i]);

            dbHelper.insertContentValues(Constants.BOOK_TABLE,cv);
            
        }


    }
}
