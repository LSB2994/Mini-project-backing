package bankingtest.example.bankingtest.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun AppearanceDialog() {
    Column(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Text(text = "Appearance")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FilledTonalButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCBE5FF)),
                shape = RoundedCornerShape(5.dp)
            ){
                Text(text = "Themes")
            }
            FilledTonalButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(text = "Dark Mode")
            }
            FilledTonalButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(text = "Language")
            }
        }
    }
}