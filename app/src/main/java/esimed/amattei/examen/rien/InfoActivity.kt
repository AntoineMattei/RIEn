package esimed.amattei.examen.rien

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var nb_fois_cliquee = 0

        textViewCreator.setOnClickListener {
            nb_fois_cliquee++
            if(nb_fois_cliquee == 10) {
                Toast.makeText(this, "@Esimed", Toast.LENGTH_LONG).show()
                nb_fois_cliquee = 0
            }
        }
    }
}