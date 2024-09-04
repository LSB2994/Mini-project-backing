package bankingtest.example.bankingtest.Component

import android.app.Person
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import bankingtest.example.bankingtest.Data.FinanceCard
import bankingtest.example.bankingtest.Data.ViewHomeScreen

@Preview
@Composable
fun FinanceCardComponent() {
    // color border main card
    val brush = Brush.horizontalGradient(
        listOf(
            Color(0xFFFF3D7C).copy(0.38f),
            Color(0xFFD027B5).copy(0.79f),
            Color(0xFFB623D5).copy(0.45f),
            Color(0xFF941FFF).copy(0.48f)
        )
    )
    // color background main card
    val backgroundBlur =
        Brush.horizontalGradient(listOf(Color.White.copy(0.35f), Color.White.copy(0.06f)))
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp))
            .background(brush = backgroundBlur)
            .border(2.dp, brush, RoundedCornerShape(15.dp))
    ) {
        EachFinanceCard()
    }
}

@Preview
@Composable
fun EachFinanceCard() {
    val card: ViewHomeScreen = viewModel()
    val colorTittle = Brush.horizontalGradient(
        listOf(
            Color(0xFF6F8BB2),
            Color(0xFF202F45),
        )
    )
    Box(modifier = Modifier.height(240.dp)) {
        LazyVerticalGrid(
            userScrollEnabled = false,
            columns = GridCells.Fixed(3),
            modifier = Modifier.wrapContentSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(card.getAllFinanceCard().size) { item ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    modifier = Modifier
//                    .fillMaxWidth()
                        .size(width = 100.dp, height = 100.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(Color(0xFFEBF2F9))
                        .border(2.dp, Color.White.copy(0.0f), RoundedCornerShape(15.dp))
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End,
                    ) {
                        card.getAllFinanceCard()[item].img?.let {
                            painterResource(id = it)
                        }?.let {
                            Image(
                                painter = it,
                                contentDescription = "finance icon",
                                modifier = Modifier
                                    .size(28.dp)
                                    .padding(2.dp)
                            )
                        }
                    }
                    Column {
                        Text(text = card.getAllFinanceCard()[item].title.toString(),
                            fontWeight = FontWeight.Bold,
                            style = TextStyle(brush = colorTittle),
                            fontSize = 15.sp,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                        Text(
                            text = card.getAllFinanceCard()[item].description.toString(),
                            fontSize = 10.sp,
                            color = Color(0xFF31456A),
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                }
            }
        }
    }
}