import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@ExperimentalComposeUiApi
@Composable
@Preview
fun App() {

    val sourceAnimation = mutableListOf(
        "asset/character/frames/Walk/sprite_0.png",
        "asset/character/frames/Walk/sprite_1.png",
        "asset/character/frames/Walk/sprite_2.png",
        "asset/character/frames/Walk/sprite_3.png",
        "asset/character/frames/Walk/sprite_4.png",
        "asset/character/frames/Walk/sprite_5.png",
        "asset/character/frames/Walk/sprite_6.png",
        "asset/character/frames/Walk/sprite_7.png",
        "asset/character/frames/Walk/sprite_8.png",
        "asset/character/frames/Walk/sprite_9.png"
    )
    val aCharacterData = CharacterData(
        sourceAnimation,
        0.5F,
        "asset/character/frames/Walk/sprite_0.png", sourceAnimation
    )
    val offsetX = keyBoard(aCharacterData)
    val aImage = "asset/background/background.png"
    val bImage = "asset/background/foreground.png"

    parallaxHorizontalScroll(aImage, offsetX, 10)

    character(aCharacterData)
    parallaxHorizontalScroll(bImage, offsetX, 10)

}


@ExperimentalComposeUiApi
fun main() = application {
    Window(
        icon = painterResource("asset/icons/Zombie.ico"),
        title = "Parallax Example",
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        App()
    }
}
