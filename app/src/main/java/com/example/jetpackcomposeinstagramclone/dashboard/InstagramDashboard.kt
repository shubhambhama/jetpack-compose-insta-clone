package com.example.jetpackcomposeinstagramclone.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.jetpackcomposeinstagramclone.dashboard.submodule.HomeScreen
import com.example.jetpackcomposeinstagramclone.dashboard.submodule.ProfileScreen
import com.example.jetpackcomposeinstagramclone.ui.theme.Gray500
import com.example.jetpackcomposeinstagramclone.ui.theme.backgroundColor

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
        NavigationRoute(Modifier.padding(it), navController = navController)
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
                    androidx.compose.material.Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = context.getString(screen.resId),
                        modifier = Modifier.size(22.dp)
                    )
                },
                selected = currentRoute == screen.route,
                alwaysShowLabel = false,
                selectedContentColor = Color.White,
                unselectedContentColor = Gray500,
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