package com.example.jetpackcomposeinstagramclone.model

import androidx.annotation.Keep
import androidx.compose.ui.graphics.painter.Painter

@Keep
data class ImageWithText(val image : Painter, val name: String)