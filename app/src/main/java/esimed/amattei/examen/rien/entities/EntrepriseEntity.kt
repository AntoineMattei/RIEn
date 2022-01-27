package esimed.amattei.examen.rien.entities

import androidx.annotation.NonNull
import androidx.room.*
import esimed.amattei.examen.rien.model.Etablissement
import java.io.Serializable
import java.util.*

@Entity(
    indices = [
        Index(
            value = ["siret"],
            unique = true
        )
    ]
)
data class EntrepriseEntity(
    @PrimaryKey @NonNull var siret: String,
    var nom: String? = null,
    var dateCreation: String? = null,
    var codePostal: String? = null,
    var active: String? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
    var geo_adresse: String? = null,
    var codeNAFAPE: String? = null,
    var libelle_activite_principale: String? = null,
    var dateRecherche: Date
): Serializable {
    override fun toString(): String {
        if (active == "A") {
            return "L'entreprise $nom (SIRET : $siret), créée le $dateCreation, située au $geo_adresse, dont le code NAF-APE est $codeNAFAPE est active."
        } else {
            return "L'entreprise $nom (SIRET : $siret), créée le $dateCreation, située au $geo_adresse, dont le code NAF-APE est $codeNAFAPE n'est pas active."
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EntrepriseEntity

        if (siret != other.siret) return false
        if (nom != other.nom) return false
        if (dateCreation != other.dateCreation) return false
        if (codePostal != other.codePostal) return false
        if (active != other.active) return false
        if (latitude != other.latitude) return false
        if (longitude != other.longitude) return false
        if (geo_adresse != other.geo_adresse) return false
        if (codeNAFAPE != other.codeNAFAPE) return false
        return true
    }

    override fun hashCode(): Int {
        var result = this.siret.hashCode()
        result = 31 * result + (nom?.hashCode() ?: 0)
        result = 31 * result + (dateCreation?.hashCode() ?: 0)
        result = 31 * result + (codePostal?.hashCode() ?: 0)
        result = 31 * result + (active?.hashCode() ?: 0)
        result = 31 * result + (latitude?.hashCode() ?: 0)
        result = 31 * result + (longitude?.hashCode() ?: 0)
        result = 31 * result + (geo_adresse?.hashCode() ?: 0)
        result = 31 * result + (codeNAFAPE?.hashCode() ?: 0)
        return result
    }
}
