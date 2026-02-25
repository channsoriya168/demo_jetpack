package com.soriya.demo.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonComposable() {
    Scaffold(
     topBar = {
         TopAppBar(
             colors = TopAppBarDefaults.topAppBarColors(
                 containerColor = MaterialTheme.colorScheme.primaryContainer,
                 titleContentColor = MaterialTheme.colorScheme.primary,
             ),
             navigationIcon = {
                 IconButton(onClick = {}) {
                     Icon(
                         imageVector = Icons.Sharp.Menu,
                         contentDescription = "Back"
                     )
                 }
             },
             title = {
                 Text("Small Top App Bar")
             },
             actions = {
                 IconButton(
                     onClick = {}
                 ) {
                     Icon(
                         imageVector = Icons.Sharp.Settings,
                         contentDescription = "Setting"
                     )
                 }
             }

         )
     },
    ) { paddingValues -> // Scaffold passes padding for TopAppBar
        Column(
            modifier = Modifier.padding(paddingValues) // important to avoid overlap
        ) {
            Box(
                modifier = Modifier
                    .padding(8.dp)              // margin
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .size(100.dp)               // width & height
                    .background(Color.Black)     // background
                    .padding(16.dp)             //padding
            ) {
                Column(){

                }
            }

            TonalButtonComponent()
//            badge component
            BadgeComponent()
//            button sheet component
        }
    }
}

//tonal button
@Composable
fun TonalButtonComponent(){
    FilledTonalButton(
        onClick = {},
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        ),
    ) {
        Text("Tonal Button")
    }
}

//badger
@Composable
fun BadgeComponent(){
    var itemCount by remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("$itemCount")
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart",
                modifier = Modifier.size(32.dp)
            )
        }
        Button(
            onClick = {
                itemCount++
            }
        ) {
            Text("Add item")
        }
    }
}

//buttom
@Preview(showSystemUi = true)
@Composable
fun ButtonComposablePreview() {
    MaterialTheme { // parentheses optional
        ButtonComposable()
    }
}
