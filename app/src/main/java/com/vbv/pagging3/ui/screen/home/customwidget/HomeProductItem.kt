package com.vbv.pagging3.ui.screen.home.customwidget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.vbv.pagging3.data.model.Product


@Composable
fun HomeProductItem(product: Product){
    ElevatedCard(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp).fillMaxWidth(), elevation = CardDefaults.elevatedCardElevation(5.dp),) {
        Row() {
            AsyncImage(
                model = product.thumbnail,
                contentDescription = ""
            )
            Column(Modifier.padding(8.dp)) {
                Text(text = product.title, style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp))

                Spacer(Modifier.height(8.dp))

                Text(text = product.category, style = TextStyle(color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 14.sp))

                Spacer(Modifier.height(8.dp))

                Text(text = product.description, style = TextStyle(color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 12.sp))
            }
        }
    }
}