package com.binarapps.android.example.presenters;

import com.binarapps.android.example.contracts.MainContract;

/**
 * Created by Cookie on 24.08.2017.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }


}
