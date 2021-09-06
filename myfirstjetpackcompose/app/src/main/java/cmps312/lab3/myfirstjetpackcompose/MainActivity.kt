package cmps312.lab3.myfirstjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmps312.lab3.myfirstjetpackcompose.ui.theme.MyfirstjetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyfirstjetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Myfun()


                }
            }
        }
    }
}



@Composable
fun Myfun(){

    val image = painterResource(id = R.drawable.mylogo)
    val username = remember{ mutableStateOf("")}
    val password = remember{ mutableStateOf("")}
    val user1 = username.value.toString()
    val context = LocalContext.current

    val count = remember{ mutableStateOf(100)}
    Column( modifier = Modifier
        .border(2.dp, Color.Red)
        .padding(16.dp)
        .border(4.dp, Color.Black)
        .padding(16.dp)
        .border(8.dp, Color.Magenta)
        .padding(16.dp)
        .fillMaxSize()
        .background(Color.Green),
        verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Text(text = "hello jetpack", fontSize = 26.sp, fontFamily = FontFamily.Cursive
            ,fontWeight = FontWeight.ExtraBold )


        Image(painter = image , contentDescription ="lays" , modifier = Modifier
            .sizeIn(maxHeight = 500.dp)
        )


        Text(text = "Hi! $user1", fontSize = 26.sp, fontFamily = FontFamily.Cursive
            ,fontWeight = FontWeight.ExtraBold )

        Text(text = count.value.toString(), fontSize = 26.sp, fontFamily = FontFamily.Cursive
            ,fontWeight = FontWeight.ExtraBold, modifier = Modifier.clickable { count.value -=1 } )
        OutlinedTextField(value =username.value , onValueChange = {username.value=it},



            label={ Text(text = "username")}, placeholder={ Text(
            text = "enter username"
        )})

        OutlinedTextField(value =password.value , onValueChange = {password.value=it},

            label={ Text(text = "Password")}, placeholder={ Text(
                text = "enter password"
            )})


        OutlinedButton(onClick = { if(username.value.contains("qu.edu.qa")

            and password.value.equals("pass1234"))



                Toast.makeText(context, "logged in", Toast.LENGTH_SHORT).show()

                else
            Toast.makeText(context, "invalid credentials", Toast.LENGTH_SHORT).show()

                                 }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")

        }



    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyfirstjetpackcomposeTheme {
        Myfun()

    }
}