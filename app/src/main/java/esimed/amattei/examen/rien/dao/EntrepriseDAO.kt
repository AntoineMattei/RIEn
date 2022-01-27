package esimed.amattei.examen.rien.dao

import esimed.amattei.examen.rien.entities.*
import androidx.room.*
import java.util.*

@Dao
interface EntrepriseDAO {
    @Query("SELECT * FROM EntrepriseEntity")
    fun returnEntreprise(): List<EntrepriseEntity>

    @Query("SELECT nom FROM EntrepriseEntity WHERE siret = :siret")
    fun returnNomEntrepriseFromSiret(siret: String): String

    @Query("SELECT active FROM EntrepriseEntity WHERE siret = :siret")
    fun returnEntrepriseIsActive(siret: String): String

    @Query("SELECT codePostal FROM EntrepriseEntity WHERE siret = :siret")
    fun returnCodePostal(siret: String): Int

    @Query("SELECT dateCreation FROM EntrepriseEntity WHERE siret = :siret")
    fun returnDateCreation(siret: String): String

    @Query("SELECT latitude FROM EntrepriseEntity WHERE siret = :siret")
    fun returnLatitude(siret: String): Double

    @Query("SELECT longitude FROM EntrepriseEntity WHERE siret = :siret")
    fun returnLongitude(siret: String): Double

    @Query("SELECT geo_adresse FROM EntrepriseEntity WHERE siret= :siret")
    fun returnGeoAdresse(siret: String): String

    @Query("DELETE FROM EntrepriseEntity WHERE dateRecherche <= date('now','-1 day')")
    fun deleteTooOldSearches()

    @Query("SELECT dateRecherche FROM EntrepriseEntity WHERE siret = :siret")
    fun returnDateInsertionFromSiret(siret: String): Date

    @Query("SELECT COUNT(*) FROM EntrepriseEntity WHERE dateRecherche <= date('now','-1 day')")
    fun countTooOldSearches(): Int

    @Query("SELECT siret FROM EntrepriseEntity ")
    fun returnSiretFromTooOldSearches(): List<String>

    @Query("SELECT nom FROM EntrepriseEntity WHERE siret = :siret ")
    fun returnNameFromTooOldSearchesBySiret(siret: String): String

    @Insert
    fun insert(entreprise: EntrepriseEntity)

    @Update
    fun update(entreprise: EntrepriseEntity)

    @Delete
    fun delete(entreprise: EntrepriseEntity)
}