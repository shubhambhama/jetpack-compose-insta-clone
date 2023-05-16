package com.example.jetpackcomposeinstagramclone.model

import androidx.annotation.Keep
import androidx.compose.ui.graphics.painter.Painter

@Keep
data class PostListHolderData(
    val image: Painter,
    val profileImage: Painter,
    val userName: String,
    val headingMetaData: String
)