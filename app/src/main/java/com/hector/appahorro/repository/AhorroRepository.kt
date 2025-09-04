package com.hector.appahorro.data.repository

import androidx.lifecycle.LiveData
import com.hector.appahorro.data.dao.CategoriaDao
import com.hector.appahorro.data.dao.MetaAhorroDao
import com.hector.appahorro.data.dao.TransaccionDao
import com.hector.appahorro.data.entity.Categoria
import com.hector.appahorro.data.entity.MetaAhorro
import com.hector.appahorro.data.entity.Transaccion

class AhorroRepository(
    private val categoriaDao: CategoriaDao,
    private val metaAhorroDao: MetaAhorroDao,
    private val transaccionDao: TransaccionDao
) {

    // --- Categorías ---
    fun obtenerCategorias(): LiveData<List<Categoria>> = categoriaDao.obtenerCategorias()
    suspend fun insertarCategoria(categoria: Categoria) = categoriaDao.insertar(categoria)
    suspend fun actualizarCategoria(categoria: Categoria) = categoriaDao.actualizar(categoria)
    suspend fun eliminarCategoria(categoria: Categoria) = categoriaDao.eliminar(categoria)

    // --- Metas de ahorro ---
    fun obtenerMetas(): LiveData<List<MetaAhorro>> = metaAhorroDao.obtenerMetas()
    fun obtenerMetaPorId(id: Int): LiveData<MetaAhorro> = metaAhorroDao.obtenerMetaPorId(id)
    suspend fun insertarMeta(meta: MetaAhorro) = metaAhorroDao.insertar(meta)
    suspend fun actualizarMeta(meta: MetaAhorro) = metaAhorroDao.actualizar(meta)
    suspend fun eliminarMeta(meta: MetaAhorro) = metaAhorroDao.eliminar(meta)

    // --- Transacciones ---
    fun obtenerTransacciones(): LiveData<List<Transaccion>> = transaccionDao.obtenerTransacciones()
    fun obtenerTransaccionesPorMeta(idMeta: Int): LiveData<List<Transaccion>> =
        transaccionDao.obtenerTransaccionesPorMeta(idMeta)

    fun obtenerTotalIngresos(): LiveData<Double?> = transaccionDao.obtenerTotalIngresos()
    fun obtenerTotalGastos(): LiveData<Double?> = transaccionDao.obtenerTotalGastos()

    suspend fun insertarTransaccion(transaccion: Transaccion) =
        transaccionDao.insertar(transaccion)

    suspend fun actualizarTransaccion(transaccion: Transaccion) =
        transaccionDao.actualizar(transaccion)

    suspend fun eliminarTransaccion(transaccion: Transaccion) =
        transaccionDao.eliminar(transaccion)
}
