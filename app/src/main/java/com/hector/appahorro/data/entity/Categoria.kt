package com.hector.appahorro.data.entity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoria")
data class Categoria (
    @PrimaryKey(autoGenerate = true) val id_categoria: Int = 0,
    val tipo_transaccion: String,
    val nombre_categoria: String
)