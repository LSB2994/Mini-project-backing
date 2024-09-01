package bankingtest.example.bankingtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bankingtest.example.bankingtest.Component.AccountComponent
import bankingtest.example.bankingtest.Component.EditHomeComponent
import bankingtest.example.bankingtest.Component.FinanceCardComponent
import bankingtest.example.bankingtest.Component.NewsSlideComponent
import bankingtest.example.bankingtest.Component.WalletCardComponent
import bankingtest.example.bankingtest.Data.ViewHomeScreen
import bankingtest.example.bankingtest.ui.theme.BankingTestTheme
import com.example.bankingtest.R
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

@Preview
@Composable
fun HomeScreen() {
    val vm: ViewHomeScreen = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00468B))
    ) {
        Column(
            Modifier.padding(14.dp)
        ) {
            // Account Section
            AccountComponent()
            Spacer(modifier = Modifier.height(20.dp))
            //wallet section
            WalletCardComponent()
            //Finance section
            Spacer(modifier = Modifier.height(20.dp))
            FinanceCardComponent()
            //News Slide Section
            Spacer(modifier = Modifier.height(20.dp))
            NewsSlideComponent()
            // Edit home button sheet
            Spacer(modifier = Modifier.height(20.dp))
            EditHomeComponent()
        }
    }
}