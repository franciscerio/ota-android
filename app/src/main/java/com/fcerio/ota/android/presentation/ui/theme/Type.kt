package com.fcerio.ota.android.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.fcerio.ota.android.R

val Typography = Typography(
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.ecb_regular)),
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.ecb_medium)),
        fontWeight = FontWeight.W500,
        fontSize = 15.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.ecb_medium)),
        fontWeight = FontWeight.W500,
        fontSize = 18.sp,
        lineHeight = TextUnit(18f, TextUnitType.Unspecified)
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.ecb_medium)),
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = TextUnit(20f, TextUnitType.Unspecified)
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.ecb_medium)),
        fontWeight = FontWeight.W500,
        fontSize = 30.sp,
        lineHeight = TextUnit(20f, TextUnitType.Unspecified)
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)