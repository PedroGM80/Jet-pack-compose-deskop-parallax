import CharacterData.Companion.directionAngle
import CharacterData.Companion.speed
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.dp



@ExperimentalComposeUiApi
@Composable
fun keyBoard(aCharacterData: CharacterData): Float {

    var offsetX by remember { mutableStateOf(0f) }
    val requester = remember { FocusRequester() }
    Box(
        Modifier
            .size(width = 600.dp, height = 600.dp)
            .onKeyEvent {
                if (it.key == Key.DirectionRight) {
                    aCharacterData.play()
                    offsetX -= 5
                    directionAngle = 0
                    speed = 1
                } else if (it.key == Key.DirectionLeft) {
                    if (offsetX <= 0) {
                        aCharacterData.play()
                        offsetX += 5
                        directionAngle = 180
                        speed = 1
                    } else {
                        offsetX = -0.5F
                    }
                }
                if ((it.key == Key.DirectionLeft && it.type == KeyEventType.KeyUp) || (it.key == Key.DirectionRight && it.type == KeyEventType.KeyUp)) {
                    speed = 0
                    aCharacterData.pause()
                }
                true
            }
            .focusRequester(requester)
            .focusable()
    )
    LaunchedEffect(Unit)
    { requester.requestFocus() }
    return offsetX
}
