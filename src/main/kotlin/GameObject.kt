class CharacterData(

    override var frames: MutableList<String>,
    override var delayFrames: Float,
    override var imageIndex: String, override var beforeFrames: MutableList<String>
) : Playable {
    companion object {
        var directionAngle = 0
        var speed = 0
    }

    override fun play() {
        frames = beforeFrames
        delayFrames = 1.1F
    }

    override fun stop() {
        frames = mutableListOf(imageIndex)
        delayFrames = 0.1F
    }

    override fun pause() {
        frames = mutableListOf(beforeFrames[0])
        delayFrames = 0.1F
    }
}
