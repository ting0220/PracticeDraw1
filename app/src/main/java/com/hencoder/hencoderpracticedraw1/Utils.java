package com.hencoder.hencoderpracticedraw1;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @author zhaoting
 * @date 2018/10/24
 * @use
 */
public class Utils {
    /**
     *
     * @param dp
     * @return
     */
    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
