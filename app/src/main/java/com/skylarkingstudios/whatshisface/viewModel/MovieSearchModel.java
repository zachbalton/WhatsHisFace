package com.skylarkingstudios.whatshisface.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.skylarkingstudios.whatshisface.data.DataManager;


public class MovieSearchModel extends BaseObservable {

    private DataManager dataManager;
    private String titleQuery;

    public MovieSearchModel(String titleQuery) {
        Logger.init();
        dataManager = new DataManager();
        this.titleQuery = titleQuery;
    }

    @Bindable
    public String getTitleQuery() {
        return this.titleQuery;
    }

    public void setTitleQuery(String titleQuery) {
        this.titleQuery = titleQuery;
        notifyPropertyChanged(com.skylarkingstudios.whatshisface.BR.titleQuery);
    }


    // Use Event Binding
    public void onClickSearch(View view) {
        Logger.e("Clicked Search");
    }

    public void onClickAdd(View view) {
        Logger.e("Clicked Add");
    }





}
