package esimed.amattei.examen.rien.dao

import esimed.amattei.examen.rien.entities.*
import androidx.room.*

@Dao
interface EntrepriseArchiveeDAO {
    @Query("SELECT * FROM EntrepriseArchiveeEntity")
    fun returnEntrepriseArchivee(): List<EntrepriseArchiveeEntity>

    @Query("SELECT nom FROM EntrepriseArchiveeEntity WHERE siret = :siret")
    fun returnNomEntrepriseArchiveeFromSiret(siret: String): String

    @Insert
    fun insertEntrepriseArchivee(entrepriseArchivee: EntrepriseArchiveeEntity)

    @Query("DELETE FROM EntrepriseEntity WHERE dateRecherche <= date('now','-3 month')")
    fun deleteTooOldSearchesArchivee()

    @Update
    fun update(entrepriseArchivee: EntrepriseArchiveeEntity)

    @Delete
    fun delete(entrepriseArchivee: EntrepriseArchiveeEntity)
}