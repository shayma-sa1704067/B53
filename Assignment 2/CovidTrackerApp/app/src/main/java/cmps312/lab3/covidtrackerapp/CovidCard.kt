package cmps312.lab3.covidtrackerapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontWeight


@Composable
fun CovidCard(covidStat: CovidStat) {
    val context = LocalContext.current
    Card(
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        elevation = 18.dp
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                val imgResourceId = R.drawable.country
                Image(
                    painter = painterResource(id = imgResourceId),
                    contentDescription = "country pic",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(width = 60.dp, height = 60.dp)


                )

                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {

                    Text(
                        text = "Country"
                    )

                    Text(
                        text = "${covidStat.country} ",
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold
                    )

                }


            }

            Box(modifier = Modifier.fillMaxWidth()) {


                Row(
                    modifier = Modifier.align(Alignment.TopStart)

                ) {
                    val imgResourceId = R.drawable.population
                    Image(
                        painter = painterResource(id = imgResourceId),
                        contentDescription = "country pic",
                        modifier = Modifier
                            .size(width = 60.dp, height = 60.dp)
                            .clip(RoundedCornerShape(CornerSize(10.dp)))


                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Population "
                        )

                        Text(
                            text = "${covidStat.population} ",
                            fontWeight = FontWeight.Bold
                        )

                    }
                }

                Row(
                    modifier = Modifier.align(Alignment.TopEnd)

                ) {
                    val imgResourceId = R.drawable.activecases
                    Image(
                        painter = painterResource(id = imgResourceId),
                        contentDescription = "country pic",
                        modifier = Modifier
                            .size(width = 60.dp, height = 60.dp)
                            .clip(RoundedCornerShape(CornerSize(10.dp)))


                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Active Cases "
                        )

                        Text(
                            text = "${covidStat.activeCases} ",
                            fontWeight = FontWeight.Bold
                        )

                    }
                }




            }
            Box(modifier = Modifier.fillMaxWidth()) {

                Row(
                    modifier = Modifier.align(Alignment.TopStart)

                ) {
                    val imgResourceId = R.drawable.dead
                    Image(
                        painter = painterResource(id = imgResourceId),
                        contentDescription = "country pic",
                        modifier = Modifier
                            .size(width = 60.dp, height = 60.dp)
                            .clip(RoundedCornerShape(CornerSize(10.dp)))


                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Total Deadth "
                        )

                        Text(
                            text = "${covidStat.totalDeaths} ",
                            fontWeight = FontWeight.Bold
                        )

                    }
                }

                Row(
                    modifier = Modifier.align(Alignment.TopEnd)

                ) {
                    val imgResourceId = R.drawable.recovered
                    Image(
                        painter = painterResource(id = imgResourceId),
                        contentDescription = "country pic",
                        modifier = Modifier
                            .size(width = 60.dp, height = 60.dp)
                            .clip(RoundedCornerShape(CornerSize(10.dp)))


                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Total Recovered "
                        )

                        Text(
                            text = "${covidStat.totalRecovered} ",
                            fontWeight = FontWeight.Bold
                        )

                    }
                }




            }
        }
    }



}

