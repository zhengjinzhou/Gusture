package com.zhou.readbook.view.loadding;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;

import com.zhou.readbook.R;

/**
 * Created by zhou on 2018/1/17.
 */

public class CustomDialog extends Dialog{

    public CustomDialog(@NonNull Context context) {
        super(context,0);

    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

   public static CustomDialog getInstance(Activity activity){
       LoadingView v = (LoadingView) View.inflate(activity, R.layout.common_progress_view, null);
       v.setColor(ContextCompat.getColor(activity, R.color.reader_menu_bg_color));
       CustomDialog dialog = new CustomDialog(activity, R.style.loading_dialog);
       dialog.setContentView(v, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                       ViewGroup.LayoutParams.MATCH_PARENT)
       );
       return dialog;
   }
}
