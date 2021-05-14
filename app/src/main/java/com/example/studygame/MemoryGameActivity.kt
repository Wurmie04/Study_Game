package com.example.studygame

import android.media.Image
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MemoryGameActivity : AppCompatActivity() {

    lateinit var buttons: List<ImageButton>
    lateinit var cards: List<MemoryCard>
    var indexOfSingleSelectedCard : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memory_game)

        val images = mutableListOf(R.drawable.ic_code, R.drawable.ic_computer, R.drawable.ic_leaf, R.drawable.ic_sun)

        images.addAll(images)
        //add each image twice so we can create pairs
        images.shuffle()
        //randomize the order of images

        var btn1: ImageButton = findViewById(R.id.imageButton1)
        var btn2: ImageButton = findViewById(R.id.imageButton2)
        var btn3: ImageButton = findViewById(R.id.imageButton3)
        var btn4: ImageButton = findViewById(R.id.imageButton4)
        var btn5: ImageButton = findViewById(R.id.imageButton5)
        var btn6: ImageButton = findViewById(R.id.imageButton6)
        var btn7: ImageButton = findViewById(R.id.imageButton7)
        var btn8: ImageButton = findViewById(R.id.imageButton8)

        buttons = listOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8)

        cards = buttons.indices.map { index ->
            MemoryCard(images[index])
        }

        buttons.forEachIndexed { index, imageButton: ImageButton ->
            imageButton.setOnClickListener {
                Log.i("Hi! ", "button clicked")
                updateModels(index)
                updateViews()
            }
        }

    }
    fun updateViews() {
        cards.forEachIndexed { index, card ->
            val button = buttons[index]
            button.setImageResource(if(card.isFaceUp) card.identifier else R.drawable.ic_code)
        }
    }

    fun updateModels(position: Int) {
        val card = cards[position]
        // Error checking:
        if(card.isFaceUp) {
            Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show()
            return
        }
        //Three cases
        // 0 cards previously flipped over -> restore cards + flip over selected card
        // 1 cards previously flipped over -> flip over selected card + check if the images match
        // 2 cards previously flipped over -> restore cards + flip over the selected card
        if (indexOfSingleSelectedCard == null)  {
            // 0 or 2 selected cards
            indexOfSingleSelectedCard = position
            restoreCards()
        }
        else {
            checkForMatch(indexOfSingleSelectedCard!!, position)
            indexOfSingleSelectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
    }

    private fun restoreCards() {
        for (card in cards) {
            if(!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }

    private fun checkForMatch(position1: Int, position2: Int) {
        if(cards[position1].identifier == cards[position2].identifier) {
            Toast.makeText(this, "Match found!", Toast.LENGTH_SHORT).show()
            cards[position1].isMatched == true
            cards[position2].isMatched == true
        }
    }
}