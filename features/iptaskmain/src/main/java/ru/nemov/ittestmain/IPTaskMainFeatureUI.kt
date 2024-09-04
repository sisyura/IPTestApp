package ru.nemov.ittestmain

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun IpTaskMain() {
    IPTaskMain(viewModel = viewModel())
}

@Composable
internal fun IPTaskMain(viewModel: IPTaskViewModel) {
    val products by viewModel.products.collectAsState()
    Products(products = products)
}

@Composable
private fun Products(products: List<ProductUI>) {
    LazyColumn {
        items(products) { product ->
            key(product.id) {
                Product(product)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
internal fun Product(@PreviewParameter(ProductPreviewProvider::class) product: ProductUI) {

    Surface(
        modifier = Modifier
        .padding(8.dp),
        shape = RoundedCornerShape(4.dp),
        shadowElevation = 4.dp,
        onClick = { /*TODO*/ }
    ) {
        Column {
            Row {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f),
                    contentAlignment = Alignment.CenterStart
                ){
                    Text(text = product.name, style = MaterialTheme.typography.titleLarge, maxLines = 1, fontWeight = FontWeight.Medium)
                }
                Box(
                    contentAlignment = Alignment.CenterEnd
                ){
                    IconButton(
                        modifier = Modifier
                            .padding(end = 40.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(Icons.Default.Create, contentDescription = "Change")
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete")
                    }
                }
            }
            FlowRow(
                modifier = Modifier
                    .padding(start = 8.dp, end = 5.dp, top = 3.dp, bottom = 3.dp)
            ) {
                for (tag in product.tags!!) {
                    Column {
                        Spacer(
                            Modifier.height(10.dp)
                        )
                        Box(
                            Modifier
                                .clip(
                                    RoundedCornerShape(10.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = MaterialTheme.colorScheme.tertiary,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                        ) {
                            Text(
                                text = tag,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Spacer(
                        Modifier.width(15.dp)
                    )
                }
            }
        }
    }
}

private class ProductPreviewProvider : PreviewParameterProvider<ProductUI> {

    override val values = sequenceOf(
        ProductUI(
            id = 1,
            name = "PlayStation 5",
            time = 1724400000,
            tags = listOf("Игровая приставка", "Акция", "Распродажа"),
            amount = 3
        ),
        ProductUI(
            id = 2,
            name = "Second product",
            time = 1724400000,
            tags = listOf("tag1", "tag2", "tag3"),
            amount = 5
        ),
        ProductUI(
            id = 3,
            name = "Third product",
            time = 1724400000,
            tags = listOf("tag1", "tag2", "tag3"),
            amount = 1
        ),
        ProductUI(
            id = 4,
            name = "Fourth product",
            time = 1724400000,
            tags = listOf("tag1", "tag2", "tag3"),
            amount = 7
        )
    )
}
