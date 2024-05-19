package com.aekici.sudokugenius.utilities;
import android.content.Context;
import android.widget.Toast;

/**
 * Utility class for debugging purposes, providing methods to display toast messages and print debug messages to the console.
 */
public class DebugUtils {

    /**
     * Displays a toast message with the specified text for the given duration.
     *
     * @param context  The context in which the toast will be displayed.
     * @param message  The text to be displayed in the toast message.
     * @param duration The duration for which the toast message will be shown. Use {@link Toast#LENGTH_SHORT} or {@link Toast#LENGTH_LONG}.
     */
    public static void showToast(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    /**
     * Displays a short-duration toast message with the specified text.
     *
     * @param context The context in which the toast will be displayed.
     * @param message The text to be displayed in the toast message.
     */
    public static void printScreenShort(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }

    /**
     * Displays a long-duration toast message with the specified text.
     *
     * @param context The context in which the toast will be displayed.
     * @param message The text to be displayed in the toast message.
     */
    public static void printScreenLong(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG);
    }
}
