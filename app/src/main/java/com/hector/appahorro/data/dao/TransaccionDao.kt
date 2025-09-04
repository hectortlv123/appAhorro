package com.hector.appahorro.data.dao

import androidx.room.Dao
import androidx.room.*
import androidx.room.Insert
import androidx.room.Query
import androidx.room. Update
import androidx.room.Delete
import androidx.lifecycle.LiveData //observar los cambios en los datos
import com.hector.appahorro.data.entity.Transaccion
 //el dao se utiliza para acceder y manipular datos en una base de datos
//es un objeto de acceso a datos usado por Room.
 @Dao
 interface TransaccionDao {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertar(transaccion: Transaccion)

     @Update
     suspend fun actualizar(transaccion: Transaccion)

     @Delete
     suspend fun eliminar(transaccion: Transaccion)

     @Query("SELECT * FROM transaccion ORDER BY fecha DESC")
     fun obtenerTransacciones(): LiveData<List<Transaccion>>

     @Query("SELECT SUM(monto) FROM transaccion WHERE tipo = 'ingreso'")
     fun obtenerTotalIngresos(): LiveData<Double?>

     @Query("SELECT SUM(monto) FROM transaccion WHERE tipo = 'gasto'")
     fun obtenerTotalGastos(): LiveData<Double?>

     @Query("SELECT * FROM transaccion WHERE id_meta_ahorro = :idMeta")
     fun obtenerTransaccionesPorMeta(idMeta: Int): LiveData<List<Transaccion>>
 }
    //suspend para que no se congele o se trabe mientras hace la operacion
    //y trabaja en segundo plano sin bloquear la app
