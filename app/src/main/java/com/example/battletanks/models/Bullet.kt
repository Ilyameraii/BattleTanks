package com.example.battletanks.models

import android.view.View
import com.example.battletanks.enums.Direction

class Bullet(
    val view: View,
    val direction: Direction,
    val tank: Tank,
    var canMoveFurther: Boolean = true
)