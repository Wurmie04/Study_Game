package com.example.studygame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_multiple_choice.*
import org.jetbrains.anko.*
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
                    startGame()
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

    private fun startGame() {
        //delete the previous menu
        linearLayout().removeAllViews()

        //bring up the xml design view
        setContentView(R.layout.activity_multiple_choice)

        //create score and buttons
        verticalLayout{
            gravity = Gravity.CENTER
            //score
            textView("0"){
                textSize = 20.0F
                setTextColor(Color.BLACK)
                setBackgroundColor(Color.WHITE)
                gravity = Gravity.CENTER
                //setPadding(0,10, 0,0)
            }
            //first row
            linearLayout{
                gravity = Gravity.CENTER

                button("Animal with long neck"){

                }.lparams(width = 70, height = 70)
                button("Giraffe"){

                }.lparams(width = 70, height = 70)
            }
            //second row
            linearLayout{
                gravity = Gravity.CENTER

                button("Animal with long neck"){

                }.lparams(width = 70, height = 70)
                button("Giraffe"){

                }.lparams(width = 70, height = 70)
            }
            //third row
            linearLayout{
                gravity = Gravity.CENTER

                button("Animal with long neck"){

                }.lparams(width = 70, height = 70)
                button("Giraffe"){

                }.lparams(width = 70, height = 70)
            }
            //last row
            linearLayout{
                gravity = Gravity.CENTER

                button("Animal with long neck"){

                }.lparams(width = 70, height = 70)
                button("Giraffe"){

                }.lparams(width = 70, height = 70)
            }
            button("Quit Game"){
                textSize = 15.0F
            }.lparams(width = 60, height = 30)
        }
        //start the game
        /*
        TL.setOnClickListener{

        }
        TR.setOnClickListener{

        }
        TLC.setOnClickListener{

        }
        TRC.setOnClickListener{

        }
        BLC.setOnClickListener{

        }
        BRC.setOnClickListener{

        }
        BR.setOnClickListener{

        }
        BL.setOnClickListener{

        }
*/
    }
}