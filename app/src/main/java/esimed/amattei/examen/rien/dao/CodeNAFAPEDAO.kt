package esimed.amattei.examen.rien.dao

import esimed.amattei.examen.rien.entities.*
import androidx.room.*

@Dao
interface CodeNAFAPEDAO {
    @Query("SELECT * FROM CodeNAFAPEEntity")
    fun returnCodeNafApe(): List<CodeNAFAPEEntity>

    @Query("SELECT description FROM CodeNAFAPEEntity")
    fun returnDescriptionCodeNafApe(): List<String>

    @Query("SELECT codeNAFAPE FROM CodeNAFAPEEntity")
    fun returnCodeCodeNafApe(): List<String>

    @Query("SELECT description FROM CodeNAFAPEEntity WHERE codeNAFAPE = :codeNafApe")
    fun returnDescriptionOfCodeNafApe(codeNafApe: String): String

    @Query("SELECT codeNAFAPE FROM CodeNAFAPEEntity WHERE description = :description")
    fun returnCodeNafApeOfDescription(description: String): String

    @Insert
    fun insertAll(codeNafApe: CodeNAFAPEEntity)
    
    @Update
    fun update(codeNafApe: CodeNAFAPEEntity)

    @Delete
    fun delete(codeNafApe: CodeNAFAPEEntity)
}