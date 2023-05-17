package com.example.jetpackcomposeinstagramclone.dashboard.submodule

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.jetpackcomposeinstagramclone.R
import com.example.jetpackcomposeinstagramclone.model.HighlightsListHolderData
import com.example.jetpackcomposeinstagramclone.model.PostListHolderData
import com.example.jetpackcomposeinstagramclone.ui.theme.backgroundColor
import com.example.jetpackcomposeinstagramclone.ui.theme.textIconsTint
import com.example.jetpackcomposeinstagramclone.util.ExpandableText
import com.example.jetpackcomposeinstagramclone.util.HighlightSection
import com.example.jetpackcomposeinstagramclone.util.RoundImage

@Composable
fun HomeScreen() {
    val configuration = LocalConfiguration.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor())
    ) {
        Column {
            HomeTopBar()
            HighlightSection(
                highlights = listOf(
                    HighlightsListHolderData(
                        painterResource(id = R.drawable.shubhambhama),
                        "Your Story",
                        isAddHighlight = true
                    ),
                    HighlightsListHolderData(painterResource(id = R.drawable.starthere), "Start Here"),
                    HighlightsListHolderData(painterResource(id = R.drawable.family), "Family"),
                    HighlightsListHolderData(painterResource(id = R.drawable.plant), "Plant"),
                    HighlightsListHolderData(painterResource(id = R.drawable.lifestyle), "Life Style"),
                    HighlightsListHolderData(painterResource(id = R.drawable.about), "About"),
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp), viewHolderModifier = Modifier.padding(4.dp)
            ) {}
            ListOfPosts(
                modifier = Modifier
                    .fillMaxSize(), sizeOfList = 10, configuration = configuration
            )
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
                painter = painterResource(id = R.drawable.ic_heart), contentDescription = null, modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp), tint = textIconsTint()
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_messenger), contentDescription = null, modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp), tint = textIconsTint()
            )
        }
    }
}

@Composable
fun ListOfPosts(modifier: Modifier = Modifier, sizeOfList: Int = 20, configuration: Configuration) {
    val listOfData = List(sizeOfList) {
        PostListHolderData(
            profileImage = painterResource(id = R.drawable.ic_funny_face),
            headingMetaData = "harry potter • Original audio"
        )
    }
    val calcHeight = configuration.screenHeightDp * 0.6f
    Box(modifier = modifier) {
        LazyColumn {
            items(sizeOfList) {
                PostViewHolder(postListHolderData = listOfData[it], height = calcHeight)
            }
        }
    }
}

@Composable
fun PostViewHolder(modifier: Modifier = Modifier, postListHolderData: PostListHolderData, height: Float) {
    Column {
        PostTopHeading(postListHolderData, Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        PostImage(imageUrl = postListHolderData.imageUrl, height = height)
        Spacer(modifier = Modifier.height(8.dp))
        PostBottomAction()
        Spacer(modifier = Modifier.height(16.dp))
        PostLikeCaptionDetails(userName = postListHolderData.userName)
    }
}

@Composable
fun PostTopHeading(postListHolderData: PostListHolderData, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = CenterVertically) {
        RoundImage(
            image = postListHolderData.profileImage, modifier = Modifier
                .size(36.dp)
                .weight(1f)
                .padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.weight(8f)) {
            Text(
                text = postListHolderData.userName,
                fontSize = 14.sp,
                color = textIconsTint(),
                fontWeight = FontWeight.SemiBold
            )
            if (postListHolderData.headingMetaData.isNotEmpty()) Text(
                text = postListHolderData.headingMetaData,
                fontSize = 12.sp,
                color = textIconsTint()
            )
        }
        Box(
            modifier = Modifier
                .align(CenterVertically)
                .padding(end = 4.dp)
        ) {
            androidx.compose.material3.Icon(
                painter = painterResource(id = R.drawable.ic_dotmenu),
                contentDescription = "Menu",
                tint = textIconsTint(),
                modifier = Modifier.size(14.dp)
            )
        }
    }
}

@Composable
fun PostImage(modifier: Modifier = Modifier, imageUrl: String, height: Float) {
    val context = LocalContext.current
    val imageRequest = ImageRequest.Builder(context)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .data(imageUrl).build()
    val asyncImage = rememberAsyncImagePainter(imageRequest)
    Image(
        painter = asyncImage, contentDescription = null, modifier = modifier
            .fillMaxWidth()
            .height(height.dp)
            .clip(RectangleShape), contentScale = ContentScale.Crop
    )
}

@Composable
fun PostBottomAction(modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Row(verticalAlignment = CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(id = R.drawable.ic_heart), modifier = Modifier
                    .padding(start = 16.dp)
                    .size(28.dp), contentDescription = "Like",
                colorFilter = ColorFilter.tint(textIconsTint())
            )
            Image(
                painter = painterResource(id = R.drawable.ic_comment), modifier = Modifier
                    .padding(start = 16.dp)
                    .size(28.dp), contentDescription = "Comment",
                colorFilter = ColorFilter.tint(textIconsTint())
            )
            Image(
                painter = painterResource(id = R.drawable.ic_send), modifier = Modifier
                    .padding(start = 16.dp)
                    .size(28.dp), contentDescription = "Send",
                colorFilter = ColorFilter.tint(textIconsTint())
            )
        }
        Box(modifier = Modifier.weight(0.1f)) {
            Image(
                painter = painterResource(id = R.drawable.ic_bookmark), modifier = Modifier
                    .padding(end = 8.dp)
                    .size(28.dp), contentDescription = "Bookmark",
                colorFilter = ColorFilter.tint(textIconsTint())
            )
        }
    }
}

@Composable
fun PostLikeCaptionDetails(modifier: Modifier = Modifier, userName: String) {
    val boldStyle = SpanStyle(color = textIconsTint(), fontWeight = FontWeight.Bold)
    Column(modifier = modifier.padding(start = 16.dp)) {
        Text(text = buildAnnotatedString {
            append("Liked by instagram, google and ")
            pushStyle(boldStyle)
            append("others")
            pop()
        }, fontSize = 13.sp, color = textIconsTint())

        ExpandableText(
            text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                    "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " +
                    "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                    "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla " +
                    "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                    "mollit anim id est laborum.", maxLines = 1, userName = userName
        )
    }
}