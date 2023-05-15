package com.example.jetpackcomposeinstagramclone.dashboard.submodule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeinstagramclone.R
import com.example.jetpackcomposeinstagramclone.model.HighlightsListHolderData
import com.example.jetpackcomposeinstagramclone.ui.theme.backgroundColor
import com.example.jetpackcomposeinstagramclone.ui.theme.textIconsTint
import com.example.jetpackcomposeinstagramclone.util.HighlightSection

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor())
    ) {
        Column {
            HomeTopBar()
            HighlightSection(
                highlights = listOf(
                    HighlightsListHolderData(painterResource(id = R.drawable.shubhambhama), "", isAddHighlight = true),
                    HighlightsListHolderData(painterResource(id = R.drawable.starthere), ""),
                    HighlightsListHolderData(painterResource(id = R.drawable.family), ""),
                    HighlightsListHolderData(painterResource(id = R.drawable.plant), ""),
                    HighlightsListHolderData(painterResource(id = R.drawable.lifestyle), ""),
                    HighlightsListHolderData(painterResource(id = R.drawable.about), ""),
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                viewHolderModifier = Modifier.padding(4.dp)
            ) {
            }
        }
    }
}

@Composable
fun HomeTopBar(modifier: Modifier = Modifier, notificationCount: Int = 0, isAnyNewNotification: Boolean = false) {
    Row(
        modifier = modifier.padding(top = 8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            painter = painterResource(id = R.drawable.instagram_logo), contentDescription = null,
            modifier = Modifier
                .wrapContentWidth()
                .height(52.dp)
                .padding(8.dp)
                .weight(0.5f),
            tint = textIconsTint(),
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_heart), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp),
                tint = textIconsTint()
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_messenger), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp),
                tint = textIconsTint()
            )
        }
    }
}
