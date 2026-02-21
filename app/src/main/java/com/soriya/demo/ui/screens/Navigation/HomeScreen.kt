package com.soriya.demo.ui.screens.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    navigateToSetting: ()-> Unit
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "This is Home Screen"
        )
        ElevatedButton(
            onClick = navigateToSetting
        ) {
            Text("Setting Page")
        }
    }
}
