package com.example.artyom.simplestmvp.ui.flow.main.contract;

import com.example.artyom.simplestmvp.common.BasePresenter;
import com.example.artyom.simplestmvp.data.model.SomeData;

/**
 * Created by artyom on 09/03/2018.
 */

public interface MainContract {

    interface View extends BasePresenter.View {

        void showError(String errorMessage);

        void showDialog(String dialogMessage);

        void showSomeData(SomeData someData);

        /* Here you add another methods that view should do*/

    }

    interface Presenter {

        void loadData(boolean forceRefresh);
    }

}
