package com.hector.appahorro.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.hector.appahorro.data.entity.Transaccion
 //el dao se utiliza para acceder y manipular datos en una base de datos
@Dao
interface TransaccionDao{

    @Insert
    suspend fun insertar(transaccion : Transaccion)

    @Query("SELECT * FROM transaccion")
    suspend fun obtenerTodas(): List<Transaccion>

    @Query ("SELECT * FROM transaccion WHERE idCategoria = idCategoria")
    suspend fun obtenerPorCategoria(idCategoria:Int): List<Transaccion>
    //suspend para que no se congele o se trabe mientras hace la operacion
}