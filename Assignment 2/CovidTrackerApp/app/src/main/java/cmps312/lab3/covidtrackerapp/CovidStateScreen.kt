package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

enum class SortBy { COUNTRY, ACTIVE_CASES, TOTAL_DEATH, POPULATION}
@Composable
fun CovidStatScreen() {
    var searchText by remember { mutableStateOf("") }


    var sortBy by remember {
        mutableStateOf(SortBy.COUNTRY)
    }

    Scaffold(

        topBar ={ TopBar(onSortByChange= {sortBy=it})

        }
    )


    {
        Column {
            searchBoxItem(  searchText = searchText,
                onSearchTextChange = { searchText = it })

            val covidStat =  CovidStatRepository.initCovidStat(LocalContext.current)
            CovidStateList(covidStat,searchText,sortBy)
        }


    }
}
@Composable
fun searchBoxItem(searchText: String, onSearchTextChange: (String)-> Unit)
{
    SearchBox(searchText, onSearchTextChange)

}

@Preview
@Composable
fun ScreenPreview() {
    CovidStatScreen()

}
