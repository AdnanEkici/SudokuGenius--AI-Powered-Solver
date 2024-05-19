package com.aekici.sudokugenius.utilities;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

/**
 * Utility class for handling views, providing methods to set their sizes and margins based on screen percentages.
 */
public class ViewUtils
{
    /**
     * Sets the size of a view based on percentages of the screen width.
     *
     * @param view               The view for which the size will be set.
     * @param widthFractionResId Resource ID representing the fraction defining the width percentage.
     *                           The fraction resource should be defined in the res/values/dimen.xml file.
     *                           It should represent a percentage (e.g., 0.5 for 50%).
     * @param heightFractionResId Resource ID representing the fraction defining the height percentage.
     *                            The fraction resource should be defined in the res/values/dimen.xml file.
     *                            It should represent a percentage (e.g., 0.5 for 50%).
     * @param context            The context to access resources and the display metrics.
     * @throws Resources.NotFoundException if the specified fraction resource IDs do not exist.
     */
        @RequiresApi(api = Build.VERSION_CODES.R)
        public static void setViewSizeBasedOnScreenPercentage(View view, int widthFractionResId, int heightFractionResId, Context context)
        {
            // Get the screen width
            DisplayMetrics displayMetrics = new DisplayMetrics();
            context.getDisplay().getMetrics(displayMetrics);
            int screenWidth = displayMetrics.widthPixels;

            // Get the desired width and height based on percentages defined in dimensions.xml
            float widthPercentage = context.getResources().getFraction(widthFractionResId, 1, 1);
            float heightPercentage = context.getResources().getFraction(heightFractionResId, 1, 1);
            int desiredWidth = (int) (screenWidth * widthPercentage);
            int desiredHeight = (int) (screenWidth * heightPercentage); // assuming you want the height to be based on the width

            // Set the width and height of the View
            view.getLayoutParams().width = desiredWidth;
            view.getLayoutParams().height = desiredHeight;

            // Request layout update
            view.requestLayout();
        }




    /**
     * Sets margins for a given view based on provided fraction resource IDs, representing percentages of the screen dimensions.
     *
     * @param view               The view for which margins will be set. If a target view is provided, margins will be applied to it; otherwise, margins will be applied to the direct parent of this view.
     * @param context            The context used to access resources and the display metrics.
     * @param targetView         Optional parameter specifying the target view to which margins should be applied. If provided, margins will be applied to this view; otherwise, margins will be applied to the direct parent of the given view.
     * @param marginFractionResIds Variable number of resource IDs representing fractions defining the margins. The order of resource IDs should be: top, bottom, left, right. If fewer than four IDs are provided, the missing margins will be set to 0. If more than four IDs are provided, only the first four will be considered. If a resource ID is not provided for a specific margin, that margin will be set to 0. Fraction resources should be defined in the res/values/dimen.xml file. Each fraction should represent a percentage (e.g., 0.1 for 10%).
     * @throws Resources.NotFoundException if a specified fraction resource ID does not exist.
     * @throws IllegalArgumentException  if the provided context is null.
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    public static void setMarginsBasedOnScreenPercentage(View view, Context context, View targetView, int... marginFractionResIds)
    {
        // Get the screen dimensions
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        // Calculate margins based on provided resource IDs
        int[] margins = new int[4];
        for (int i = 0; i < Math.min(marginFractionResIds.length, 4); i++) {
            float marginPercentage = context.getResources().getFraction(marginFractionResIds[i], 1, 1);
            margins[i] = i % 2 == 0 ? (int) (screenWidth * marginPercentage) : (int) (screenHeight * marginPercentage);
        }

        // Set the margins of the View
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) (targetView != null ? targetView : view).getLayoutParams();
        layoutParams.topMargin = margins[0];
        layoutParams.bottomMargin = margins[1];
        layoutParams.leftMargin = margins[2];
        layoutParams.rightMargin = margins[3];

        // Request layout update
        if (targetView != null) {
            targetView.requestLayout();
        } else {
            view.requestLayout();
        }
    }

}


