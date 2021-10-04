package cmps312.lab3.studentgradesystem.repository

import android.content.Context

class StudentRepository(private val context: Context) {
    private fun readData(filename: String) =
        context.assets.open(filename).bufferedReader().use { it.readText() }

}