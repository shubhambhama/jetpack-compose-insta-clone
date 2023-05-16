package com.example.jetpackcomposeinstagramclone.model

import androidx.annotation.Keep
import androidx.compose.ui.graphics.painter.Painter
import kotlin.random.Random

@Keep
data class PostListHolderData(
    val imageUrl: String = "https://cdn.catboys.com/images/image_${Random.nextInt(1, 100)}.jpg",
    val profileImage: Painter,
    val userName: String = "shubhambhama",
    val headingMetaData: String
)