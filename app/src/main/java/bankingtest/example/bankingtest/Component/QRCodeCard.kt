package bankingtest.example.bankingtest.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingtest.R
import com.lightspark.composeqr.QrCodeView

@Preview
@Composable
fun QRCodeCard() {
    Box(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.qrbg),
            contentDescription = "",
            modifier = Modifier.size(400.dp)
        )
        QrCodeView(
            data = "https://pay.ababank.com/XXZZZbrU2Kd72q2RA",
            modifier = Modifier.size(200.dp).padding(top = 165.dp).align(Alignment.TopCenter)
        )
    }
}