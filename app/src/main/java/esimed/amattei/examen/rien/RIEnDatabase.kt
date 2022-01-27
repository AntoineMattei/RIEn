package esimed.amattei.examen.rien

import android.content.Context
import androidx.room.*
import esimed.amattei.examen.rien.entities.*
import esimed.amattei.examen.rien.dao.*

@Database(entities = [CodeNAFAPEEntity::class, EntrepriseEntity::class, EntrepriseArchiveeEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class RIEnDatabase: RoomDatabase() {

    abstract fun entrepriseArchiveeDAO(): EntrepriseArchiveeDAO
    abstract fun entrepriseDAO(): EntrepriseDAO

    companion object {
        var INSTANCE: RIEnDatabase? = null
        fun getDatabaseRienDatabase(context: Context): RIEnDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, RIEnDatabase::class.java, "RIEnDatabaseSql.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
}