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
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginRight
import kotlinx.android.synthetic.main.activity_multiple_choice.*
import kotlinx.coroutines.*
import org.jetbrains.anko.*
import org.w3c.dom.Text

//Multiple Choice Game
class MultipleChoiceActivity : AppCompatActivity() {
    private var score = 0
    private var qNa = 0
    private var index : MutableList<Int> = mutableListOf()
    private var textList : MutableList<TextView> = mutableListOf()
    private var layoutList : MutableList<LinearLayout> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Create list of Questions and Answers
        val LiteratureList : MutableList<String> = mutableListOf("To Kill a Mockingbird","Frankenstein","Harry Potter", "Animal Farm","Lord of the Flies","The Great Gatsby","Moby Dick","The Catcher in the Rye","The Adventures of Tom Sawyer",
        "Pride and Prejudice", "Don Quixote", "Wuthering Heights","Lord of the Rings","To the Lighthouse","Fahrenheit 451","Great Expectations","Alice's Adventure in Wonderland", "Dracula","The Call of the Wild", "The Scarlet Letter")
        val LiteratureAnswer : MutableList<String> = mutableListOf("Harper Lee","Mary Shelley","J.K. Rowling","George Orwell","William Golding","F. Scott Fitzgerald","Herman Melville","J.D. Salinger", "Mark Twain","Jane Austen","Miguel deCervantes",
        "Emily Bronte","J.R.R. Tolkien","Virginia Woolf","Ray Bradbury","Charles Dickens","Lewis Carroll","Bram Stoker","Jack London","Nathaniel Hawthorne")
        val HistoricalFigures : MutableList<String> = mutableListOf("Whose assasination is one of the reasons attributed to the start of World War 1?","Who is the only female emperor to ever sit on China’s throne of her own right?","Who is said to be the first emperor of unified China?",
        "Who was a central figure during the Hundred Year’s War (right to rule over the Kingdom of France) that resulted in their being burnt at the stake, then later declared a martyr and a saint?","Who was an ancient Chinese philosopher and traditionally considered the paragon of Chinese sages, active during the Spring and Autumn period, whose teachings and philosophy are still followed by many Chinese and Asian cultures today?",
        "Who was a famous French military leader that reformed France after the French Revolution with many notable achievements, one of which is developing a code for which is named after him?","Who was a great Japanese daimyo (feudal lord) known as the first “Great Unifier” of Japan during the Sengoku Period?\n",
        "Who is known as the greatest Ottomon Sultan (absolute ruler) that codified a legal system that harmonized the legal and religious aspects of Ottomon law, and presided over a Golden Age in terms of architecture, literature, and art?", "Who was an Indian Prince and philosopher that is known as the founder of Buddhism?")
        val HistoricalAnswers : MutableList<String> = mutableListOf("Franz Ferdinand","Wu Ze Tian","Qin Shi Huang","Joann of Arc","Confucius","Napoleon Bonaparte,","Oda Nobunaga","Suleiman the Magnificent","Siddhartha Guatama")
        val Country : MutableList<String> = mutableListOf("Amazon Rainforest","Leaning Tower of Pisa","Palace of Versaille","Alhambra","Great Pyramid of Giza","Fuji Mountains","Big Ben","Neuschwanstein Castle","Burj Khalifa","Taj Mahal","Forbidden City","Tulum","Geongbokgung Palace",
        "Iguazu Falls","Sydney Opera House","Mount Everest runs through Nepal and which country?","Borobudur Temple","Mount Kilimanjaro","Niagara Falls","Angkor Archaeological Park")
        val CountryAnswer : MutableList<String> = mutableListOf("Brazil","Italy","France","Spain","Egypt","Japan","United Kingdom","Germany","United Arab Emirates","India","China","Mexico","Korea","Argentina","Australia",
        "Tibet","Indonesia","Tanzania","Canada","Cambodia")
        val Medical : MutableList<String> = mutableListOf("Cranium","Cornea","Thyroid Cartilage","Clavicles","Tibia","Hallux","Cerebrum","Integumentary System","Pinna","Frontalis","Gingiva","Sternum","Larynx","Vertebrae","Deltoid","Olecranon","Femu",
        "Molars","Umbilicus","Calcaneus")
        val MedicalAnswer : MutableList<String> = mutableListOf("Head/UpperSkull","Eye Whites","Adam's Apple","Collar Bone","Shin Bone","Big Toe","Uppermost Part of Brain","Skin,Hair,Nails","Outer Ear","Muscles that Raise Eyebrows","Gums","Breastbone","Voice Box",
        "Spine","Shoulder Muscle","Elbow","Thigh Bone","Wisdom Teeth","Navel","Heel Bone")
        val Anime : MutableList<String> = mutableListOf("Trafalgar D. Law","Roy Mustang","Hisoka Morow","Kamado Nezuko","Ryoumen Sukuna","Nunnally vi Brittania","Tsukishima Kei","Shiba Miyuki","Souma Yuuki","Megumin","Tomoe(Fox Demon)","Ishigami Senku","Sora/Shira",
        "Tanya Degurechaff","Nakiri Erina","Hououin Kyouma","Yaboku","Hyakkimaru","Decim","Satou Mafuyu")
        val AnimeAnswer : MutableList<String> = mutableListOf("One Piece","Full Metal Alchemist Brotherhood","HunterxHunter","Kimetsu no Yaiba","Jujutsu Kaisen","Code Geass","Haikyuu!!!","Mahouka Koukou no Rettousei","Fruits Basket","Konosuba",
        "Kamisama Hajimemashita","Dr. Stone","No Game No Life","Youjo Senki","Shokugeki no Souma","Steins Gate","Noragami","Dororo","Death Parade","Given")

