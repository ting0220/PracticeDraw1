package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Utils;

public class Practice8DrawArcView extends View {
    private static final int WIDTH = (int) Utils.dp2px(300);
    private static final int HEIGHT = (int) Utils.dp2px(200);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF rectF = new RectF();


    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2, getWidth() / 2 + WIDTH / 2, getHeight() / 2 + HEIGHT / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        canvas.drawArc(rectF, 15, 150, false, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(1));
        canvas.drawArc(rectF, 190, 50, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, 260, 90, true, paint);

    }
}
