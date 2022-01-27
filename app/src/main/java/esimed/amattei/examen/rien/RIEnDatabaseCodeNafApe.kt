package esimed.amattei.examen.rien

import android.content.Context
import androidx.room.*
import esimed.amattei.examen.rien.dao.CodeNAFAPEDAO
import esimed.amattei.examen.rien.entities.CodeNAFAPEEntity

@Database(entities = [CodeNAFAPEEntity::class], version = 1)
abstract class RIEnDatabaseCodeNafApe: RoomDatabase() {

    abstract fun codeNAFAPEDao(): CodeNAFAPEDAO
    companion object {
        var INSTANCE: RIEnDatabaseCodeNafApe? = null
        fun getDatabase(context: Context): RIEnDatabaseCodeNafApe {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, RIEnDatabaseCodeNafApe::class.java, "CodeNAFAPEEntity.db")
                    .createFromAsset("CodeNAFAPEEntity.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
}