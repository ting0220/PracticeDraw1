package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Utils;

public class Practice10HistogramView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final int LENGTH = 100;
    private static final int BOTTOM = 750;
    private static final int[] tops = new int[]{745, 735, 738, 600, 550, 500, 650};
    private static final String[] texts = new String[]{"Froyo", "GB", "ICS", "JB", "Kitkat", "L", "M"};

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(Utils.dp2px(1));
        canvas.drawLine(300, 150, 300, 750, paint);
        canvas.drawLine(300, 750, 1200, 750, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        int left = 325;
        for (int i = 0; i < tops.length; i++) {
            canvas.drawRect(left, tops[i], left + LENGTH, BOTTOM, paint);
            left = left + LENGTH + 25;
        }

        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        left = 325;
        for (int i = 0; i < texts.length; i++) {
            canvas.drawText(texts[i], 0, texts[i].length(), left + LENGTH / 2, 780, paint);
            left += LENGTH + 25;
        }

    }
}
