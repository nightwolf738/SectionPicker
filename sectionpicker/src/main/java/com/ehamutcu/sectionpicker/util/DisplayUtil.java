package com.ehamutcu.sectionpicker.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by EgemenH on 02.06.2017.
 */

public class DisplayUtil {

    public static int spToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
}
