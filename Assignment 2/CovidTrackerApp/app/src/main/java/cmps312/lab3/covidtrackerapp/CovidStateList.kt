package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp

@Composable
fun CovidStateList(
    covid: List<CovidStat>,
    searchText: String,
    sortBy: SortBy
) {



    var filteredCovid = search(covid,searchText)
    filteredCovid = sort(filteredCovid, sortBy)


    LazyColumn {

//        item { ListHeader(searchText)}

        items(filteredCovid) {

            CovidCard(it)
        }

    }

}

//
fun search(
    covids: List<CovidStat>,
    searchText: String
) =
    if (searchText.isNullOrEmpty()) {
        covids
    } else {
        covids.filter {
            (it.country!!.contains(searchText, true) ||
                    searchText.isNullOrEmpty())
        }
    }


fun sort(covids: List<CovidStat>, sortBy: SortBy) =
    when (sortBy) {
        SortBy.COUNTRY -> covids.sortedBy { it.country }
        SortBy.ACTIVE_CASES -> covids.sortedBy { it.activeCases }
        SortBy.POPULATION -> covids.sortedBy { it.population }
        SortBy.TOTAL_DEATH -> covids.sortedBy { it.totalDeaths }

    }



