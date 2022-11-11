package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/*
Activity finale che mostra il risultato e il nome utente e ti rimanda alla MainActivity
 */
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username:TextView = findViewById(R.id.txtUsername)
        val score:TextView = findViewById(R.id.txtScore)
        val btnFinish:Button = findViewById(R.id.btnFinish)

        username.text = intent.getStringExtra(Costants.USER_NAME)
        score.text = "Il tuo risultato è di ${intent.getIntExtra(Costants.CORRECT_ANSWER,0)} su " +
                "${intent.getIntExtra(Costants.TOTAL_QUESTIONS,0)}"
        btnFinish.setOnClickListener {
            when(it) {
               it -> {
                   val intent = Intent(this, MainActivity::class.java)
                   startActivity(intent)
                   finish()
               }
            }
        }

    }
}