package esimed.amattei.examen.rien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        card_view_entreprise.setOnClickListener {
            startActivity(Intent(this, RechercheParEntrepriseActivity::class.java))
        }

        card_view_activite.setOnClickListener {
            startActivity(Intent(this, RechercheParActiviteActivity::class.java))
        }

        infoFloatButton.setOnClickListener {
            startActivity(Intent(this, InfoActivity::class.java))
        }

        historyFloatButton.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
    }
}