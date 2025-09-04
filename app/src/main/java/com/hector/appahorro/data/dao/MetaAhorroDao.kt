package com.hector.appahorro.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.*
import androidx.lifecycle.LiveData

import  com.hector.appahorro.data.entity.MetaAhorro

//el dao se utiliza para acceder y manipular datos en una base de datos
@Dao
interface MetaAhorroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(metaAhorro: MetaAhorro)

    @Update
    suspend fun actualizar(metaAhorro: MetaAhorro)

    @Delete
    suspend fun eliminar(metaAhorro: MetaAhorro)

    @Query("SELECT * FROM meta_ahorro ORDER BY fecha_fin ASC")
    fun obtenerMetas(): LiveData<List<MetaAhorro>>

    @Query("SELECT * FROM meta_ahorro WHERE id_meta_ahorro = :id")
    fun obtenerMetaPorId(id: Int): LiveData<MetaAhorro>
}