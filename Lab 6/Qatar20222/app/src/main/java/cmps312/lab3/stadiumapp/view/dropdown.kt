package cmps312.lab3.stadiumapp.view

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Modifier

@Composable
fun Dropdown(options:List<String>, selctedOption:String, onSelectionchage:(String)->Unit,modifier: Modifier = Modifier){
var expanded by remember {
    mutableStateOf(false)

}

IconButton(onClick = { expanded = !expanded }) {
        Row{
        Text(selctedOption)
        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
    }
}
DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }) {
options.forEach { option -> DropdownMenuItem(onClick =

{ expanded=false
    onSelectionchage(option)


}

) {
    Text(text = option)
    
} }
    
}

}
