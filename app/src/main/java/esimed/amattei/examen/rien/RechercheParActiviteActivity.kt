package esimed.amattei.examen.rien

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_recherche_par_activite.*

class RechercheParActiviteActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche_par_activite)

        RechercheParActiviteActivityAfficherOptionSupplementaires.setOnClickListener {
            if (RadioGroupOptionsSupplementaires.isVisible) {
                RadioGroupOptionsSupplementaires.visibility = View.GONE
                RechercheParActiviteActivityAfficherOptionSupplementaires.text =
                    "Afficher les options supplémentaires"
            } else {
                RadioGroupOptionsSupplementaires.visibility = View.VISIBLE
                RechercheParActiviteActivityAfficherOptionSupplementaires.text =
                    "Masquer les options supplémentaires"
            }
        }

        RechercheParActiviteActivityRadioButtonActivite.setOnClickListener {
            RechercheParActiviteActivityEditTextCodeNAF.visibility = View.GONE
            RechercheParActiviteActivityEditTextActivite.visibility = View.VISIBLE
        }

        RechercheParActiviteActivityRadioButtonCodeNAF.setOnClickListener {
            RechercheParActiviteActivityEditTextActivite.visibility = View.GONE
            RechercheParActiviteActivityEditTextCodeNAF.visibility = View.VISIBLE
        }
    }
}