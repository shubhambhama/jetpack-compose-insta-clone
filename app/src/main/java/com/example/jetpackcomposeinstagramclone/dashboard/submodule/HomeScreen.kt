package com.example.jetpackcomposeinstagramclone.dashboard.submodule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.example.jetpackcomposeinstagramclone.ui.theme.backgroundColor

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor())
    ) {
        HomeTopBar()
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
            tint = Color.White,
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.weight(1f).padding(end = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_heart), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_messenger), contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp),
                tint = Color.White
            )
        }
    }
}