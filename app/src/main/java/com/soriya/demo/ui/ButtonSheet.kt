package com.soriya.demo.ui

import android.R.attr.contentDescription
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonSheet(){
    Scaffold(
      topBar = {
          TopAppBar(
              colors = TopAppBarDefaults.topAppBarColors(
                  containerColor = Color.Red,
                  titleContentColor = Color.White
              ),
              title = {
                  Text("This Test about button Sheet")
              },
              actions = {
                  Row(){
                      IconButton(onClick = {
                      }) {
                          Icon(
                              modifier = Modifier
                                  .size(10.dp),

                              imageVector = Icons.Sharp.Menu,
                              contentDescription = "menu"
                          )
                      }
                  }
              }
          )
      }
    ){
        paddingValues -> Column(
            modifier = Modifier.padding(paddingValues)
        ) {
        Text("Hello");
    }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowButtonSheet(){
//    ModalBottomSheet(
//        onDismissRequest = {
//
//        }
//    )
}

@Preview(showSystemUi = true)
@Composable
fun ButtonSheetPreview(){
    MaterialTheme{
        ButtonSheet()
    }
}