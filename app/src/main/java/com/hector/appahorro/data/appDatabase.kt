package com.hector.appahorro.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hector.appahorro.data.dao.CategoriaDao
import com.hector.appahorro.data.dao.MetaAhorroDao
import com.hector.appahorro.data.dao.TransaccionDao
import com.hector.appahorro.data.entity.Categoria
import com.hector.appahorro.data.entity.MetaAhorro
import com.hector.appahorro.data.entity.Transaccion

// Declaramos la base de datos de Room
@Database(
    entities = [Categoria::class, MetaAhorro::class, Transaccion::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // Métodos abstractos para acceder a los DAO
    abstract fun categoriaDao(): CategoriaDao
    abstract fun metaAhorroDao(): MetaAhorroDao
    abstract fun transaccionDao(): TransaccionDao

    companion object {
        @Volatile
        private var INSTANCIA: AppDatabase? = null

        fun obtenerBaseDatos(contexto: Context): AppDatabase {
            return INSTANCIA ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    contexto.applicationContext,
                    AppDatabase::class.java,
                    "base_datos_ahorro"  // nombre del archivo de BD
                )
                    .fallbackToDestructiveMigration() // en caso de cambio de versión, borra y recrea
                    .build()
                INSTANCIA = instancia
                instancia
            }
        }
    }
}
