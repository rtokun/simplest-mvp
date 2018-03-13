package com.example.artyom.simplestmvp.ui.flow.details.contract;

import com.example.artyom.simplestmvp.common.BasePresenter;
import com.example.artyom.simplestmvp.data.model.SomeData;

/**
 * Created by artyom on 09/03/2018.
 */

public interface DetailsContract {

    interface View extends BasePresenter.View {

        void showError(String errorMessage);

        void showDialog(String dialogMessage);

        void showDetails(String funnyDetails);

        /* Here you add another methods that view should do*/

    }

    interface Presenter {

    }

}
