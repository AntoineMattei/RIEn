package esimed.amattei.examen.rien

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import esimed.amattei.examen.rien.entities.EntrepriseEntity
import esimed.amattei.examen.rien.model.Etablissement
import kotlinx.android.synthetic.main.activity_entreprise.*
import java.util.*

class EntrepriseActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var entreprise: Etablissement
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entreprise)

        entreprise = intent.getSerializableExtra("entreprise") as Etablissement

        val entrepriseEntity = EntrepriseEntity(
            entreprise.siret!!,
            entreprise.nom_raison_sociale,
            entreprise.date_creation_entreprise,
            entreprise.code_postal,
            entreprise.indicateur_champ_publipostage,
            entreprise.latitude,
            entreprise.longitude,
            entreprise.geo_adresse,
            entreprise.activite_principale,
            entreprise.libelle_activite_principale,
            Calendar.getInstance().time
        )

        val rienDatabase = RIEnDatabase.getDatabaseRienDatabase(this)
        val entrepriseDAO = rienDatabase.entrepriseDAO()
        entrepriseDAO.insert(entrepriseEntity)

        /**
         * Affichage du nom de l'entreprise
         */
        val nomEntreprise = getString(R.string.nom_de_lentreprise)
        textViewNomEntreprise.text =
            String.format(nomEntreprise, entreprise.nom_raison_sociale, entreprise.siret)

        /**
         * Affichage de la date de création de l'entreprise
         */
        val dateCreationEntreprise = getString(R.string.date_de_la_creation_de_l_entreprise)
        val date = entreprise.date_creation_entreprise
        val annee = date?.take(4)
        val mois = date?.takeLast(2)
        textViewDateCreationEntreprise.text =
            String.format(dateCreationEntreprise, "01/$mois/$annee")

        /**
         * Affichage de l'activité principale de l'entreprise
         */
        val activitePrincipaleEntreprise = getString(R.string.activite_de_l_entreprise)
        textViewActiviteEntreprise.text = String.format(
            activitePrincipaleEntreprise,
            entreprise.libelle_activite_principale_entreprise
        )

        /**
         * Affichage du code postal de l'entreprise
         */
        val codePostalEntreprise = getString(R.string.code_postal_de_l_entreprise)
        textViewCodePostalEntreprise.text =
            String.format(codePostalEntreprise, entreprise.code_postal)

        /**
         * Affichage du statut l'entreprise
         */
        val statutEntreprise = getString(R.string.entreprise_active)
        if (entreprise.indicateur_champ_publipostage == "A") {
            textViewEntrepriseIsActive.text = String.format(statutEntreprise, "✔")
            textViewEntrepriseIsActive.setTextColor(Color.GREEN)
        } else {
            textViewEntrepriseIsActive.text = String.format(statutEntreprise, "❌")
            textViewEntrepriseIsActive.setTextColor(Color.RED)
        }

        /**
         * Gestion de la map
         */
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val emplacement = LatLng(entreprise.latitude!!, entreprise.longitude!!)
        googleMap.addMarker(
            MarkerOptions()
                .position(emplacement)
                .title(entreprise.nom_raison_sociale)
        )

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(emplacement, 14f))
    }
}