package cmps312.lab3.mvvmpractice.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cmps312.lab3.mvvmpractice.model.Student
import cmps312.lab3.mvvmpractice.viewmodel.GradeViewModel


@Composable
fun Home(onAdd: () -> Unit) {
    //define a value of the viewModel to use it and take an object of it
    //since viewmodel is context -> to call it use LocalContext.current
    val gradeViewModel =
        viewModel<GradeViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    Card(modifier = Modifier.fillMaxSize(), elevation = 18.dp) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val students = gradeViewModel.students
            LazyColumn {
                //we want to add list to the student will use the Student card
                items(students) { student ->
                    StudentCard(student, onDelete = { gradeViewModel.delete(student) })


                }
            }


        }
        //Arrangment so it can be at the left end of the page
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
            FloatingActionButton(
                //onAdd
                onClick = { onAdd() },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                modifier = Modifier.size(width = 62.dp, height = 62.dp)


            ) {
                Icon(Icons.Filled.Add, "")
            }
        }
    }
}

@Composable
fun StudentCard(student: Student, onDelete: () -> Unit) {

    Card(
        elevation = 10.dp,
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row {
            Column {
//at first its empty , when we add it will show
                Text(text = "Name: ${student.name}")
                Text(text = "Grade: ${student.grade}")
            }
//OnDelete functionality will be on the view Model
            IconButton(onClick = { onDelete() }) {
                Icon(imageVector = Icons.Filled.Delete, "")
            }
        }

    }

}