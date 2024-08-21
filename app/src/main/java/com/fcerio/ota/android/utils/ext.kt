package com.fcerio.ota.android.utils

import android.content.Context
import android.util.DisplayMetrics

import androidx.compose.ui.graphics.Color

fun Color.Companion.parse(colorString: String): Color =
    Color(color = android.graphics.Color.parseColor(colorString))
