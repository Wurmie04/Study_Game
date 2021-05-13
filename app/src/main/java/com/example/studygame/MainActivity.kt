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
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Online says to use Fragments or ViewAnimator. Will learn later
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


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
            //Quiz Card Game
            button("Quiz Game"){
                textSize = 20.0F
                setOnClickListener{
                    startActivity<MultipleChoiceActivity>("id" to 5)
                }
            }
            /*button("Jeapardy"){
                textSize = 20.0F
                setOnClickListener{

                }
            }

            button("Memory Game"){
                textSize = 20.0F
                setOnClickListener{

                }
             */
        }
    //setContentView(R.layout.activity_main)
    }
}