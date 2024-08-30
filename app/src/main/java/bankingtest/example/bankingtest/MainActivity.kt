package bankingtest.example.bankingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bankingtest.example.bankingtest.Component.AccountComponent
import bankingtest.example.bankingtest.Data.ViewHomeScreen
import bankingtest.example.bankingtest.ui.theme.BankingTestTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetBarColor(color = Color(0xFF00468B))
                    HomeScreen()
        }
    }
}

// set bar color
@Composable
private fun SetBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(vm: ViewHomeScreen = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00468B))
    ) {
        Column(
            Modifier.padding(14.dp)
        ) {
            // Account Section
            AccountComponent(vm)
//        CardSection()
            Spacer(modifier = Modifier.height(16.dp))
//        FinanceSection()
//        CurreniesSection()
        }
    }
}