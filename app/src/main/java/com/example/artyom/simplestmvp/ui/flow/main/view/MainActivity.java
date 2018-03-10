package com.example.artyom.simplestmvp.ui.flow.main.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.artyom.simplestmvp.Injector;
import com.example.artyom.simplestmvp.R;
import com.example.artyom.simplestmvp.common.BaseActivity;
import com.example.artyom.simplestmvp.data.model.SomeData;
import com.example.artyom.simplestmvp.ui.flow.main.contract.MainContract;
import com.example.artyom.simplestmvp.ui.flow.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity
        implements MainContract.View {

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            mPresenter.loadData(false);
        });

        mPresenter = new MainPresenter(Injector.getInstance().getSomeNetworkService(),
                Injector.getInstance().getLocalDatabase());
        mPresenter.setView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.terminate();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog(String dialogMessage) {
        // Here show dialog with the data
    }

    @Override
    public void showSomeData(SomeData someData) {
        Toast.makeText(this, someData.getSomeName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
