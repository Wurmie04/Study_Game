package com.example.studygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val menuItems = LinearLayout(this)
        menuItems.orientation = LinearLayout.VERTICAL

        //create Game Name at top of screen
        val gameName = TextView(this)
        gameName.text = "Best Game"
        gameName.textSize = 35.0F
        gameName.setTextColor(Color.RED)
        gameName.setBackgroundColor(Color.BLUE)

        gameName.gravity = Gravity.TOP or Gravity.CENTER
        gameName.setPadding(0,20, 0,0)

        //create play button
        val playButton = Button(this)
        playButton.text = "Play"
        playButton.textSize= 20.0F

        //get value from input box if we ever have one
        //playButton.id = R.id.name
        //click play button
        playButton.setOnClickListener{

        }

        //create About/Instructions/How To Button
        val aboutButton = Button(this)
        aboutButton.text = "How To"
        aboutButton.textSize = 20.0F

        //create Quit Button
        val quitButton = Button(this)
        quitButton.text = "Quit"
        quitButton.textSize = 20.0F

        //Display
        menuItems.addView(gameName)
        menuItems.addView(playButton)
        menuItems.addView(aboutButton)
        menuItems.addView(quitButton)
        setContentView(menuItems)
        //setContentView(R.layout.activity_main)
    }
}