package esimed.amattei.examen.rien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import esimed.amattei.examen.rien.entities.EntrepriseArchiveeEntity
import kotlinx.android.synthetic.main.activity_history.*
import java.util.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val rienDatabase = RIEnDatabase.getDatabaseRienDatabase(this)
        val entrepriseArchiveeDAO = rienDatabase.entrepriseArchiveeDAO()

        listResultHistoryActivity.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            entrepriseArchiveeDAO.returnEntrepriseArchivee().toTypedArray()
        )

        listResultHistoryActivity.setOnItemClickListener { parent, view, position, id ->

            val itemEntrepriseEntity = listResultHistoryActivity
                .adapter
                .getItem(position) as EntrepriseArchiveeEntity

            val query = itemEntrepriseEntity.nom
                ?.lowercase(Locale.getDefault())
                ?.replace(" ", "_")

            val intent = Intent(
                this,
                EntrepriseArchiveeActivity::class.java
            )

            intent.putExtra("nomEntreprise", query)

            startActivity(intent)
        }
    }
}