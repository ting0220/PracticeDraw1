package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Utils;

public class Practice6DrawLineView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        paint.setStrokeWidth(Utils.dp2px(10));
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(200, 100, 500, 100, paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(200, 200, 500, 200, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(200, 300, 500, 300, paint);

        canvas.drawLines(new float[]{0, 400, 100, 400,200,400,300,400,400,400,500,400,600,400,700,400,800,400,900,400}, paint);
        canvas.drawLines(new float[]{0, 500, 100, 500,200,500,300,500,400,500,500,500,600,500,700,500,800,500,900,500},2,8, paint);


    }
}
