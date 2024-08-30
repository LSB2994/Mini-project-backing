package bankingtest.example.bankingtest.Data

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class ViewHomeScreen:ViewModel() {
    val name by mutableStateOf("Leng Sambath")

}