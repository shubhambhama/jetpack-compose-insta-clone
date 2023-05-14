package com.example.jetpackcomposeinstagramclone

import androidx.annotation.StringRes

sealed class BottomNavigationScreens(val route: String, @StringRes val resId: Int, val icon: Int) {
    object Home: BottomNavigationScreens("HomePage", R.string._home, R.drawable.ic_home)
    object Search: BottomNavigationScreens("SearchPage", R.string._search, R.drawable.ic_search)
    object AddPost: BottomNavigationScreens("AddPostPage", R.string._add_post, R.drawable.ic_add_new)
    object Igtv: BottomNavigationScreens("IgtvPage", R.string._igtv, R.drawable.ic_igtv_)
    object Profile: BottomNavigationScreens("ProfilePage", R.string._profile, R.drawable.ic_profile)
}