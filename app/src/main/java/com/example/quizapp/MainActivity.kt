package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start)
        val edtxName  : EditText = findViewById(R.id.edtxName)
        btnStart.setOnClickListener {

            if (edtxName.text.isEmpty()){
                Toast.makeText(this,
                    "Inserire il Nome per proseguire",
                    Toast.LENGTH_SHORT)
                    .show()
            }else{
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Costants.USER_NAME,edtxName.text.toString())
                startActivity(intent)
            }
        }

    }
}