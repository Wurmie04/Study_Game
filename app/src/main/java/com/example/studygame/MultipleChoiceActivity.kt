package com.example.studygame

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_multiple_choice.*
import kotlinx.coroutines.*
import org.jetbrains.anko.*
import org.w3c.dom.Text

//Multiple Choice Game
class MultipleChoiceActivity : AppCompatActivity() {
    private var score = 0
    private var qNa = 0
    private var index : MutableList<Int> = mutableListOf()
    var HSscore = 0

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
            button("Get High Score") {
                textSize = 20.0F
                setOnClickListener{
                    submitGetHSServiceReq(MultipleChoiceActivity())
                    createHighScoreLayout()
                }
            }
        }
    }
    private fun createHighScoreLayout() {
        verticalLayout{
            gravity = Gravity.CENTER
            textView("High Score"){
                textSize = 20.0F
            }
            textView("$HSscore"){
                textSize = 20.0F
            }
            button("Return"){
                textSize = 20.0F
                setOnClickListener {
                    startActivity<MultipleChoiceActivity>("id" to 7)
                }
            }
        }
    }

    public fun SQLscore(outScore : Int){
        HSscore = outScore
    }

    @SuppressLint("SetTextI18n")
    private fun startGame(qList:MutableList<String>, qAnswer:MutableList<String>) {
        var didWin = false
        val txtView : MutableList<TextView> = mutableListOf()
        val buttonView : MutableList<Button> = mutableListOf()
        //set up what is under the cards
        //0 1
        //2 3
        //4 5
        //6 7
        //get 8 random numbers that points to Questions List
        //from x to number of items in questions list
        index = MutableList(qList.size){i->(i)}
        index.shuffle()

        qNa = (0..7).random()

        //I think you can loop this to make the code easier
        //create score and buttons
        verticalLayout{
            gravity = Gravity.CENTER
            //score
            textView("Score: $score"){
                txtView.add(this)
                id = R.id.score
                textSize = 20.0F
                setTextColor(Color.BLACK)
                setBackgroundColor(Color.WHITE)
                gravity = Gravity.CENTER or Gravity.TOP
            }
            //Question
            textView(qList.get(index.get(qNa))){
                txtView.add(this)
                textSize = 25.0F
                setTextColor(Color.BLACK)
                setBackgroundColor(Color.WHITE)
                gravity = Gravity.CENTER or Gravity.TOP
            }
            //Answers
            //first row
            linearLayout{
                gravity = Gravity.CENTER

                button(qAnswer.get(index.get(0))){
                    buttonView.add(this)
                    setOnClickListener{
                        didWin = play(0,qNa)
                        //Green if you won
                        if(didWin){
                            setBackgroundColor(Color.GREEN)
                            //update the screen to give new questions and answers
                            update(txtView, buttonView,qList,qAnswer)
                        }
                        //red if you lost
                        else{
                            setBackgroundColor((Color.RED))
                            txtView.get(0).text = "Score: ${score}"
                        }
                    }
                //same for every button
                }.lparams(width = 70, height = 70)
                button(qAnswer.get(index.get(1))){
                    buttonView.add(this)
                    setOnClickListener{
                        didWin = play(1, qNa)
                        if(didWin){
                            setBackgroundColor(Color.GREEN)
                            update(txtView, buttonView,qList,qAnswer)
                        }
                        else{
                            setBackgroundColor((Color.RED))
                            txtView.get(0).text = "Score: ${score}"
                        }
                    }
                }.lparams(width = 70, height = 70)
            }
            //second row
            linearLayout{
                gravity = Gravity.CENTER

                button(qAnswer.get(index.get(2))){
                    buttonView.add(this)
                    setOnClickListener{
                        didWin = play(2, qNa)
                        if(didWin){
                            setBackgroundColor(Color.GREEN)
                            update(txtView, buttonView,qList,qAnswer)
                        }
                        else{
                            setBackgroundColor((Color.RED))
                            txtView.get(0).text = "Score: ${score}"
                        }
                    }
                }.lparams(width = 70, height = 70)
                button(qAnswer.get(index.get(3))){
                    buttonView.add(this)
                    setOnClickListener{
                        didWin = play(3,qNa)
                        if(didWin){
                            setBackgroundColor(Color.GREEN)
                            update(txtView, buttonView,qList,qAnswer)
                        }
                        else{
                            setBackgroundColor((Color.RED))
                            txtView.get(0).text = "Score: ${score}"
                        }
                    }
                }.lparams(width = 70, height = 70)
            }
            //third row
            linearLayout{
                gravity = Gravity.CENTER

                button(qAnswer.get(index.get(4))){
                    buttonView.add(this)
                    setOnClickListener{
                        didWin = play(4, qNa)
                        if(didWin){
                            setBackgroundColor(Color.GREEN)
                            update(txtView, buttonView,qList,qAnswer)
                        }
                        else{
                            setBackgroundColor((Color.RED))
                            txtView.get(0).text = "Score: ${score}"
                        }
                    }
                }.lparams(width = 70, height = 70)
                button(qAnswer.get(index.get(5))){
                    buttonView.add(this)
                    setOnClickListener{
                        didWin = play(5,qNa)
                        if(didWin){
                            setBackgroundColor(Color.GREEN)
                            update(txtView, buttonView,qList,qAnswer)
                        }
                        else{
                            setBackgroundColor((Color.RED))
                            txtView.get(0).text = "Score: ${score}"
                        }
                    }
                }.lparams(width = 70, height = 70)
            }
            //last row
            linearLayout{
                gravity = Gravity.CENTER

                button(qAnswer.get(index.get(6))){
                    buttonView.add(this)
                    setOnClickListener{
                        didWin = play(6, qNa)
                        if(didWin){
                            setBackgroundColor(Color.GREEN)
                            update(txtView, buttonView,qList,qAnswer)
                        }
                        else{
                            setBackgroundColor((Color.RED))
                            txtView.get(0).text = "Score: ${score}"
                        }
                    }
                }.lparams(width = 70, height = 70)
                button(qAnswer.get(index.get(7))){
                    buttonView.add(this)
                    setOnClickListener{
                        didWin = play(7,qNa)
                        if(didWin){
                            setBackgroundColor(Color.GREEN)
                            update(txtView, buttonView,qList,qAnswer)
                        }
                        else{
                            setBackgroundColor((Color.RED))
                            txtView.get(0).text = "Score: ${score}"
                        }
                    }
                }.lparams(width = 70, height = 70)
            }
            linearLayout{
                gravity = Gravity.CENTER
                //Quits the game and stores the end score into database
                button("Main Menu"){
                    textSize = 15.0F
                    setOnClickListener{
                        //puts score into database
                        submitAddServiceReq(score)
                        //goes back to main menu
                        startActivity<MainActivity>("id" to 5)
                    }
                }.lparams(width = 60, height = 30)
                button("List Menu"){
                    textSize = 15.0F
                    setOnClickListener{
                        submitAddServiceReq(score)
                        startActivity<MultipleChoiceActivity>("id" to 6)
                    }
                }
            }
        }
    }

    //updates the user score
    private fun play(clickedPosition : Int, answerPosition : Int): Boolean{
        if (clickedPosition == answerPosition) {
            score = score + 1
            return true
        }
        else{
            score = score - 1
            return false
        }
    }

    //update score. Put new question and answers
    private fun update(text : MutableList<TextView>, buttons : MutableList<Button>,
                       qList: MutableList<String>, qAnswer: MutableList<String>){
        index.shuffle()
        qNa = (0..7).random()

        text.get(0).text = "Score: $score"
        text.get(1).text = qList.get(index.get(qNa))
        var i = 0
        for(buttons in buttons) {
            buttons.text = qAnswer.get(index.get(i))
            i = i + 1
            buttons.setBackgroundColor(Color.LTGRAY)
        }
    }
}