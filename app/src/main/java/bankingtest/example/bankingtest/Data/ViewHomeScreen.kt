package bankingtest.example.bankingtest.Data

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.lifecycle.ViewModel
import com.example.bankingtest.R
// saving
enum class Money {
    DEFAULT,
    SAVING
}
// edit home
enum class SettingsOption {
    THEMES, DARK_MODE, LANGUAGE
}
// user data
data class User(
    val name: String,
    val balance: Float,
    val img:Int
)
// finance card
data class FinanceCard(
    val id:Int? = null,
    val title:String? = null,
    val description:String? = null,
    val img:Int? = null,
)
class ViewHomeScreen:ViewModel() {
    var isClose by mutableStateOf(false)
    var isVisible by mutableStateOf(false)
    val dataUser by mutableStateOf(User("Leng Sambath",34.65f, R.drawable.me))
    fun getAllFinanceCard():List<FinanceCard>{
        return listOf(
            FinanceCard(
                id = 1,
                title = "Accounts",
                description = "Your balance",
                img = R.drawable.ic_acc
            ),
            FinanceCard(
                id = 2,
                title = "Pay bills",
                description = "School, Shop, etc",
                img = R.drawable.ic_bills
            ),
            FinanceCard(
                id = 3,
                title = "Transfer",
                description = "Send money",
                img = R.drawable.ic_transfer
            ),
            FinanceCard(
                id = 4,
                title = "Favorites",
                description = "Users",
                img = R.drawable.ic_fav
            ),
            FinanceCard(
                id = 5,
                title = "ABA Scan",
                description = "School, Shop, etc",
                img = R.drawable.ic_scan
            ),
            FinanceCard(
                id = 6,
                title = "Service",
                description = "Your services",
                img = R.drawable.ic_service
            )
        )
    }
}