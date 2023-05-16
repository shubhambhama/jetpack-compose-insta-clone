package com.example.jetpackcomposeinstagramclone.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagramclone.R
import com.example.jetpackcomposeinstagramclone.model.HighlightsListHolderData
import com.example.jetpackcomposeinstagramclone.ui.theme.Blue300
import com.example.jetpackcomposeinstagramclone.ui.theme.textIconsTint
import kotlin.random.Random

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier, viewHolderModifier: Modifier = Modifier, highlights: List<HighlightsListHolderData>,
    onClickAction: (HighlightsListHolderData) -> Unit
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                modifier = viewHolderModifier.clickable {
                    onClickAction.invoke(highlights[it])
                }
            ) {
                RoundImage(image = highlights[it].image, modifier = Modifier.size(70.dp), isAddHighlight = highlights[it].isAddHighlight)
                if (highlights[it].name.isNotEmpty()) {
                    Text(
                        text = highlights[it].name,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        color = textIconsTint(),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RoundImage(image: Painter, modifier: Modifier = Modifier, isAddHighlight: Boolean = false) {
    Box(modifier = Modifier.wrapContentSize()) {
        Image(
            painter = image, contentDescription = null,
            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
                .padding(2.dp)
                .clip(CircleShape)
        )
        if (isAddHighlight) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add Highlight",
                modifier = Modifier.padding(
                    start = 68.dp / 2 + 62.dp / 4,
                    top = 68.dp / 2 + 62.dp / 4
                ),
                tint = Blue300
            )
        }
    }
}

@Composable
fun rememberRandomColor(): Color {
    val randomColor = remember {
        Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 0.7f
        )
    }
    return randomColor
}

@Composable
fun rememberPainter(color: Color): Painter {
    return remember {
        object : Painter() {
            override val intrinsicSize: Size
                get() = Size.Unspecified

            override fun DrawScope.onDraw() {
                drawCircle(color, radius = size.minDimension / 2)
            }
        }
    }
}