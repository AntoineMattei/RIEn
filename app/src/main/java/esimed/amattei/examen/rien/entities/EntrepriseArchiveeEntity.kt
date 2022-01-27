package esimed.amattei.examen.rien.entities

import androidx.room.*
import org.jetbrains.annotations.NotNull

@Entity
data class EntrepriseArchiveeEntity(
    @PrimaryKey @NotNull var siret: String,
    var nom: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EntrepriseArchiveeEntity

        if (siret != other.siret) return false
        if (nom != other.nom) return false

        return true
    }

    override fun hashCode(): Int {
        var result = siret?.hashCode() ?: 0
        result = 31 * result + (nom?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "$nom ($siret)"
    }
}
