package com.adityadua.fragment19mdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by AdityaDua on 17/06/18.
 */

public class ArticleFRagment extends Fragment {

    final static String ARG_POSITION = "position";

    int mCurrentPosition = -1;
    // key value pair : ARG_POSITION & value

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState !=null){
            mCurrentPosition = savedInstanceState.getInt( ARG_POSITION);

        }
        return inflater.inflate(R.layout.news_article,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle b = getArguments();

        if(b !=null){
            updateArticleView(b.getInt(ARG_POSITION));
        }else if(mCurrentPosition == -1){
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position){

        TextView tv = (TextView)getActivity().findViewById(R.id.article);
        tv.setText(News.article[position]);
        mCurrentPosition = position;


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,mCurrentPosition);
    }
}
