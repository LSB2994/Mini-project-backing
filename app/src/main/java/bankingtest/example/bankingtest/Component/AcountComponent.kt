package bankingtest.example.bankingtest.Component

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import bankingtest.example.bankingtest.Data.ViewHomeScreen
import com.example.bankingtest.R
@Preview
@Composable
fun AccountComponent() {
    val vm: ViewHomeScreen = viewModel()
    val user by remember { mutableStateOf(vm.dataUser) }
    var showNotificationDialog by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        // image user for profile
        Row {
            Image(
                painterResource(id = user.img),
                contentDescription = "Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.White, CircleShape)
            )
            // user name and view profile
            Column(
                modifier = Modifier.padding(start = 14.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                // user name
                Text(
                    text = "Hello, ${user.name.takeLast(7)} !",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                // view profile
                Text(
                    text = "View Profile",
                    fontSize = 11.sp,
                    color = Color.White
                )
            }
        }
        // notification and qr code
        Row(
            modifier = Modifier,
        ) {
            // Notification icon
            Image(painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "notification",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(20.dp)
                    .clickable { showNotificationDialog = true }
            )
            if (showNotificationDialog) {
                // FullScreenDialog example commented out
                // FullScreenDialog(
                //     onDismiss = {
                //         showNotificationDialog = false
                //     }
                // )
            }
            // QR code icon
            Image(painter = painterResource(id = R.drawable.ic_bk),
                contentDescription = "",
                modifier = Modifier
                .size(20.dp)
                .clickable { vm.isClose = true })
            if (vm.isClose) {
                FullScreenDialog(
                    onDismiss = {
                        vm.isClose = false
                    }
                )
            }
        }

    }
}
