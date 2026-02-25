package com.soriya.demo.ui.Components

import android.R.attr.data
import android.util.Log.d
import android.util.Log.i
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Carousel have 4
 *
 *
 */

@Composable
fun CarouselComposable(){
   Column(
       modifier = Modifier.fillMaxSize()
           .padding(vertical = 30.dp, horizontal = 20.dp)
           .verticalScroll(rememberScrollState())
   ) {
       CarouselExample_MultiBrowse()
       Text(
           text = ""
       )
       CarouselExample_UnContain()
   }

}

//multi browsing
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselExample_MultiBrowse(){
    data class CarouselItem(
        val id: Int,
        val title: String
    )
    val items = remember {
        listOf(
            CarouselItem(1,"Carousel 1"),
            CarouselItem(2,"Carousel 2"),
            CarouselItem(3,"Carousel 3"),
        )
    }
    Column(
    ) {
        Text(
            text = "Multi-browse",
        )
        HorizontalMultiBrowseCarousel(
            state = rememberCarouselState() { items.count() },
            preferredItemWidth = 300.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {i ->
            val item = items[i]
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Red
                    )
            ) {
                Text(
                    text = item.title
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselExample_UnContain(){
    data class CarouselItem1(
        val id: Int,
        val title: String
    )
    val items = remember {
        listOf(
            CarouselItem1(1,"Carousel 1"),
            CarouselItem1(2,"Carousel 2"),
            CarouselItem1(3,"Carousel 3"),
        )
    }
    Column(

    ) {
        Text(
            text = "Multi-browse",
        )
        HorizontalUncontainedCarousel(
            state = rememberCarouselState { items.count() },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 16.dp, bottom = 16.dp),
            itemWidth = 150.dp,
            itemSpacing = 8.dp,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) { i  ->
            val item = items[i]
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Red
                    )
            ) {
                Text(
                    text = item.title
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCarouselComposable(){
    CarouselComposable()
}