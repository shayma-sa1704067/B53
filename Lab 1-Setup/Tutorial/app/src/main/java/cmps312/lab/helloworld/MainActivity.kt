package cmps312.lab.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showBtn.setOnClickListener {
            val name = nameEdt.text.toString();
            displayTv.text = name

//            "111".toInt()
            Toast.makeText(this, "Nice you clicked mr $name", Toast.LENGTH_SHORT).show()
        }
    }
}