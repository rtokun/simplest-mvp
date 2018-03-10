package com.example.artyom.simplestmvp.ui.flow.main.presenter;

import com.example.artyom.simplestmvp.common.BasePresenter;
import com.example.artyom.simplestmvp.data.database.LocalDatabase;
import com.example.artyom.simplestmvp.data.model.SomeData;
import com.example.artyom.simplestmvp.data.network.SomeNetworkService;
import com.example.artyom.simplestmvp.ui.flow.main.contract.MainContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by artyom on 09/03/2018.
 * <p>
 * Basically this is the class that responsible to separate Activity/Fragment (View) from Data
 * layer (Network services, local database etc.), so all business logic is defined in the interfaces and
 * implemented here.
 */

public class MainPresenter extends BasePresenter<MainContract.View>
        implements MainContract.Presenter {

    private final SomeNetworkService mNetworkService;
    private final LocalDatabase mLocalDatabase;

    public MainPresenter(SomeNetworkService networkService,
                         LocalDatabase localDatabase) {
        this.mNetworkService = networkService;
        this.mLocalDatabase = localDatabase;
    }

    @Override
    public void loadData(boolean forceRefresh) {
        if (forceRefresh) {
            getDataFromServer();
        } else {
            SomeData cachedData = mLocalDatabase.getSomeData();
            if (cachedData != null) {
                mView.showSomeData(cachedData);
            } else {
                getDataFromServer();
            }
        }
    }

    private void getDataFromServer() {
        mNetworkService.getSomeDataFromRemoteService()
                .enqueue(new Callback<SomeData>() {

                    @Override
                    public void onResponse(Call<SomeData> call, Response<SomeData> response) {
                        if (mView != null) {
                            SomeData dataFromServer = response.body();
                            mLocalDatabase.saveSomeData(dataFromServer);
                            mView.showSomeData(dataFromServer);
                        }
                    }

                    @Override
                    public void onFailure(Call<SomeData> call, Throwable t) {
                        if (mView != null) {
                            mView.showError(t.getMessage());
                        }
                    }
                });
    }
}
