package com.example.jetpackcomposeinstagramclone.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeinstagramclone.BottomNavigationScreens
import com.example.jetpackcomposeinstagramclone.R
import com.example.jetpackcomposeinstagramclone.dashboard.submodule.HomeScreen
import com.example.jetpackcomposeinstagramclone.dashboard.submodule.ProfileScreen
import com.example.jetpackcomposeinstagramclone.ui.theme.Gray500
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
    Box(modifier = Modifier.wrapContentSize()) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}

@Composable
private fun currentRoute(modifier: Modifier = Modifier, navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}