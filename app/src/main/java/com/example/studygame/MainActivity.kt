package com.example.studygame

import android.app.ActionBar
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
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
            setBackgroundColor(Color.parseColor("#BCB8CE"))
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            textView("Study Buddy"){
                textSize = 35.0F
                Typeface.BOLD
                setTextColor(Color.parseColor("#D5DDEF"))
                setBackgroundColor(Color.parseColor("#4C394F"))
                gravity = Gravity.CENTER
                setPadding(0,20, 0,20)
            }
            //Quiz Card Game
            button("Quiz Game"){
                textSize = 20.0F
                setTextColor(Color.parseColor("#2E1A1E"))
                setBackgroundColor(Color.parseColor("#917898"))
                setOnClickListener{
                    startActivity<MultipleChoiceActivity>("id" to 5)
                }
            }
            /*button("Jeapardy"){
                textSize = 20.0F
                setOnClickListener{

                }
            }
            */
            button("Memory Game"){
                textSize = 20.0F
                setTextColor(Color.parseColor("#2E1A1E"))
                setBackgroundColor(Color.parseColor("#917898"))
                setOnClickListener{
                    startActivity<MemoryGameActivity>("id" to 5)
                }

            }
        }
    //setContentView(R.layout.activity_main)
    }
}