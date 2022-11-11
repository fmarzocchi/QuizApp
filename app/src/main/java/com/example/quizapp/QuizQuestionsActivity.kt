package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition = 0
    private var mUsername : String? = null
    private var mCorrectAnswers : Int = 0

    private var progressBar: ProgressBar? = null
    private var txtProgressBar: TextView? = null
    private var answerTwo: TextView? = null
    private var answerOne: TextView? = null
    private var answerThree: TextView? = null
    private var answerFour: TextView? = null
    private var confirmBtn: Button? = null
    private var image: ImageView? = null
    private var txtQuestion: TextView? = null
    private var clicked=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUsername=intent.getStringExtra(Costants.USER_NAME)
        progressBar=findViewById(R.id.progressBar)
        txtProgressBar=findViewById(R.id.progressTxt)
        answerOne=findViewById(R.id.answer_one)
        answerTwo=findViewById(R.id.answer_two)
        answerThree=findViewById(R.id.answer_three)
        answerFour=findViewById(R.id.answer_four)
        confirmBtn=findViewById(R.id.btn_submit)
        image=findViewById(R.id.image)
        txtQuestion=findViewById(R.id.question)

        answerOne?.setOnClickListener(this)
        answerTwo?.setOnClickListener(this)
        answerThree?.setOnClickListener(this)
        answerFour?.setOnClickListener(this)
        confirmBtn?.setOnClickListener(this)

        // le domande sono tutte salvate dentro l'oggetto Costants.
        mQuestionsList = Costants.getQuestions()

        setQuestions()


    }

    private fun setQuestions() {
        defaultOptionsView()
        val questionList = Costants.getQuestions()

        var question: Question = mQuestionsList!![mCurrentPosition - 1]
        progressBar?.max = mQuestionsList!!.size
        progressBar?.progress = mCurrentPosition
        txtProgressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        txtQuestion?.text = question.question
        answerOne?.text = question.optionOne
        answerTwo?.text = question.optionTwo
        answerThree?.text = question.optionThree
        answerFour?.text = question.optionFour
        image?.setImageResource(question.image)

        confirmBtn?.text= "CONFERMA"
    }

    // Fa il setting del textColor,typeface e background nelle TextView delle risposte
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        answerOne?.let {
            options.add(0,it)
        }
        answerTwo?.let {
            options.add(1,it)
        }
        answerThree?.let {
            options.add(2,it)
        }
        answerFour?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    // imposta il bordo viola e il testo Bold nella risposta selezionata
    private fun selectedOptionView(tv:TextView, selectedOptionNumber : Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){

            R.id.answer_one -> {
                    if (!clicked) answerOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.answer_two -> {
                if (!clicked) answerTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.answer_three -> {
                if (!clicked) answerThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.answer_four -> {
                if (!clicked) answerFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit ->{
                /* clicked è true se il bottone di conferma (btn_submit) è stato premuto.
                Quindi in questo if ci si entra subito dopo aver cliccato 2 volte il bottone di conferma
                 */
                if (mSelectedOptionPosition == 0 && clicked){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestions()
                            clicked=false
                        }
                        // quando vengono esaurite le domande entra nell'else e cambia activity
                        else -> {
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Costants.USER_NAME,mUsername)
                            intent.putExtra(Costants.CORRECT_ANSWER,mCorrectAnswers)
                            intent.putExtra(Costants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                    /* qui ci entra dopo aver cliccato 1 volta il bottone di conferma (btn_submit).
                    Colora di verde la risposta giusta e di rosso la risposta sbagliata e cambia
                    il testo del bottone di conferma
                     */
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_otpion_border_bg)
                        clicked=true
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    clicked=true

                    if(mCurrentPosition == mQuestionsList!!.size){
                        confirmBtn?.setText("FINE")
                    }else{
                        confirmBtn?.setText("PROSSIMA DOMANDA")
                    }
                    mSelectedOptionPosition= 0

                }
            }
        }
    }

    // per colorare di rosso o verde le risposte
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                answerOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                answerTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                answerThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                answerFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }


        }
    }

}