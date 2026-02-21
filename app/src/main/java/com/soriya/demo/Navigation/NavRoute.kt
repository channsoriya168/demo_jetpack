package com.soriya.demo.Navigation

/**
 * A sealed class is a restricted class hierarchy.
 *
 * All subclasses must be defined in the same file.
 */
sealed class NavRoute(val path: String){
    object Home: NavRoute("home")
    object Profile: NavRoute("profile"){
        val id= "id"
        val showDetails = "showDetails"
    }
    object Setting: NavRoute("setting")
}
