package bankingtest.example.bankingtest.Component

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import bankingtest.example.bankingtest.Data.ViewHomeScreen
import com.example.bankingtest.R

@Preview
@Composable
fun WalletCardComponent() {
    val vm: ViewHomeScreen = viewModel()
    var user by remember { mutableStateOf(vm.dataUser) }
    val brush = Brush.horizontalGradient(
        listOf(
            Color(0xFFFF3D7C).copy(0.38f),
            Color(0xFFD027B5).copy(0.79f),
            Color(0xFFB623D5).copy(0.45f),
            Color(0xFF941FFF).copy(0.48f)
        )
    )
    val backgroundBlur =
        Brush.horizontalGradient(listOf(Color.White.copy(0.35f), Color.White.copy(0.06f)))
    var balanceVisible by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .background(brush = backgroundBlur)
            .size(width = 353.dp, height = 114.dp)
            .border(2.dp, brush, RoundedCornerShape(0.dp))
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(10.dp)
            ) {
                if (balanceVisible) {
                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 40.dp),
                        Alignment.Center
                    ){
                        Text(
                            text = "\$ ${user.balance}",
                            color = Color.White,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier.blur(radius = 0.dp)
                            .blur(7.dp)
//                            .padding(end = 5.dp)
                            .background(Color.White.copy(0.03f))
                            .size(width = 100.dp, height = 40.dp),
                        Alignment.Center
                    ){
                        Text(
                            text = "\$ ${vm.dataUser.balance}",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 18.sp,
                        )
                    }
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White.copy(0.05f))
                        .clickable { balanceVisible = !balanceVisible },
                ) {
                    Icon(
                        imageVector = if (balanceVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (balanceVisible) "Hide balance" else "Show balance",
                        modifier = Modifier.size(20.dp),
                        tint = Color.White
                    )
                }
            }
        }

    }
}