package esimed.amattei.examen.rien.entities

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "CodeNAFAPEEntity")
data class CodeNAFAPEEntity(
    @PrimaryKey @NonNull var codeNAFAPE: String,
    var description: String? = null,
    var section: Int? = null,
    var description_section: String? = null
) {
    override fun toString(): String {
        return "Code NAF-APE : $codeNAFAPE : $description, Section $section : $description_section)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CodeNAFAPEEntity

        if (codeNAFAPE != other.codeNAFAPE) return false
        if (description != other.description) return false
        if (section != other.section) return false
        if (description_section != other.description_section) return false

        return true
    }

    override fun hashCode(): Int {
        var result = codeNAFAPE?.hashCode() ?: 0
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (section?.hashCode() ?: 0)
        result = 31 * result + (description_section?.hashCode() ?: 0)
        return result
    }
}