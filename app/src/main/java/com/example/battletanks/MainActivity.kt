package com.example.battletanks

import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import com.example.battletanks.Direction.UP
import com.example.battletanks.Direction.DOWN
import com.example.battletanks.Direction.LEFT
import com.example.battletanks.Direction.RIGHT
import com.example.battletanks.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        supportActionBar?.title = "Menu"
    }
    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
         menuInflater.inflate(R.menu.settings,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        return when(item.itemId){
            R.id.menu_settings  ->{
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KEYCODE_DPAD_UP -> move(UP)
            KEYCODE_DPAD_DOWN -> move(DOWN)
            KEYCODE_DPAD_LEFT -> move(LEFT)
            KEYCODE_DPAD_RIGHT -> move(RIGHT)
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun move(direction: Direction) {
        when (direction) {
            UP -> {
                binding.myTank.rotation = 0f
                (binding.myTank.layoutParams as FrameLayout.LayoutParams).topMargin += -50
            }

            DOWN -> {
                binding.myTank.rotation = 180f
                (binding.myTank.layoutParams as FrameLayout.LayoutParams).topMargin += 50
            }

            LEFT -> {
                binding.myTank.rotation = 270f
                (binding.myTank.layoutParams as FrameLayout.LayoutParams).leftMargin -= 50
            }

            RIGHT -> {
                binding.myTank.rotation = 90f
                (binding.myTank.layoutParams as FrameLayout.LayoutParams).leftMargin += 50
            }
        }
        binding.container.removeView(binding.myTank)
        binding.container.addView(binding.myTank)
    }
}