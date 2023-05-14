package com.example.jetpackcomposeinstagramclone.dashboard.submodule

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagramclone.R
import com.example.jetpackcomposeinstagramclone.model.ImageWithText

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "shubhambhama", modifier = Modifier.padding(top = 16.dp))
        Spacer(modifier = Modifier.height(12.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(8.dp))
        ProfileDescription(
            displayName = "Shubham Bhama",
            description = "• Founder of \uD835\uDE82\uD835\uDE91\uD835\uDE9E\uD835\uDE8B\uD835\uDE91 \uD835\uDE7C\uD835\uDE92\uD835\uDE95\uD835\uDE8A\uD835\uDE97\n" +
                    "• Engineer at Paytm \uD83D\uDC68\u200D\uD83D\uDCBB • Professional Trader \uD83E\uDDAC\n" +
                    "• The Developer of HPCL Projects\n" +
                    "• My everything, my wife @snehabhama ❤️",
            url = "https://medium.com/@shubhambhama", followedBy = listOf("snehabhama", "prernabhama"), otherCount = 17
        )
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                ImageWithText(painterResource(id = R.drawable.youtube), "YouTube"),
                ImageWithText(painterResource(id = R.drawable.qa), "Q&A"),
                ImageWithText(painterResource(id = R.drawable.discord), "Discord"),
                ImageWithText(painterResource(id = R.drawable.telegram), "Telegram"),
                ImageWithText(painterResource(id = R.drawable.qa), "Other"),
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        PostTabView(imageWithText = listOf(
                ImageWithText(painterResource(id = R.drawable.ic_grid), "Post"),
                ImageWithText(painterResource(id = R.drawable.ic_reels), "Reels"),
                ImageWithText(painterResource(id = R.drawable.ic_igtv_), "IGTV"),
                ImageWithText(painterResource(id = R.drawable.profile), "Profile"),
            )
        ) {
            selectedTabIndex = it
        }
        when(selectedTabIndex) {
            0 -> PostSection(posts = listOf(
                painterResource(id = R.drawable.kmm),
                painterResource(id = R.drawable.intermediate_dev),
                painterResource(id = R.drawable.master_logical_thinking),
                painterResource(id = R.drawable.bad_habits),
                painterResource(id = R.drawable.multiple_languages),
                painterResource(id = R.drawable.learn_coding_fast),
            ),
            modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
    Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier.fillMaxWidth()
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black, modifier = Modifier.size(24.dp))
        Text(text = name, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Icon(painter = painterResource(id = R.drawable.ic_bell), contentDescription = "Back", tint = Color.Black, modifier = Modifier.size(24.dp))
        Icon(painter = painterResource(id = R.drawable.ic_dotmenu), contentDescription = "Back", tint = Color.Black, modifier = Modifier.size(20.dp))
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                    image = painterResource(id = R.drawable.shubhambhama), modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
    }
}

@Composable
fun RoundImage(image: Painter, modifier: Modifier = Modifier) {
    Image(
            painter = image, contentDescription = null,
            modifier = modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
                .padding(3.dp)
                .clip(CircleShape)
    )

}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround, modifier = modifier) {
        ProfileStat(numberText = "42", text = "Posts")
        ProfileStat(numberText = "998", text = "Followers")
        ProfileStat(numberText = "71", text = "Following")
    }
}

@Composable
fun ProfileStat(numberText: String, text: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(displayName: String, description: String, url: String, followedBy: List<String>, otherCount: Int) {
    val letterSpacing = 0.sp
    val lineHeight = 20.sp
    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
    ) {
        Text(text = displayName, fontWeight = FontWeight.Bold, letterSpacing = letterSpacing, lineHeight = lineHeight)
        Text(text = description, letterSpacing = letterSpacing, lineHeight = lineHeight, fontSize = 14.sp, fontWeight = FontWeight.W500)
        Text(text = url, color = Color(0xFF3D3D91), letterSpacing = letterSpacing, lineHeight = lineHeight, fontSize = 15.sp)
        if (followedBy.isNotEmpty()) {
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)
                append("Followed by ")
                followedBy.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if (index < followedBy.size - 1) append(", ")
                }
                if (otherCount > 2) {
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            }, letterSpacing = letterSpacing, lineHeight = lineHeight, fontSize = 15.sp)
        }
    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 95.dp
    val height = 36.dp
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {
        ActionButton(
            text = "Following", icon = Icons.Default.KeyboardArrowDown, modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown, modifier = Modifier
                .size(height)
        )
    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String? = null, icon: ImageVector? = null) {
    Row(
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .border(
                width = 1.dp, color = Color.LightGray,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(6.dp)
    ) {
        text?.let { Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp) }
        icon?.let { Icon(imageVector = icon, contentDescription = null, tint = Color.Black) }
    }
}

@Composable
fun HighlightSection(modifier: Modifier = Modifier, highlights: List<ImageWithText>) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(image = highlights[it].image, modifier = Modifier.size(70.dp))
                Text(text = highlights[it].name, overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun PostTabView(modifier: Modifier = Modifier, imageWithText: List<ImageWithText>, onTabSelected: (selectedIndex: Int) -> Unit) {
    var selectedTagIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(selectedTabIndex = selectedTagIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black, modifier = modifier) {
        imageWithText.forEachIndexed { index, item ->
            Tab(selected = selectedTagIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTagIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image, contentDescription = item.name,
                    tint = if (selectedTagIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostSection(posts: List<Painter>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = modifier.scale(1.01f)) {
        items(posts.size) {
            Image(
                painter = posts[it], contentDescription = null, contentScale = ContentScale.Crop, modifier = modifier
                    .aspectRatio(1f)
                    .border(width = 1.dp, color = Color.White)
            )
        }
    }
}