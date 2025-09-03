package com.hector.appahorro.repository

import androidx.core.os.trace
import com.hector.appahorro.data.entity.Transaccion
import com.hector.appahorro.data.entity.MetaAhorro
import com.hector.appahorro.data.entity.Categoria

import com.hector.appahorro.data.dao.TransaccionDao
import com.hector.appahorro.data.dao.MetaAhorroDao
import com.hector.appahorro.data.dao.CategoriaDao
//repository hace el puente entre base de dato y viewmodel
class AhorroRepository (
    private val categoriaDao: CategoriaDao,
    private val metaAhorroDao: MetaAhorroDao,
    private val transaccionDao: TransaccionDao
    ){


    //categoria
    suspend fun insertCategoria(categoria:Categoria){ //agrega una nueva categoria en la tabla categoria
        categoriaDao.insertar(categoria)

    }

    suspend fun obtenerCategorias(): List<Categoria>{ //llama a todas las categorias de la base de dato
        return categoriaDao.obtenerTodas()
    }

    //metas de ahorro
    suspend fun insertarMeta(meta: MetaAhorro){
        metaAhorroDao.insertar(meta)
    }
    suspend fun obtenerMetas():List<MetaAhorro>{
        return metaAhorroDao.obtenerTodas()
    }
    suspend fun agregarAhorro(idMeta: Int, cantidad: Double){ //suma cantidad + montoahorrado que sera por su id
        metaAhorroDao.agregarAhorro(idMeta, cantidad)
    }

    //transacciones
    suspend fun insertarTransaccion(transaccion:Transaccion){
        transaccionDao.insertar(transaccion)
    }
    suspend fun obtenerTransacciones(): List<Transaccion>{
        return transaccionDao.obtenerTodas()
    }
    suspend fun obtenerTransaccionPorCategoria(idCategoria: Int): List<Transaccion>{
        return transaccionDao.obtenerPorCategoria(idCategoria)
    }
}