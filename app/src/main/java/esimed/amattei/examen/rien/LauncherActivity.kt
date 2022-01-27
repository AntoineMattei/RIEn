package esimed.amattei.examen.rien

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import esimed.amattei.examen.rien.entities.EntrepriseArchiveeEntity
import kotlinx.android.synthetic.main.activity_launcher.*
import java.util.*

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        supportActionBar?.hide()

        val rienDatabase = RIEnDatabase.getDatabaseRienDatabase(this)
        val entrepriseDAO = rienDatabase.entrepriseDAO()
        val entrepriseArchiveeDAO = rienDatabase.entrepriseArchiveeDAO()

        var nbJoursMemoire = 1
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -nbJoursMemoire)


        for (i in entrepriseDAO.returnSiretFromTooOldSearches()) {
            val calendrierJInsertion = toCalendar(entrepriseDAO.returnDateInsertionFromSiret(i))
            if (calendrierJInsertion!! <= calendar) {
                if (!entrepriseArchiveeDAO.returnSiretFromEntrepriseArchivee().contains(i)) {
                    entrepriseArchiveeDAO.insertEntrepriseArchivee(
                        EntrepriseArchiveeEntity(
                            i,
                            entrepriseDAO.returnNomEntrepriseFromSiret(i)
                        )
                    )
                }
            }
        }

        entrepriseDAO.deleteTooOldSearches()

        entrepriseArchiveeDAO.deleteTooOldSearchesArchivee()

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun toCalendar(date: Date): Calendar? {
        val cal = Calendar.getInstance()
        cal.time = date
        return cal
    }
}