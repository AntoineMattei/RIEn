package esimed.amattei.examen.rien

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_recherche_par_entreprise.*

class RechercheParEntrepriseActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche_par_entreprise)

        RechercheParEntrepriseActivityAfficherOptionSupplementaires.setOnClickListener {
            if (RadioGroupOptionsSupplementaires.isVisible) {
                RadioGroupOptionsSupplementaires.visibility = View.GONE
                RechercheParEntrepriseActivityAfficherOptionSupplementaires.text =
                    "Afficher les options supplémentaires"
            } else {
                RadioGroupOptionsSupplementaires.visibility = View.VISIBLE
                RechercheParEntrepriseActivityAfficherOptionSupplementaires.text =
                    "Masquer les options supplémentaires"
            }
        }

        RechercheParEntrepriseActivityRadioButtonCodePostal.setOnClickListener {
            RechercheParEntrepriseActivityEditTextDepartement.visibility = View.GONE
            RechercheParEntrepriseActivityEditTextCodePostal.visibility = View.VISIBLE
        }

        RechercheParEntrepriseActivityRadioButtonDepartement.setOnClickListener {
            RechercheParEntrepriseActivityEditTextCodePostal.visibility = View.GONE
            RechercheParEntrepriseActivityEditTextDepartement.visibility = View.VISIBLE
        }
    }
}