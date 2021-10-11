package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun TopBar(
    onSortByChange: (SortBy) -> Unit
) {

    TopAppBar(
        title = { Text("Covid Tracker") },
        actions = {

            TopBarMenu(onSortByChange)
        }
    )
}

@Composable
fun TopBarMenu(onSortByChange: (SortBy) -> Unit,
               modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    val sortOptions = mapOf(
        "Sort by County" to SortBy.COUNTRY,
        "Sort by Population" to SortBy.POPULATION,
        "Sort by Active Cases" to SortBy.ACTIVE_CASES,
        "Sort by Total Death" to SortBy.TOTAL_DEATH,

        )

    //Box(Modifier.wrapContentSize(Alignment.TopEnd)) {
    Box(modifier = modifier) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                Icons.Filled.MoreVert,
                contentDescription = "More..."
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {

            sortOptions.forEach { option ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    onSortByChange(option.value)
                }) {
                    Text(option.key)
                }
            }
        }
    }
}