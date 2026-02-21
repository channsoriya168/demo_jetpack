package com.soriya.demo.ui.Components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MoreComposable(){
    Text(
        text = "More Composable",
        fontSize = 30.sp,
        color = Color.Blue
    )
    SwitchComposable()
    TextFieldComposable()
    RadiButtonComposable()
    CircularProgressIndicatorComposable()
    SurFaceComposable()
}

@Composable
fun TextFieldComposable(){
    var text by remember { mutableStateOf(TextFieldValue()) }
    Text(
        text = "TextFieldComposable",
        fontSize = 32.sp,
        color = Color.Blue,
        textDecoration = TextDecoration.Underline
    )
    TextField(
        value = text,
        onValueChange = {
        newValue->text = newValue
        }
    )
}

@Composable
fun SwitchComposable(){
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Switch(
            checked = isChecked,
            onCheckedChange = {isChecked = it}
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = if (isChecked) "Switch is ON" else "Switch is OFF"
        )
    }
}

@Composable
fun RadiButtonComposable(){
    var selectedOption by remember { mutableStateOf("Option 1") }
Text(
    text = "Radio Button ",
    fontSize = 32.sp
)
    RadioButtonRow(
        text = "Option 1",
        selected = selectedOption == "Option 1",
        onClick = {selectedOption = "Option 1"}
    )
    RadioButtonRow(
        text = "Option 1",
        selected = selectedOption == "Option 2",
        onClick = {selectedOption = "Option 2"}
    )
    RadioButton(
        selected = selectedOption == "Option 3",
        onClick = {selectedOption = "Option 3"},
    )


}

@Composable
fun RadioButtonRow(
    text: String,
    selected: Boolean,
    onClick: ()-> Unit
){
  Row(
      verticalAlignment = Alignment.CenterVertically
  ) {
      RadioButton(
          selected = selected,
          onClick = onClick
      )
      Text(
          text = text
      )
  }
}

@Composable
fun CircularProgressIndicatorComposable(){
    CircularProgressIndicator()
}

/**
 * surface
 * Hold one child at a time
 * provide many style treatment its children
 */
@Composable
fun SurFaceComposable(){

}
@Preview(showSystemUi = true)
@Composable
fun PreviewMoreComposable(){
    MoreComposable()
}