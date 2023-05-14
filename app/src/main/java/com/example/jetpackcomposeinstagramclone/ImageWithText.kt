package com.example.jetpackcomposeinstagramclone

import androidx.annotation.Keep
import androidx.compose.ui.graphics.painter.Painter

@Keep
data class ImageWithText(val image : Painter, val name: String)