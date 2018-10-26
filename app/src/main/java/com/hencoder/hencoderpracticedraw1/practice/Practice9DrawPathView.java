package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Utils;

public class Practice9DrawPathView extends View {
    private static final int RADIUS = (int) Utils.dp2px(20);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path path = new Path();

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        path.addArc(getWidth() / 2 - RADIUS * 2, getHeight() / 2 - RADIUS, getWidth() / 2, getHeight() / 2 + RADIUS, 135, 225);
        path.arcTo(getWidth() / 2, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS * 2, getHeight() / 2 + RADIUS, 180, 225,false);
        path.lineTo(getWidth() / 2, (float) (getHeight() / 2 + RADIUS * 2.5));

        canvas.drawPath(path, paint);

    }
}
