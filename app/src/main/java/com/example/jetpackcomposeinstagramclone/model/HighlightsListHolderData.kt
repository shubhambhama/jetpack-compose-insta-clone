package com.example.jetpackcomposeinstagramclone.model

import androidx.annotation.Keep
import androidx.compose.ui.graphics.painter.Painter

@Keep
data class HighlightsListHolderData(val image: Painter, val name: String, val isAddHighlight: Boolean = false)