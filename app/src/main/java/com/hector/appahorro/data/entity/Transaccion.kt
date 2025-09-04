package com.hector.appahorro.data.entity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaccion")
data class Transaccion (
    @PrimaryKey(autoGenerate = true) val id_transaccion: Int = 0,
    val monto: Double,
    val descripcion: String,
    val fecha: String,
    val tipo: String,
    val  idCategoria: Int,
    val id_meta_ahorro: Int?
)