import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun parallaxHorizontalScroll(aImage: String, offsetX: Float, numberScene: Int) {
    Row(
        modifier = Modifier
            .width(800.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        Row {
            repeat(numberScene) {
                Box(
                    modifier = Modifier
                        .absoluteOffset(x = offsetX.dp)
                ) {
                    val image = painterResource(aImage)
                    painterResource("asset/background/foreground.png")
                    Image(
                        painter = image,
                        contentDescription = "",
                        contentScale = ContentScale.FillHeight,
                    )
                }
            }
        }
    }
}
