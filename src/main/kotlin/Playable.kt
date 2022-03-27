interface Playable {
    var frames: MutableList<String>
    var beforeFrames: MutableList<String>
    var delayFrames: Float
    var imageIndex: String
    fun play()
    fun stop()
    fun pause()
}