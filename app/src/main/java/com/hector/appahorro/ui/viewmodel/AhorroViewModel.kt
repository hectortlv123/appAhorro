package com.hector.appahorro.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hector.appahorro.data.entity.Categoria
import com.hector.appahorro.data.entity.MetaAhorro
import com.hector.appahorro.data.entity.Transaccion
import com.hector.appahorro.repository.AhorroRepository
import kotlinx.coroutines.launch

class AhorroViewModel (private val repository: AhorroRepository): ViewModel(){
    private val _categorias = MutableLiveData<List<Categoria>>()
    val categoria: LiveData<List<Categoria>> = _categorias

    private val _metas = MutableLiveData<List<MetaAhorro>>()
    val metas : LiveData<List<MetaAhorro>> = _metas

    private val _transacciones = MutableLiveData<List<Transaccion>>()
    val transaccion : LiveData<List<Transaccion>> = _transacciones


    //funcion para interactuar con el repository

    fun insertarCategoria(categoria: Categoria){
        viewModelScope.launch {
            repository.insertCategoria(categoria)
            _categorias.postValue(repository.obtenerCategorias())
        }
    }
    fun insertarMeta(meta: MetaAhorro){
        viewModelScope.launch {
            repository.insertarMeta(meta)
            _metas.postValue(repository.obtenerMetas())
        }
    }
    fun agregarAhorro(idMeta: Int, cantidad: Double){
        viewModelScope.launch {
            repository.agregarAhorro(idMeta, cantidad)
            _metas.postValue(repository.obtenerMetas())
        }
    }
    fun insertarTransaccion(transaccion: Transaccion){
        viewModelScope.launch {
            repository.insertarTransaccion(transaccion)
            _transacciones.postValue(repository.obtenerTransacciones())
        }
    }
    fun cargarDatosIniciales(){
        viewModelScope.launch {
            _categorias.postValue(repository.obtenerCategorias())
            _transacciones.postValue(repository.obtenerTransacciones())
            _metas.postValue(repository.obtenerMetas())
        }
    }
}