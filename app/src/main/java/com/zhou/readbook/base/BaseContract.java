package com.zhou.readbook.base;

/**
 * Created by zhou on 2018/1/17.
 */

public class BaseContract {
    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView {

        void showError();

        void complete();

    }
}
