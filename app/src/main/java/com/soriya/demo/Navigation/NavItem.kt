package com.soriya.demo.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings

sealed class NavItem {
    object Home : Item(NavRoute.Home.path, "Home", Icons.Default.Home)
    object Setting : Item(NavRoute.Setting.path, "Setting", Icons.Default.Settings)
}
