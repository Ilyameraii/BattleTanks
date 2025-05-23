package com.example.battletanks

object GameCore {
    @Volatile
    private var isPlay = false
    fun startOrPauseGame() {
        isPlay = !isPlay
    }

    fun isPlaying() = isPlay

    fun pauseTheGame() {
        isPlay = false
    }
}