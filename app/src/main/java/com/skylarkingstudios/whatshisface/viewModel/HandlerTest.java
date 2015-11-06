package com.skylarkingstudios.whatshisface.viewModel;

import android.util.Log;
import android.view.View;

import com.orhanobut.logger.Logger;


public class HandlerTest {

    public HandlerTest() {
        Logger.init();
    }
    public void onClickAdd(View view) {
        Logger.e("Add pressed, bound to HandlerTest");
    }
    public void onClickSearch(View view) {
        Logger.e("Search pressed, bound to HandlerTest");
    }
}
