package cmps312.lab3.covidtrackerapp

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object CovidStatRepository {

    var covidList = listOf<CovidStat>()


    fun initCovidStat(context: Context):List<CovidStat>{
        if (covidList.isEmpty()) {
            val covidStateJson =
                context.assets.open("covid-data.json").bufferedReader().use { it.readText() }

            covidList = Json.decodeFromString(covidStateJson)
        }

        return covidList
    }
}