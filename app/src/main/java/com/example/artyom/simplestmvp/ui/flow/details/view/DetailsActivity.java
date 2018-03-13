package com.example.artyom.simplestmvp.ui.flow.details.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.artyom.simplestmvp.common.BaseActivity;
import com.example.artyom.simplestmvp.ui.flow.details.contract.DetailsContract;
import com.example.artyom.simplestmvp.ui.flow.details.presenter.DetailsPresenter;

/**
 * Created by artyom on 13/03/2018.
 */

public class DetailsActivity extends BaseActivity implements DetailsContract.View {

    public static final String SOME_KEY = "";

    DetailsPresenter mDetailsPresenter;

    public static Intent getIntent(String someExtra,
                                   String another,
                                   String bla){
        Intent intent = new Intent();
        intent.putExtra(SOME_KEY, someExtra);


        return intent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        mDetailsPresenter = new DetailsPresenter();
        mDetailsPresenter.setView(this);
    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showDialog(String dialogMessage) {

    }

    @Override
    public void showDetails(String funnyDetails) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
