package com.example.battletanks

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.media.MediaFormat.KEY_LEVEL
import com.example.battletanks.models.Element
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.core.content.edit

class LevelStorage(val context: Context) {
    private val prefs = (context as Activity).getPreferences(MODE_PRIVATE)
    private val gson = Gson()

    fun saveLevel(elementsOnContainer: List<Element>) {
        prefs.edit() {
            putString(KEY_LEVEL, Gson().toJson(elementsOnContainer))
        }
    }

    fun loadLevel(): List<Element>? {
        val levelJson = prefs.getString(KEY_LEVEL, null) ?: return null
        val type = object : TypeToken<List<Element>>() {}.type
        return gson.fromJson<List<Element>>(levelJson, type)?.map { element ->
            Element(
                material = element.material,
                coordinate = element.coordinate
            )
        }
    }
}