package com.example.battletanks

import android.app.Activity
import android.view.View
import android.view.animation.AnimationUtils
import com.example.battletanks.activites.SCORE_REQUEST_CODE
import com.example.battletanks.activites.ScoreActivity
import com.example.battletanks.activites.binding

class GameCore(private val activity: Activity) {
    @Volatile
    private var isPlay = false
    private var isPlayerOrBaseDestroyed = false
    private var isPlayerWin = false

    fun startOrPauseTheGame() {
        isPlay = !isPlay
    }

    fun isPlaying() = isPlay && !isPlayerOrBaseDestroyed && !isPlayerWin

    fun pauseTheGame() {
        isPlay = false
    }

    fun destroyPlayerOrBase() {
        isPlayerOrBaseDestroyed = true
        pauseTheGame()
        animateEndGame()
    }

    fun playerWon(score:Int){
        isPlayerWin = true
        activity.startActivityForResult(
            ScoreActivity.createIntent(activity,score),
            SCORE_REQUEST_CODE
        )
    }

    private fun animateEndGame() {
        activity.runOnUiThread {
            binding.gameOverText.visibility = View.VISIBLE
            val slideUp = AnimationUtils.loadAnimation(activity, R.anim.slide_up)
            binding.gameOverText.startAnimation(slideUp)
        }
    }
}