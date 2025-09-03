package com.hector.appahorro.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete

import  com.hector.appahorro.data.entity.MetaAhorro

//el dao se utiliza para acceder y manipular datos en una base de datos
@Dao
interface MetaAhorroDao{

    @Insert
    suspend fun insertar(meta: MetaAhorro)

    @Query
    suspend fun obtenerTodas(): List<MetaAhorro>

    @Query("UPDATE meta_ahorro SET monto_ahorrado = monto_ahorrado + :cantidad WHERE id_meta_ahorro = :idMeta")
    suspend fun agregarAhorro(idMeta: Int, cantidad: Double)

}