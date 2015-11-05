package com.skylarkingstudios.whatshisface.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skylarkingstudios.whatshisface.R;

public class MovieListFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_movie_list, container, false);

        return fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


}
