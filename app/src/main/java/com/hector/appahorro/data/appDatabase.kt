package com.hector.appahorro.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hector.appahorro.data.entity.Transaccion
import com.hector.appahorro.data.entity.MetaAhorro
import com.hector.appahorro.data.entity.Categoria

import com.hector.appahorro.data.dao.TransaccionDao
import com.hector.appahorro.data.dao.MetaAhorroDao
import com.hector.appahorro.data.dao.CategoriaDao


@Database(
    entities = [Categoria::class, MetaAhorro::class, Transaccion::class],
    version = 1,
    exportSchema = false
)
abstract class appDatabase: RoomDatabase() {
    abstract fun categoriaDao(): CategoriaDao
    abstract fun metaAhorroDao(): MetaAhorroDao
    abstract fun transaccionDao(): TransaccionDao
}