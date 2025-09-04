package com.hector.appahorro.data.dao
import androidx.room.Dao
import androidx.room.Update
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.lifecycle.LiveData
import com.hector.appahorro.data.entity.Categoria
import androidx.room.OnConflictStrategy


//el dao se utiliza para acceder y manipular datos en una base de datos
@Dao
interface CategoriaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(categoria: Categoria)

    @Update
    suspend fun actualizar(categoria: Categoria)

    @Delete
    suspend fun eliminar(categoria: Categoria)

    @Query("SELECT * FROM categoria ORDER BY nombre_categoria ASC")
    fun obtenerCategorias(): LiveData<List<Categoria>>
}