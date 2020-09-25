package com.example.quest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
private lateinit var trueButton: Button
private lateinit var falseButton: Button
private lateinit var nextButton: Button
private lateinit var questionTextView: TextView

private val questionBank = listOf(
    Question(R.string.question_text, true),
    Question(R.string.question_sanaa, true),
    Question(R.string.question_taiz, false))

 private var currentIndex = 0



private fun updateQuestion() {
    val questionTextResId = questionBank[currentIndex].textResId
    questionTextView.setText(questionTextResId)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.quest_text)

        trueButton.setOnClickListener {
            Toast.makeText( this, "true" ,Toast.LENGTH_SHORT).show()
        }
        falseButton.setOnClickListener {
            Toast.makeText( this, "false" ,Toast.LENGTH_SHORT).show()
        }
        nextButton.setOnClickListener {

            currentIndex = (currentIndex + 1) % questionBank.size

            updateQuestion()
        }
        updateQuestion()
        questionTextView.setOnClickListener {

            currentIndex = (currentIndex + 1) % questionBank.size

            updateQuestion()
        }
        updateQuestion()
    }
}
