package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Utils;

public class Practice7DrawRoundRectView extends View {
    private static final int WIDTH = (int) Utils.dp2px(300);
    private static final int HEIGHT = (int) Utils.dp2px(200);
    private static final int dx = (int) Utils.dp2px(50);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        canvas.drawRoundRect(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2, getWidth() / 2 + WIDTH / 2, getHeight() / 2 + HEIGHT / 2, dx, dx, paint);
    }
}
