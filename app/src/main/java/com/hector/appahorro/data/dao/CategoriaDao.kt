package com.hector.appahorro.data.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hector.appahorro.data.entity.Categoria


//el dao se utiliza para acceder y manipular datos en una base de datos
@Dao
interface CategoriaDao{
    @Insert
    suspend fun insertar(categoria:Categoria)

    @Query("SELECT * FROM categoria")
    suspend fun obtenerTodas():List<Categoria>
}