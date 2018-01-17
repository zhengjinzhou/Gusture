package com.zhou.readbook.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhou.readbook.view.loadding.CustomDialog;

import butterknife.ButterKnife;

/**
 * Created by zhou on 2018/1/16.
 */

public abstract class BaseFragment extends Fragment {

    private CustomDialog dialog;

    public abstract int getLayoutResId();
    public abstract void init();


    protected Context mContext;
    protected FragmentActivity activity;
    protected LayoutInflater inflater;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View parentView = inflater.inflate(getLayoutResId(), container, false);
        activity = getSupportActivity();
        mContext = activity;
        this.inflater = inflater;
        return parentView;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        init();
    }

    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }

    public CustomDialog getDialog() {
        if (dialog == null) {
            dialog = CustomDialog.getInstance(getActivity());
            dialog.setCancelable(false);
        }
        return dialog;
    }

    public void hideDialog() {
        if (dialog != null)
            dialog.hide();
    }

    public void showDialog() {
        getDialog().show();
    }

    public void dismissDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
