package com.vbv.pagging3.ui.screen.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vbv.pagging3.data.interfaces.RetrofitClient
import com.vbv.pagging3.data.model.Product
import com.vbv.pagging3.data.repositories.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val productRepository = ProductRepository(RetrofitClient.apiService)

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)

    val uiState : StateFlow<UiState> = _uiState.asStateFlow()

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = productRepository.getProducts()
                _uiState.value = UiState.Success(products.products)
            }catch (e : Exception){
                Log.e("LogVbv","Exception ${e.localizedMessage}")
                _uiState.value = UiState.Error(e.localizedMessage!!)
            }
        }
    }
}



sealed interface UiState{
    object Loading : UiState
    data class Success(val products : List<Product>) : UiState
    data class Error(val message: String) : UiState
}