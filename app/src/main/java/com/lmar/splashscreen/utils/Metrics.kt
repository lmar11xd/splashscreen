package com.lmar.splashscreen.utils

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import android.view.WindowMetrics
import com.lmar.splashscreen.models.Screen

class Metrics {
    fun getScreenInfo(context: Context): Screen {
        var displayMetrics = context.resources.displayMetrics
        var screen = Screen(displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density)
        return  screen
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun convertPixelsToDp(px: Float, context: Context): Float {
        return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun getScreenSizeDP(context: Context) {
        var displayMetrics = context.resources.displayMetrics
        var dpHeight = displayMetrics.heightPixels / displayMetrics.density
        var dpWidth = displayMetrics.widthPixels / displayMetrics.density
        Log.d("Screen DP", "w: $dpWidth h: $dpHeight")
    }
}