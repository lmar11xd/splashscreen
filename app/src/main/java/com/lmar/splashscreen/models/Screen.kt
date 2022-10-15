package com.lmar.splashscreen.models

import android.util.Log

data class Screen(val width: Int, val height: Int, val density: Float) {
    override fun toString(): String {
        return "w: ${width} - h: ${height} - d: ${density}"
    }
}