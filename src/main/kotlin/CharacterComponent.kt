import CharacterData.Companion.directionAngle
import CharacterData.Companion.speed
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun character(characterData: CharacterData) {
    Modifier.zIndex(-1f)
    val infiniteTransition = rememberInfiniteTransition()
    val frames = characterData.frames
    var xScale = -1f
    var image: Painter
    image = painterResource(characterData.imageIndex)
    val anima by infiniteTransition.animateFloat(
        initialValue = 0.0F,
        targetValue = frames.size.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween((characterData.delayFrames * 1000).toInt(), easing = LinearEasing)
        )
    )
    Box(
        Modifier
            .padding(20.dp)
            .offset(280.dp, 240.dp)
            .clip(shape = RoundedCornerShape(30.dp))
            .size(width = 140.dp, height = 160.dp)
            .background(Color.Transparent)
            .scale(scaleX = xScale, scaleY = 1f)

    ) {
        if (directionAngle == 0) {
            xScale = -1f
        } else if (directionAngle == 180) {
            xScale = 1f
        }
        (if (speed == 0) {
            painterResource(characterData.frames[characterData.frames.size - 1])
        } else {
            painterResource(characterData.frames[anima.toInt()])
        }).also { image = it }
        Image(
            modifier = Modifier.scale(scaleX = xScale, scaleY = 1f),
            painter = image,
            contentDescription = "my character",
            contentScale = ContentScale.Fit,
            alignment = Center,
        )
    }
}

