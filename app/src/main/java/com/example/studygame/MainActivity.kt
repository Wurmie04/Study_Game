package com.example.studygame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Online says to use Fragments or ViewAnimator. Will learn later
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //declare menu Items
        val menuItems = LinearLayout(this)
        val playItems = LinearLayout(this)
        val aboutButton = Button(this)
        val gameName = TextView(this)
        val quitButton = Button(this)
        menuItems.orientation = LinearLayout.VERTICAL
        playItems.orientation = LinearLayout.VERTICAL

        //Game Choose Items
        val MemoryGameButton = Button(this)
        val JeapordyButton = Button(this)
        val QuizCard = Button(this)
        val howTo = TextView(this)

        val goBack = Button(this)

        //set game cards as invisible and disabled
        MemoryGameButton.setEnabled(false)
        MemoryGameButton.setVisibility(View.GONE)
        JeapordyButton.setEnabled(false)
        JeapordyButton.setVisibility(View.GONE)
        QuizCard.setEnabled(false)
        QuizCard.setVisibility(View.GONE)
        howTo.setEnabled(false)
        howTo.setVisibility(View.GONE)
        goBack.setEnabled(false)
        goBack.setVisibility(View.GONE)

        //create Game Name at top of screen
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

        //create About/Instructions/How To Button
        aboutButton.text = "How To"
        aboutButton.textSize = 20.0F

        //create Quit Button
        quitButton.text = "Quit"
        quitButton.textSize = 20.0F

        //create MemoryGame Button
        MemoryGameButton.text = "Memory Game"
        MemoryGameButton.textSize = 20.0F

        //create Jeapordy Button
        JeapordyButton.text = "Jeapardy"
        JeapordyButton.textSize = 20.0F

        //create Quiz Game Button
        QuizCard.text = "Quiz Card"
        QuizCard.textSize = 20.0F

        //create go back button
        goBack.text = "Go Back"
        goBack.textSize = 20.0F

        //Display
        menuItems.addView(gameName)
        menuItems.addView(playButton)
        menuItems.addView(aboutButton)
        menuItems.addView(quitButton)
        playItems.addView(JeapordyButton)
        playItems.addView(MemoryGameButton)
        playItems.addView(QuizCard)
        playItems.addView(goBack)

        setContentView(menuItems)
        //get value from input box if we ever have one
        //playButton.id = R.id.name


        //click play button
        playButton.setOnClickListener{
            playButton.setVisibility(View.GONE)
            playButton.setEnabled(false)
            aboutButton.setVisibility(View.GONE)
            aboutButton.setEnabled(false)
            quitButton.setVisibility(View.GONE)
            quitButton.setEnabled(false)

            JeapordyButton.setVisibility(View.VISIBLE)
            JeapordyButton.setEnabled(true)
            QuizCard.setVisibility(View.VISIBLE)
            QuizCard.setEnabled(true)
            MemoryGameButton.setVisibility(View.VISIBLE)
            MemoryGameButton.setEnabled(true)
            goBack.setVisibility(View.VISIBLE)
            goBack.setEnabled(true)

            setContentView(playItems)
        }

        goBack.setOnClickListener{
            playButton.setVisibility(View.VISIBLE)
            playButton.setEnabled(true)
            aboutButton.setVisibility(View.VISIBLE)
            aboutButton.setEnabled(true)
            quitButton.setVisibility(View.VISIBLE)
            quitButton.setEnabled(true  )

            JeapordyButton.setVisibility(View.GONE)
            JeapordyButton.setEnabled(false)
            QuizCard.setVisibility(View.GONE)
            QuizCard.setEnabled(false)
            MemoryGameButton.setVisibility(View.GONE)
            MemoryGameButton.setEnabled(false)
            goBack.setVisibility(View.GONE)
            goBack.setEnabled(false)

            setContentView(menuItems)
        }

        //Go To Multiple Choice Scene
        QuizCard.setOnClickListener{
            val intent = Intent(this,MultipleChoiceActivity::class.java)
            startActivity(intent)
        }
    //setContentView(R.layout.activity_main)
    }
}