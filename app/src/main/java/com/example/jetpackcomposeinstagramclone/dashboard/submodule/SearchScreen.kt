package com.example.jetpackcomposeinstagramclone.dashboard.submodule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeinstagramclone.R
import com.example.jetpackcomposeinstagramclone.ui.theme.backgroundColor
import com.example.jetpackcomposeinstagramclone.ui.theme.searchBarBackgroundColor
import com.example.jetpackcomposeinstagramclone.ui.theme.textIconsTint

@Composable
fun SearchScreen() {
    SearchBar(
        modifier = Modifier, hint = "Search"
    )
}


@Composable
fun SearchBar(modifier: Modifier = Modifier, hint: String = "", onSearch: (String) -> Unit = {}) {
    val text = remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    Surface(modifier = modifier.fillMaxSize(), color = backgroundColor()) {
        Column {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .background(searchBarBackgroundColor(), RoundedCornerShape(6.dp)),
                contentAlignment = Alignment.TopStart,
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search), contentDescription = null, modifier = Modifier
                            .size(30.dp)
                            .padding(start = 12.dp)
                            .align(CenterVertically),
                        colorFilter = ColorFilter.tint(textIconsTint()), alignment = Alignment.CenterStart
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    BasicTextField(value = text.value, onValueChange = {
                        text.value = it
                        onSearch(it)
                    }, maxLines = 1, singleLine = true, textStyle = TextStyle(color = textIconsTint()), modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp)
                        .padding(top = 10.dp)
                        .onFocusChanged {
                            isHintDisplayed = !it.isFocused
                        }, cursorBrush = SolidColor(textIconsTint())
                    )
                    if (isHintDisplayed) {
                        Text(text = hint, color = Color.LightGray, modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp))
                    }
                }
            }
        }
    }
}
