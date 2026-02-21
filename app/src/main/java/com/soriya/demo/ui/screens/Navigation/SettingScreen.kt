package com.soriya.demo.ui.screens.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SettingScreen(
    navigateToHome: ()-> Unit
){
    Column() {

        Text(
            text = "This is Setting screen"
        )
        ElevatedButton(
            onClick = navigateToHome
        ) {
            Text(
                text = "Goto home"
            )
        }
    }
}