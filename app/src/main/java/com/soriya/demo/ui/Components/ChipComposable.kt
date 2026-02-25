package com.soriya.demo.ui.Components

import android.R.attr.category
import android.R.attr.text
import android.provider.CalendarContract
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

@Composable
fun ChipComposable(){
    Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(vertical = 30.dp, horizontal = 20.dp)
    ) {
        Text(
            text = "Chip Composable",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Assist Chip",
            fontSize = 30.sp
        )
        //assist chip
        AssistChipComposable()
        /**
         * Filter chip
         */
        FilterChipComposable()
        InputChipComposable()
    }
}

@Composable
fun AssistChipComposable(){
    data class Category(
        val id : Int,
        val title: String
    )
    val categories = listOf(
        Category(1, "All"),
        Category(2, "Laptop"),
        Category(3, "Computer")
    )
    var selectedCategoryIndex by remember { mutableStateOf(1) }
    LazyRow(
    ) {
        items(categories){
            category->
            //this mean isSelected = true until category.id = selectedCategoryIndex
            val isSelected = category.id == selectedCategoryIndex
            AssistChip(
                modifier = Modifier.padding(5.dp).height(40.dp),
                onClick = {
                    selectedCategoryIndex = category.id
                },
                label = { Text(category.title) },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = if (isSelected) Color.Red else Color.LightGray,
                    labelColor = if (isSelected) Color.White else Color.Black
                )
            )
        }
    }

}

@Composable
fun FilterChipComposable(){
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        label = {
            Text(
                text = "Filter Chip"
            )
        },
        onClick = {
              selected =! selected

            },

        leadingIcon = if (selected){

            {
                Log.d("FILTER","$selected")
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "chek"
                )
            }
        } else {
            null
        }
    )
}
@Composable
fun InputChipComposable (
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        onClick = {

            enabled = !enabled
        },
        label = { Text("text") },
        selected = enabled,
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
    )
}
