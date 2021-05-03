package com.example.studygame

import android.content.Intent
import android.graphics.Color
import android.nfc.Tag
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
    private var score = 0
    private var scoreText = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Create list of Questions and Answers
        val List1 : MutableList<String> = mutableListOf("0","1","2","3","4","5","6","7","8","9")
        val List1Answer : MutableList<String> = mutableListOf("a","b","c","d","e","f","g","h","i","j")

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
                    startGame(List1,List1Answer)
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

    private fun startGame(qList:MutableList<String>,qAnswer:MutableList<String>) {
        //delete the previous menu
        linearLayout().removeAllViews()

        //bring up the xml design view
        setContentView(R.layout.activity_multiple_choice)

        //set up what is under the cards
        //0 1
        //2 3
        //4 5
        //6 7
        //get 8 random numbers that points to Questions List
        //from x to number of items in questions list
        val questionSize = qList.size
        val qNa = (0..questionSize).random()

        //get the values to be used

        //randomize them (shuffle)


        //create score and buttons
        verticalLayout{
            gravity = Gravity.CENTER
            //score
            textView("Score: $score"){
                id = R.id.score
                textSize = 20.0F
                setTextColor(Color.BLACK)
                setBackgroundColor(Color.WHITE)
                gravity = Gravity.CENTER or Gravity.TOP
            }
            //Question
            textView("${qList.get(qNa)}"){
                textSize = 25.0F
                setTextColor(Color.BLACK)
                setBackgroundColor(Color.WHITE)
                gravity = Gravity.CENTER or Gravity.TOP
            }
            //Answers
            //first row
            linearLayout{
                gravity = Gravity.CENTER

                button(""){
                    setOnClickListener{
                        //play()
                    }
                }.lparams(width = 70, height = 70)
                button(""){
                    setOnClickListener{
                        play(1, qNa, qList,qAnswer)
                    }
                }.lparams(width = 70, height = 70)
            }
            //second row
            linearLayout{
                gravity = Gravity.CENTER

                button(""){
                    setOnClickListener{
                        play(2, qNa,qList,qAnswer)
                    }
                }.lparams(width = 70, height = 70)
                button(""){
                    setOnClickListener{
                        play(3,qNa,qList,qAnswer)
                    }
                }.lparams(width = 70, height = 70)
            }
            //third row
            linearLayout{
                gravity = Gravity.CENTER

                button(""){
                    setOnClickListener{
                        play(4, qNa,qList,qAnswer)
                    }
                }.lparams(width = 70, height = 70)
                button(""){
                    setOnClickListener{
                        play(5,qNa,qList,qAnswer)
                    }
                }.lparams(width = 70, height = 70)
            }
            //last row
            linearLayout{
                gravity = Gravity.CENTER

                button(""){
                    setOnClickListener{
                        play(6, qNa,qList,qAnswer)
                    }
                }.lparams(width = 70, height = 70)
                button(""){
                    setOnClickListener{
                        play(7,qNa,qList,qAnswer)
                    }
                }.lparams(width = 70, height = 70)
            }
            button("Quit Game"){
                textSize = 15.0F
            }.lparams(width = 60, height = 30)
        }
    }

    private fun play(position : Int, questionPos : Int, qList:MutableList<String>, qAnswer:MutableList<String>){

    }
}