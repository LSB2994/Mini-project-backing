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
import androidx.compose.foundation.layout.wrapContentSize
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
    val user by remember { mutableStateOf(vm.dataUser) }
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
            .clip(shape = RoundedCornerShape(15.dp))
            .background(brush = backgroundBlur)
            .size(width = 353.dp, height = 120.dp)
            .border(2.dp, brush, RoundedCornerShape(15.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    if (balanceVisible) {
                        Box(
                            modifier = Modifier.wrapContentSize().padding(5.dp),
                            Alignment.CenterStart
                        ) {
                            Text(
                                text = "\$ ${user.balance}",
                                color = Color.White,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Start,
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .blur(10.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White.copy(0.10f))
                                .padding(5.dp)
                                .wrapContentSize(), Alignment.CenterStart
                        ) {
                            Text(
                                text = "\$ ${vm.dataUser.balance}",
                                textAlign = TextAlign.Start,
                                color = Color.White,
                                fontSize = 18.sp,
                            )
                        }
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(width = 40.dp, height = 30.dp)
                            .padding(start = 5.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.White.copy(0.20f))
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
                Row(
                    modifier = Modifier.padding(top = 5.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 50.dp, height = 16.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color(0xFF34C2FF)),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            fontSize = 10.sp,
                            color = Color.White,
                            text = "Default",
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(width = 40.dp, height = 16.dp)
                            .padding(start = 3.dp), Alignment.Center
                    ) {
                        Text(
                            text = "Saving",
                            color = Color.White,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.size(width = 240.dp, height = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),
                    ) {
                        Row( // Row to position image and text horizontally
                            verticalAlignment = Alignment.CenterVertically // Center vertically within the Row
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_receive),
                                contentDescription = "",
                                modifier = Modifier.size(width = 20.dp, height = 20.dp)
                            )
                            Text(
                                text = "Received money",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(start = 2.dp)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),
                    ) {
                        Row( // Row to position image and text horizontally
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_pay),
                                contentDescription = "",
                                modifier = Modifier.size(width = 20.dp, height = 20.dp)
                            )
                            Text(
                                text = "Send money",
                                color = Color.White,
                                modifier = Modifier.padding(
                                    start = 2.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}