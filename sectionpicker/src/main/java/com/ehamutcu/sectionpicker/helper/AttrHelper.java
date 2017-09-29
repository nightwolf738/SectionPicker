package com.ehamutcu.sectionpicker.helper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.ehamutcu.sectionpicker.util.DisplayUtil;

/**
 * Created by EgemenH on 02.06.2017.
 */

public class AttrHelper {

    /**
     * Gets the textSize attribute's value from the given attribute set
     *
     * @param context      a context
     * @param attrs        attribute set of a view (e.g {@link com.ehamutcu.sectionpicker.SectionPicker})
     * @param defStyleAttr (e.g R.styleable.SectionPicker)
     * @param sizeIndex    font index of the view (e.g R.styleable.SectionPicker_textSize)
     * @return the given integer pixel value of textSize
     */
    public static int getFontSize(Context context, AttributeSet attrs, int defStyleAttr[], int sizeIndex) {
        TypedArray typedArray = context.obtainStyledAttributes(
                attrs,
                defStyleAttr,
                0,
                0);

        try {
            return typedArray.getDimensionPixelSize(sizeIndex, DisplayUtil.spToPx(10, context));
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * Gets the textColor attribute's value from the given attribute set
     *
     * @param context      a context
     * @param attrs        attribute set of a view (e.g {@link com.ehamutcu.sectionpicker.SectionPicker})
     * @param defStyleAttr (e.g R.styleable.SectionPicker)
     * @param colorIndex   font index of the view (e.g R.styleable.SectionPicker_textColor)
     * @return the given integer ColorStateList value of textColor
     */
    public static ColorStateList getFontColor(Context context, AttributeSet attrs, int defStyleAttr[], int colorIndex) {
        TypedArray typedArray = context.obtainStyledAttributes(
                attrs,
                defStyleAttr,
                0,
                0);

        try {
            return typedArray.getColorStateList(colorIndex);
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * Gets the textSize attribute's value from the given attribute set
     *
     * @param context      a context
     * @param attrs        attribute set of a view (e.g {@link com.ehamutcu.sectionpicker.SectionPicker})
     * @param defStyleAttr (e.g R.styleable.SectionPicker)
     * @param styleIndex   style index of the view (e.g R.styleable.SectionPicker_textStyle)
     * @return one of {@link Typeface#NORMAL}, {@link Typeface#BOLD}, and {@link Typeface#ITALIC}
     */
    public static int getFontStyle(Context context, AttributeSet attrs, int defStyleAttr[], int styleIndex) {
        TypedArray typedArray = context.obtainStyledAttributes(
                attrs,
                defStyleAttr,
                0,
                0);

        try {
            return typedArray.getInt(styleIndex, Typeface.NORMAL);
        } finally {
            typedArray.recycle();
        }
    }

    /**
     * Gets the textColor attribute's value from the given attribute set
     *
     * @param context      a context
     * @param attrs        attribute set of a view {@link com.ehamutcu.sectionpicker.SectionPicker})
     * @param defStyleAttr (e.g R.styleable.SectionPicker)
     * @param colorIndex   font index of the view (e.g R.styleable.SectionPicker_textColor)
     * @return the given boolean value of indicatorEnabled
     */
    public static boolean getIndicatorEnabled(Context context, AttributeSet attrs, int defStyleAttr[], int colorIndex) {
        TypedArray typedArray = context.obtainStyledAttributes(
                attrs,
                defStyleAttr,
                0,
                0);

        try {
            return typedArray.getBoolean(colorIndex, true);
        } finally {
            typedArray.recycle();
        }
    }
}
