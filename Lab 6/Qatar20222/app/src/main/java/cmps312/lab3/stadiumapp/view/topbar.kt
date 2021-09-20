package cmps312.lab3.stadiumapp.view

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import cmps312.lab3.stadiumapp.model.Stadium

enum class SortBy{SEATING_CAPACITY, STADIUM_NAME,CITY_NAME}
@Composable
fun TopBar(serachText:String,onValueChange:(String) ->Unit,stadiumtype:String,onstadiumTypeChange:(String)->Unit,
onSortchange: (SortBy) -> Unit)
{



    val type = listOf("All",
        "To be built",
        "Major renovation")
TopAppBar(title = { Text(text = "")}, actions = {

SearchBox(searchText = serachText, onValueChange =onValueChange )
    Dropdown(options = type, selctedOption =stadiumtype , onSelectionchage = onstadiumTypeChange)
    Sort(onSortchange )
})

}

@Composable
fun Sort(onSortchange: (SortBy) -> Unit){
var expanded by remember {
mutableStateOf(false)
}

    val sortoptions = mapOf("sort by seating capacity" to SortBy.SEATING_CAPACITY,

                            "sort by stadium name" to SortBy.STADIUM_NAME,
                            "sort by city name " to SortBy.CITY_NAME
        )
    
    IconButton(onClick = { expanded= true }) {
        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "")


    }

    DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false }) {
        sortoptions.forEach { option -> DropdownMenuItem(onClick =

        { expanded=false
           onSortchange(option.value)


        }

        ) {
            Text( option.key)

        } }

    }
}