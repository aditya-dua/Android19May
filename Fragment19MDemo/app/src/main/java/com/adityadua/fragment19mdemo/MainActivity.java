package com.adityadua.fragment19mdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HeadlineFragment.onHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.activity_main) !=null){
            if(savedInstanceState !=null){
                return;

            }

            HeadlineFragment firstFragment = new HeadlineFragment();
            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.activity_main,firstFragment).commit();
        }
    }

    @Override
    public void onArticleSelected(int position) {

        ArticleFRagment articleFRagment = (ArticleFRagment)getSupportFragmentManager().findFragmentById(R.id.fragment2);

        if(articleFRagment !=null){
            articleFRagment.updateArticleView(position);

        }else{
            ArticleFRagment newFragment = new ArticleFRagment();

            Bundle args = new Bundle();
            args.putInt(ArticleFRagment.ARG_POSITION,position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_main,newFragment);
            transaction.addToBackStack(null);
            transaction.commit();


        }



    }
}
