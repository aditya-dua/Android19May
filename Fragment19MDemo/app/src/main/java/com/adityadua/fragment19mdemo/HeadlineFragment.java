package com.adityadua.fragment19mdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by AdityaDua on 17/06/18.
 */

public class HeadlineFragment extends ListFragment {

    onHeadlineSelectedListener mCallback;

    public interface onHeadlineSelectedListener{

        public void onArticleSelected(int position);

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,News.headline));

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mCallback = (onHeadlineSelectedListener)activity;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        mCallback.onArticleSelected(position);
        getListView().setItemChecked(position,true);

    }
}
