package bankingtest.example.bankingtest.Component

import DarkModeButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import bankingtest.example.bankingtest.Data.SettingsOption
import com.example.bankingtest.R

@Composable
fun AppearanceDialog(darkMode:Boolean) {
    var selectedOption by remember { mutableStateOf(SettingsOption.THEMES) }
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(15.dp)
    ) {
        Row {
            Button(
                onClick = { selectedOption = SettingsOption.THEMES },
                modifier = Modifier
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedOption == SettingsOption.THEMES)
                        Color(0xFFCBE5FF)
                    else Color(0xFFE4E4E4)
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("Themes", color = if (selectedOption == SettingsOption.THEMES)
                    Color.Black
                else Color(0xFFA0A0A0),
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { selectedOption = SettingsOption.DARK_MODE },
                modifier = Modifier
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedOption == SettingsOption.DARK_MODE)
                        Color(0xFFCBE5FF)
                    else Color(0xFFE4E4E4)
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("Dark Mode", color = if (selectedOption == SettingsOption.DARK_MODE)
                    Color.Black
                else Color(0xFFA0A0A0),
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { selectedOption = SettingsOption.LANGUAGE },
                modifier = Modifier
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedOption == SettingsOption.LANGUAGE)
                        Color(0xFFCBE5FF)
                    else Color(0xFFE4E4E4)
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("Language", color = if (selectedOption == SettingsOption.LANGUAGE)
                    Color.Black
                else Color(0xFFA0A0A0),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        when (selectedOption) {
            SettingsOption.THEMES -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.wrapContentWidth(),
                ) {
                    items(4) {
                        Box(
                            modifier = Modifier
                                .background(Color.White,
                                    shape = RoundedCornerShape(10.dp))
                                .padding(15.dp)
                        ) {
                            Image(
                                painter = painterResource(
                                    id = R.drawable.img
                                ),
                                contentDescription = "",
                                modifier = Modifier.wrapContentWidth()
                            )
                        }
                    }
                }
            }
            SettingsOption.DARK_MODE -> {
                // Show Dark Mode content here
                DarkModeButton(darkMode)
            }
            SettingsOption.LANGUAGE -> {
                // Show Language content here
                CountryList {}
            }
        }
    }
}
@Composable
fun CountryList(onCountrySelected: (String) -> Unit) {
    val countries = listOf(
        Pair("Cambodia", "\uD83C\uDDF0\uD83C\uDDED"),
        Pair("UK", "\uD83C\uDDEC\uD83C\uDDE7"),
        Pair("China", "\uD83C\uDDE8\uD83C\uDDF3"),
    )
    LazyColumn() {
        items(countries) { (country, flag) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp)
                    .clickable {
                        onCountrySelected(country)
                    }
            ) {
                Text(
                    text = flag,
                    modifier = Modifier.padding(end = 16.dp),
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
               Text(text = country)
            }
        }
    }
}
