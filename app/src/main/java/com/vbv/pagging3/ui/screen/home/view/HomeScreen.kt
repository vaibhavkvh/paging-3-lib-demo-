package com.vbv.pagging3.ui.screen.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.vbv.pagging3.data.model.Product
import com.vbv.pagging3.ui.screen.home.customwidget.HomeProductItem
import com.vbv.pagging3.ui.screen.home.viewmodel.HomeViewModel
import com.vbv.pagging3.ui.screen.home.viewmodel.UiState

@Composable
fun HomeScreen(modifier: Modifier,viewModel: HomeViewModel = viewModel()){


    val uiState by viewModel.uiState.collectAsState()
    Scaffold(modifier) {
        Box(Modifier.fillMaxSize().padding(it), contentAlignment = Alignment.Center){
            when(uiState){
                is UiState.Success -> {
                    ProductListing((uiState as UiState.Success).products)
                }
                is UiState.Error -> {
                    Text(text = (uiState as UiState.Error).message, color = Color.Red)

                }
                else -> {
                    CircularProgressIndicator()

                }
            }
        }

    }
}

@Composable
fun ProductListing(products: List<Product>) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(count = products.size){index->
            HomeProductItem(products[index])
        }
    }
}