package com.example.studygame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.button
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout
import org.w3c.dom.Text

//Multiple Choice Game
class MultipleChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Create list of Questions and Answers
        val AnimeList : MutableList<String> = mutableListOf("Hello")
        val AnimeListAnswers : MutableList<String> = mutableListOf("hi")

        val randomWords : MutableList<String> = mutableListOf("Chinese", "Cabbage", "Extra Gum")
        //Choose which list to use
        verticalLayout{
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            textView("Choose Category"){
                textSize = 35.0F
                setTextColor(Color.RED)
                setBackgroundColor(Color.BLUE)
                gravity = Gravity.CENTER
                setPadding(0,20, 0,0)
            }
            //Quiz Card Game
            button("Computer Science"){
                textSize = 20.0F
                setOnClickListener{

                }
            }
            button("Animals"){
                textSize = 20.0F
                setOnClickListener{

                }
            }
            button("Anime"){
                textSize = 20.0F
                setOnClickListener{

                }
            }
        }
        //setContentView(R.layout.activity_multiple_choice)
    }
}