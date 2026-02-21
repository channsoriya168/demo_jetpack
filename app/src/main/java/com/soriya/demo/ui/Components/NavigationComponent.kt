package com.soriya.demo.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class Product(
    val title: String,
    val description: String,
    val image: String? =null,
    val price: Double
)
val productList: List<Product> = listOf(
    Product(
        title = "iPhone 15",
        description = "Apple smartphone with A16 chip and great camera.",
        image = "https://example.com/iphone15.jpg",
        price = 999.99
    ),
    Product(
        title = "Samsung Galaxy S24",
        description = "Powerful Android phone with excellent display.",
        image = "https://example.com/galaxy_s24.jpg",
        price = 899.99
    ),
    Product(
        title = "MacBook Air M3",
        description = "Lightweight laptop with incredible battery life.",
        image = "https://example.com/macbook_air.jpg",
        price = 1299.00
    ),
    Product(
        title = "Sony WH-1000XM5",
        description = "Industry-leading noise cancelling headphones.",
        image = "https://example.com/sony_headphones.jpg",
        price = 349.99
    ),
    Product(
        title = "Apple Watch Series 9",
        description = "Smartwatch with fitness tracking and notifications.",
        image = "https://example.com/apple_watch.jpg",
        price = 399.99
    )
)
@Composable
fun NavigationComponent(){

    /**
     * NavController = Driver
     * Automatic Back Button Handling
     *
     * Without NavController:
     *
     * You must manually track screen history 😵
     *
     * With NavController:
     *
     * Android back button just works.
     */
    val navController = rememberNavController() //it return navHostController
    /**
     * NavHost = map of app
     * example
     * home page can goto to profile product detail page and others
     */
    NavHost(
        navController = navController, //This is navController but it navHostController
        startDestination = "home"
    ){
        composable("home"){HomePage(navController = navController)}
        composable("profile"){ProfilePage(navController = navController)}
        composable("detail/{id}"){ backStackEntry->
            val id = backStackEntry.arguments
                ?.getString("id")   // get the value
                ?.toInt() ?: 0
            ProductDetail(id = id, navController = navController)
        }

    }
}

@Composable
fun HomePage(navController: NavController){
    Column() {
        Text(
            text = "This is Home page"
        )
        ElevatedButton(
            onClick = {
                  navController.navigate("profile")
            }
            ) {
            Text(
                text = "Go to Profile page"
            )
        }
        LazyColumn(
//                    contentPadding = PaddingValues(18.dp)
        ) {
           itemsIndexed(productList){index,product->
               Card(
                   modifier = Modifier
                       .fillMaxWidth()
                       .height(350.dp)
                       .padding(bottom = 10.dp)
                       .clickable {
                           navController.navigate("detail/$index")
                       }
               ) {
                   Column(
                       modifier = Modifier
                           .padding(15.dp)
                           .fillMaxSize(),
                       verticalArrangement = Arrangement.SpaceBetween
                   ) {
                       Box(
                           modifier = Modifier
                               .fillMaxWidth()
                               .height(250.dp)
                               .background(Color.Red)
                       ) { }
                       Text(
                           text = product.title
                       )
                       Text(
                           text = product.description
                       )
                   }
               }
           }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetail(
    id: Int,
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Product Detail") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->

        Text(
            text = "Product ID: $id",
            modifier = Modifier.padding(padding)
        )
    }
}


@Composable
fun ProfilePage(navController: NavController){
Column() {
    Text(
        text = "This profile page "

    )
    ElevatedButton(
        onClick = {
         navController.navigate("home")
        }
    ) {
        Text(
            text = "Go To home page"
        )
    }
}
}

@Preview(showSystemUi = true)
@Composable
fun NavigationComponentPreview(){
    NavigationComponent()
}