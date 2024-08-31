package bankingtest.example.bankingtest.Data

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bankingtest.R

data class User(
    val name: String,
    val balance: Float,
    val img:Int
)
class ViewHomeScreen:ViewModel() {
    val dataUser by mutableStateOf(User("Leng Sambath",34.65f, R.drawable.me))
}