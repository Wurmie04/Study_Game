package com.example.studygame

import android.app.ActionBar
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import org.jetbrains.anko.button
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Online says to use Fragments or ViewAnimator. Will learn later
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Try in DSL format :/


        //Main Menu Layout
        verticalLayout{
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            textView("Best Game"){
                textSize = 35.0F
                setTextColor(Color.RED)
                setBackgroundColor(Color.BLUE)
                gravity = Gravity.CENTER
                setPadding(0,20, 0,0)
            }
            button("Quiz Game"){
                textSize = 20.0F
                setOnClickListener{

                }
            }
            button("Jeapardy"){
                textSize = 20.0F
                setOnClickListener{

                }
            }
            button("Memory Game"){
                textSize = 20.0F
                setOnClickListener{

                }
            }
        }
    /*
        //Linear Layouts
        val menuItems = LinearLayout(this)
        val playItems = LinearLayout(this)

        //declare menu items
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

        val goBackPlay = Button(this)

        //set game cards as invisible and disabled
        MemoryGameButton.setEnabled(false)
        MemoryGameButton.setVisibility(View.GONE)
        JeapordyButton.setEnabled(false)
        JeapordyButton.setVisibility(View.GONE)
        QuizCard.setEnabled(false)
        QuizCard.setVisibility(View.GONE)
        howTo.setEnabled(false)
        howTo.setVisibility(View.GONE)
        goBackPlay.setEnabled(false)
        goBackPlay.setVisibility(View.GONE)

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
        goBackPlay.text = "Go Back"
        goBackPlay.textSize = 20.0F

        //Display
        menuItems.addView(gameName)
        menuItems.addView(playButton)
        menuItems.addView(aboutButton)
        menuItems.addView(quitButton)

        playItems.addView(JeapordyButton)
        playItems.addView(MemoryGameButton)
        playItems.addView(QuizCard)
        playItems.addView(goBackPlay)

        setContentView(menuItems)

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
            goBackPlay.setVisibility(View.VISIBLE)
            goBackPlay.setEnabled(true)

            setContentView(playItems)
        }

        goBackPlay.setOnClickListener{
            playButton.setVisibility(View.VISIBLE)
            playButton.setEnabled(true)
            aboutButton.setVisibility(View.VISIBLE)
            aboutButton.setEnabled(true)
            quitButton.setVisibility(View.VISIBLE)
            quitButton.setEnabled(true)

            JeapordyButton.setVisibility(View.GONE)
            JeapordyButton.setEnabled(false)
            QuizCard.setVisibility(View.GONE)
            QuizCard.setEnabled(false)
            MemoryGameButton.setVisibility(View.GONE)
            MemoryGameButton.setEnabled(false)
            goBackPlay.setVisibility(View.GONE)
            goBackPlay.setEnabled(false)

            setContentView(menuItems)
        }

        //Go To Multiple Choice Scene
        QuizCard.setOnClickListener{
            val intent = Intent(this,MultipleChoiceActivity::class.java)
            startActivity(intent)
        }
        MemoryGameButton.setOnClickListener{

        }
        */

    //setContentView(R.layout.activity_main)
    }
}