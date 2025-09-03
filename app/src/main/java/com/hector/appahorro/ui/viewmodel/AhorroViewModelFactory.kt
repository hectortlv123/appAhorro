package com.hector.appahorro.ui.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hector.appahorro.repository.AhorroRepository


class AhorroViewModelFactory (private val repository: AhorroRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AhorroViewModel::class.java)){
            @Suppress("UNCHECKED_CAST") //sirve para ocultar una advertencia de peligro
            return AhorroViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") //detiene el programa si algo sale mal
        //throw lanza un error, IllegalArgumentException(el tipo de error)
    }
}