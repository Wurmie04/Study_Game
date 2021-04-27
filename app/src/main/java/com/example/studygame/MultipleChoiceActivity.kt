package com.example.studygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

//Multiple Choice Game
class MultipleChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val testLinear = LinearLayout(this)
        testLinear.orientation = LinearLayout.VERTICAL

        val testText = TextView(this)

        testText.textSize = 20.0F
        testText.text = "hi"

        testLinear.addView(testText)

        setContentView(testLinear)
        //setContentView(R.layout.activity_multiple_choice)
    }
}