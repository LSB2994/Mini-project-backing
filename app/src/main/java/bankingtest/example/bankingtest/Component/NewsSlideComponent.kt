package bankingtest.example.bankingtest.Component
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.bankingtest.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue


@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun NewsSlideComponent() {
    val pagerState = rememberPagerState(initialPage = 0)
    val imageSlider = listOf(painterResource(id = R.drawable.a),
        painterResource(id = R.drawable.pchum),
        painterResource(id = R.drawable.b)
    )
    Text(
        text = "News and Information",
        color = Color.White,
        fontSize = 20.sp,
    )
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(1000)
            if (!pagerState.isScrollInProgress) {
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pagerState.pageCount)
                )
            } else {
                delay(1000)
            }
        }
    }
    Box(modifier = Modifier.padding(top = 10.dp)) {
        HorizontalPager(
            count = imageSlider.size,
            state = pagerState,
            itemSpacing = 0.dp,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
                    .fillMaxWidth() // Make each card fill the pager width
            ) {
                Image(
                    painter = imageSlider[page],
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(154.dp)
                )
            }
        }
        // Position the indicator at the bottom center, on top of the pager
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            activeColor = Color.White
        )
    }
}