        //Choose which list to use
        verticalLayout{
            layoutList.add(this)
            setBackgroundColor(Color.parseColor("#BCB8CE"))
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            textView("Choose Category"){
                textSize = 35.0F
                setTextColor(Color.parseColor("#D5DDEF"))
                setBackgroundColor(Color.parseColor("#4C394F"))
                gravity = Gravity.CENTER
                setPadding(0,20, 0,20)
            }
            //Quiz Card Game
            button("Literature"){
                textSize = 20.0F
                setTextColor(Color.parseColor("#2E1A1E"))
                setBackgroundColor(Color.parseColor("#917898"))
                setOnClickListener{
                    startGame(LiteratureList,LiteratureAnswer)
                }
            }
            /*
            button("Historical Figures"){
                textSize = 20.0F
                setOnClickListener{
                    startGame(HistoricalFigures,HistoricalAnswers)
                }
            }*/
            button("Geographical Hotspots"){
                textSize = 20.0F
                setTextColor(Color.parseColor("#2E1A1E"))
                setBackgroundColor(Color.parseColor("#917898"))
                setOnClickListener{
                    startGame(Country,CountryAnswer)
                }
            }
            button("Medical Terminology"){
                textSize = 20.0F
                setTextColor(Color.parseColor("#2E1A1E"))
                setBackgroundColor(Color.parseColor("#917898"))
                setOnClickListener{
                    startGame(Medical,MedicalAnswer)
                }
            }
            button("Anime"){
                textSize = 20.0F
                setTextColor(Color.parseColor("#2E1A1E"))
                setBackgroundColor(Color.parseColor("#917898"))
                setOnClickListener{
                    startGame(Anime,AnimeAnswer)
                }
            }
            button("High Score") {
                textSize = 20.0F
                setTextColor(Color.parseColor("#D5DDEF"))
                setBackgroundColor(Color.parseColor("#917898"))
                setOnClickListener{
                    layoutList.get(0).setVisibility(View.GONE)
                    createHighScoreLayout()
                }
            }
            button("Main Menu"){
                textSize = 20.0F
                setTextColor(Color.parseColor("#D5DDEF"))
                setBackgroundColor(Color.parseColor("#917898"))
                setOnClickListener{
                    startActivity<MainActivity>("id" to 8)
                }
            }
        }
    }
    fun createHighScoreLayout() {
        verticalLayout{
            gravity = Gravity.CENTER
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            linearLayout {
                textView("High Score:  ") {
                    gravity = Gravity.CENTER
                    textSize = 40.0F
                }.lparams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
                textView("") {
                    textList.add(this)
                    textSize = 40.0F
                }.lparams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }
            button("Return"){
                textSize = 20.0F
                setOnClickListener {
                    //restart the activity
                    startActivity<MultipleChoiceActivity>("id" to 7)
                }
            }
        }
        submitGetHSServiceReq(textList.get(0))
    }

    @SuppressLint("SetTextI18n")
    private fun startGame(qList:MutableList<String>, qAnswer:MutableList<String>) {
        var didWin: Boolean
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
        //need to set each box to a certain size that does not take up all of parent
        verticalLayout{
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#917898"))
            //score
            textView("Score: $score"){
                txtView.add(this)
                id = R.id.score
                textSize = 20.0F
                setTextColor(Color.parseColor("#2E1A1E"))
                setBackgroundColor(Color.parseColor("#917898"))
                gravity = Gravity.CENTER or Gravity.TOP
            }.lparams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            //Question
            textView(qList.get(index.get(qNa))){
                txtView.add(this)
                textSize = 20.0F
                setTextColor(Color.parseColor("#2E1A1E"))
                setBackgroundColor(Color.parseColor("#917898"))
                gravity = Gravity.CENTER or Gravity.TOP
            }.lparams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            //Answers
            //first row
            linearLayout{
                gravity = Gravity.CENTER

                button(qAnswer.get(index.get(0))){
                    buttonView.add(this)
                    textSize = 10.0F
                    setTextColor(Color.parseColor("#2E1A1E"))
                    setBackgroundColor(Color.parseColor("#D5DDEF"))
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
                    textSize = 10.0F
                    setTextColor(Color.parseColor("#2E1A1E"))
                    setBackgroundColor(Color.parseColor("#D5DDEF"))
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
                    textSize = 10.0F
                    setTextColor(Color.parseColor("#2E1A1E"))
                    setBackgroundColor(Color.parseColor("#D5DDEF"))
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
                    textSize = 10.0F
                    setTextColor(Color.parseColor("#2E1A1E"))
                    setBackgroundColor(Color.parseColor("#D5DDEF"))
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
                    textSize = 10.0F
                    setTextColor(Color.parseColor("#2E1A1E"))
                    setBackgroundColor(Color.parseColor("#D5DDEF"))
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
                    textSize = 10.0F
                    setTextColor(Color.parseColor("#2E1A1E"))
                    setBackgroundColor(Color.parseColor("#D5DDEF"))
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
                    textSize = 10.0F
                    setTextColor(Color.parseColor("#2E1A1E"))
                    setBackgroundColor(Color.parseColor("#D5DDEF"))
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
                    textSize = 10.0F
                    setTextColor(Color.parseColor("#2E1A1E"))
                    setBackgroundColor(Color.parseColor("#D5DDEF"))
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
                    setPadding(3,0,4,0)
                    textSize = 15.0F
                    setTextColor(Color.parseColor("#D5DDEF"))
                    setBackgroundColor(Color.parseColor("#4C394F"))
                    setOnClickListener{
                        //puts score into database
                        submitAddServiceReq(score)
                        //goes back to main menu
                        startActivity<MainActivity>("id" to 5)
                    }
                }.lparams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
                button("Categories"){
                    setPadding(4,0,3,0)
                    textSize = 15.0F
                    setTextColor(Color.parseColor("#D5DDEF"))
                    setBackgroundColor(Color.parseColor("#4C394F"))
                    setOnClickListener{
                        submitAddServiceReq(score)
                        startActivity<MultipleChoiceActivity>("id" to 6)
                    }
                }.lparams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
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
            buttons.setTextColor(Color.parseColor("#2E1A1E"))
            buttons.setBackgroundColor(Color.parseColor("#D5DDEF"))
        }
    }
}