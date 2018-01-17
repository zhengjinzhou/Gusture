package com.zhou.readbook.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zhou on 2018/1/17.
 */

public class DrawableCenterButton extends TextView {

    public DrawableCenterButton(Context context) {
        super(context);
    }

    public DrawableCenterButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableCenterButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null){
            Drawable drawable = drawables[0];
            if (drawable != null){
                float textWidth = getPaint().measureText(getText().toString());
                int drawablePadding = getCompoundDrawablePadding();
                int drawableWidth = 0;
                drawableWidth = drawable.getIntrinsicWidth();
                float bodyWidth = textWidth + drawableWidth + drawablePadding;
                canvas.translate((getWidth() - bodyWidth)/11*5,0);
            }
        }
        super.onDraw(canvas);
    }
}
