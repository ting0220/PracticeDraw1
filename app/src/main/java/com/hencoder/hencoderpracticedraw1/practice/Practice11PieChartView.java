package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Utils;

public class Practice11PieChartView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final int ANGLE_GAP = 2;
    private int[] angles = new int[]{10, 10, 58, 110, 120, 40};
    private int[] colors = new int[]{Color.parseColor("#FF0E1D"), Color.parseColor("#9800A7"), Color.parseColor("#8C8C8C"), Color.parseColor("#008975"), Color.parseColor("#0080F9"), Color.parseColor("#FAB400")};
    private String[] texts = new String[]{"Marshmallow", "Froyo", "Gingerbread", "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop"};
    private RectF rectF = new RectF();
    private static final int RADIUS = (int) Utils.dp2px(100);
    private static final int SELECTED_INDEX = 4;
    private static final int LENGTH = (int) Utils.dp2px(10);
    private Rect bounds = new Rect();

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

//        paint.setColor(colors[0]);
//        canvas.drawArc(rectF, 0, angles[0], true, paint);
//        paint.setTextSize(30);
//        paint.setColor(Color.WHITE);
//        canvas.drawText(texts[0], 0, texts[0].length(), (float) Math.cos(Math.toRadians(angles[0] / 2)) * (RADIUS + TEXT_LENGTH) + getWidth() / 2, (float) Math.sin((Math.toRadians(angles[0] / 2))) * RADIUS + getHeight() / 2, paint);
        int currentAngle = 0;
        for (int i = 0; i < angles.length; i++) {
            paint.setColor(colors[i]);
            canvas.save();
            if (i == SELECTED_INDEX) {
                canvas.translate((float) Math.cos(Math.toRadians(currentAngle + angles[i] / 2)) * LENGTH, (float) Math.sin(Math.toRadians(currentAngle + angles[i] / 2)) * LENGTH);
            }
            canvas.drawArc(rectF, currentAngle, angles[i], true, paint);
            canvas.restore();
            paint.setTextSize(30);
            paint.setColor(Color.WHITE);
            boolean isLeft = currentAngle + angles[i] / 2 <= 90 || currentAngle + angles[i] / 2 >= 270;
            if (isLeft) {
                canvas.drawText(texts[i], 0, texts[i].length(), getWidth() / 2 + RADIUS + LENGTH, (float) Math.sin((Math.toRadians(currentAngle + angles[i] / 2))) * RADIUS + getHeight() / 2, paint);
            } else {
                paint.getTextBounds(texts[i], 0, texts[i].length(), bounds);
                canvas.drawText(texts[i], 0, texts[i].length(), getWidth() / 2 - RADIUS - LENGTH - bounds.width(), (float) Math.sin((Math.toRadians(currentAngle + angles[i] / 2))) * RADIUS + getHeight() / 2, paint);
            }
//                canvas.drawLine(getWidth() / 2 - RADIUS - LENGTH, (float) Math.sin((Math.toRadians(currentAngle + angles[i] / 2))) * RADIUS + getHeight() / 2, (float) Math.cos(Math.toRadians(currentAngle + angles[i] / 2)) * (RADIUS + LENGTH)+getWidth()/2,(float) Math.sin((Math.toRadians(currentAngle + angles[i] / 2))) * RADIUS + getHeight() / 2, paint);
            currentAngle += angles[i] + ANGLE_GAP;
        }

    }
}
