package com.example.jetpackcomposeinstagramclone.dashboard

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.jetpackcomposeinstagramclone.BottomNavigationScreens
import com.example.jetpackcomposeinstagramclone.R
import com.example.jetpackcomposeinstagramclone.dashboard.submodule.HomeScreen
import com.example.jetpackcomposeinstagramclone.dashboard.submodule.ProfileScreen
import com.example.jetpackcomposeinstagramclone.ui.theme.backgroundColor
import com.example.jetpackcomposeinstagramclone.ui.theme.textIconsTint

@Composable
fun InstagramDashboard() {
    val navController = rememberNavController()
    val bottomNavigationItems = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Search,
        BottomNavigationScreens.AddPost,
        BottomNavigationScreens.Igtv,
        BottomNavigationScreens.Profile,
    )

    Scaffold(bottomBar = { BottomBar(navController = navController, screens = bottomNavigationItems) }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavigationRoute(Modifier.padding(it), navController = navController)
        }
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier, navController: NavHostController, screens: List<BottomNavigationScreens>) {
    val context = LocalContext.current
    BottomNavigation(backgroundColor = backgroundColor()) {
        val currentRoute = currentRoute(navController = navController)
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    val isProfileImage = screen.route == BottomNavigationScreens.Profile.route
                    val imageModifier = if (!isProfileImage) {
                        Modifier.size(22.dp)
                    } else {
                        Modifier
                            .size(22.dp)
                            .border(width = 0.4.dp, color = textIconsTint(), shape = CircleShape)
                            .clip(CircleShape)
                    }
                    Image(
                        painter = painterResource(if (isProfileImage) R.drawable.shubhambhama else screen.icon),
                        contentDescription = context.getString(screen.resId),
                        modifier = imageModifier,
                        colorFilter = if (isProfileImage) null else ColorFilter.tint(textIconsTint()),
                    )
                },
                selected = currentRoute == screen.route,
                alwaysShowLabel = false,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationRoute(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationScreens.Home.route) {
        composable(BottomNavigationScreens.Home.route) {
            HomeScreen()
        }
        composable(BottomNavigationScreens.Search.route) {
            DevelopmentInProgressScreen(text = "Search")
        }
        composable(BottomNavigationScreens.AddPost.route) {
            DevelopmentInProgressScreen(text = "Add Post")
        }
        composable(BottomNavigationScreens.Igtv.route) {
            DevelopmentInProgressScreen(text = "Igtv")
        }
        composable(BottomNavigationScreens.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun DevelopmentInProgressScreen(text: String) {
    val context = LocalContext.current
    Surface(color = backgroundColor(), modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            val imageLoader = ImageLoader.Builder(context)
                .components {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                }.build()
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(data = R.drawable.development_in_progress).apply(block = {
                    size(Size.ORIGINAL)
                }).build(), imageLoader = imageLoader
            )
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )
            Text(text = text, textAlign = TextAlign.Center, fontSize = MaterialTheme.typography.h6.fontSize, color = textIconsTint())
            Text(
                text = context.getString(R.string.development_in_progress),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = textIconsTint(),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
private fun currentRoute(modifier: Modifier = Modifier, navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}