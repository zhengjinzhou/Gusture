package com.zhou.readbook.view.adapter;

import android.view.View;

/**
 * Created by zhou on 2018/1/17.
 */
public interface EventDelegate {
    void addData(int length);
    void clear();

    void stopLoadMore();
    void pauseLoadMore();
    void resumeLoadMore();

    void setMore(View view, OnLoadMoreListener listener);
    void setNoMore(View view);
    void setErrorMore(View view);
}
