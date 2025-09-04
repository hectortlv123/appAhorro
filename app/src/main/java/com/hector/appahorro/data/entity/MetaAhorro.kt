package com.hector.appahorro.data.entity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "meta_ahorro")
data class MetaAhorro (
    @PrimaryKey(autoGenerate = true) val id_meta_ahorro: Int = 0,
    val nombre_meta: String,
    val monto_meta: Double,
    val monto_ahorrado: Double = 0.0,
    val fecha_inicio: String,
    val fecha_fin: String,
    val descripcion: String
    )