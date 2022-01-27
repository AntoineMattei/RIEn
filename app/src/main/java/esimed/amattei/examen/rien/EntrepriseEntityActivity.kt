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
import kotlinx.android.synthetic.main.activity_entreprise_entity.*

class EntrepriseEntityActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var entreprise: EntrepriseEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entreprise_entity)

        entreprise = intent.getSerializableExtra("entrepriseEntity") as EntrepriseEntity

        /**
         * Affichage du nom de l'entreprise
         */
        val nomEntreprise = getString(R.string.nom_de_lentreprise)
        textViewNomEntrepriseEntity.text =
            String.format(nomEntreprise, entreprise.nom, entreprise.siret)

        /**
         * Affichage de la date de création de l'entreprise
         */
        val dateCreationEntreprise = getString(R.string.date_de_la_creation_de_l_entreprise)
        val date = entreprise.dateCreation
        val annee = date?.take(4)
        val mois = date?.takeLast(2)
        textViewDateCreationEntrepriseEntity.text =
            String.format(dateCreationEntreprise, "01/$mois/$annee")

        /**
         * Affichage de l'activité principale de l'entreprise
         */
        val activitePrincipaleEntreprise = getString(R.string.activite_de_l_entreprise)
        textViewActiviteEntrepriseEntity.text = String.format(
            activitePrincipaleEntreprise,
            entreprise.libelle_activite_principale
        )

        /**
         * Affichage du code postal de l'entreprise
         */
        val codePostalEntreprise = getString(R.string.code_postal_de_l_entreprise)
        textViewCodePostalEntrepriseEntity.text =
            String.format(codePostalEntreprise, entreprise.codePostal)

        /**
         * Affichage du statut l'entreprise
         */
        val statutEntreprise = getString(R.string.entreprise_active)
        if (entreprise.active == "A") {
            textViewEntrepriseIsActiveEntity.text = String.format(statutEntreprise, "✔")
            textViewEntrepriseIsActiveEntity.setTextColor(Color.GREEN)
        } else {
            textViewEntrepriseIsActiveEntity.text = String.format(statutEntreprise, "❌")
            textViewEntrepriseIsActiveEntity.setTextColor(Color.RED)
        }

        /**
         * Gestion de la map
         */
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.mapEntity) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val emplacement = LatLng(entreprise.latitude!!, entreprise.longitude!!)
        googleMap.addMarker(
            MarkerOptions()
                .position(emplacement)
                .title(entreprise.nom)
        )

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(emplacement, 14f))
    }
}