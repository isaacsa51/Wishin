package com.serranoie.wishin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.serranoie.wishin.R

// Set of Material typography styles to start with
val ttFirsNeueFamily = FontFamily(
    Font(R.font.ttfirs_neue_medium, FontWeight.Medium),
    Font(R.font.ttfirs_neue_bold, FontWeight.Bold),
)

val exo2Family = FontFamily(
    Font(R.font.exo2_regular, FontWeight.Normal),
)

val Typography = Typography(
    headlineMedium = TextStyle(
        fontFamily = ttFirsNeueFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = ttFirsNeueFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = exo2Family,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = exo2Family,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = exo2Family,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
)
