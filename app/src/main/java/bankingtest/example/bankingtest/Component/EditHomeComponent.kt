package bankingtest.example.bankingtest.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun EditHomeComponent() {
    var showDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { showDialog = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text(
                text = "Edit Home",
                color = Color.Black,
                fontSize = 14.sp,
            )
        }
        if (showDialog){
            ModalBottomSheet(onDismissRequest = { showDialog = false },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                containerColor = Color(0xFFF8F8F8)
            ) {
                Column(
                    modifier = Modifier.padding(bottom = 40.dp),
                ) {
                    AppearanceDialog()
                    Button(
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.buttonColors(Color(0xFF00468B)),
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(end = 20.dp),
                    ) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}