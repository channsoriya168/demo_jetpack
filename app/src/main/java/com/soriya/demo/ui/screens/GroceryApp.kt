import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.soriya.demo.Models.GroceryItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryApp() {

    val groceryMap: Map<String, List<GroceryItems>> = mapOf(
        "Fruit" to listOf(
            GroceryItems(1, "Apple", "Fresh red apple", null),
            GroceryItems(2, "Banana", "Yellow banana", null),
            GroceryItems(3, "Orange", "Juicy orange", null)
        ),
        "Vegetable" to listOf(
            GroceryItems(4, "Carrot", "Organic carrot", null),
            GroceryItems(5, "Cabbage", "Green cabbage", null),
            GroceryItems(6, "Tomato", "Red tomato", null)
        )
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        groceryMap.forEach { (category, itemsList) ->

            // Items in this category
            items(itemsList) { item ->
                Column(modifier = Modifier.padding(vertical = 4.dp)
                ) {
                  ProductCart(item)
                }
            }
        }
    }
}

@Composable
fun ProductCart(
    item: GroceryItems
){
    Card(
        modifier = Modifier.fillMaxWidth()
            .height(250.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = item.title)
            Text(text = item.title)
            Text(text = item.description)
        }
    }
}
