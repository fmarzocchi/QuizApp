package com.example.quizapp

object Costants {

    const val USER_NAME  : String  ="user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWER : String = "correct_answer"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "A quale paese appartiene questa bandiera?",
            R.drawable.ic_flag_of_argentina,
            "Cile",
            "Argentina",
            "Ecuador",
            "Australia",
            2
        )
        questionsList.add(que1)
        val que2 = Question(
            2,
            "Qual è la capitale di questo paese?",
            R.drawable.ic_flag_of_belgium,
            "Amsterdam",
            "Berlino",
            "Bruxelles",
            "Belfast",
            3
        )
        questionsList.add(que2)
        val que3 = Question(
            3,
            "A quale paese appartiene questa bandiera?",
            R.drawable.ic_flag_of_india,
            "Italia",
            "Kuwait",
            "Francia",
            "Nessuna di queste",
            4
        )
        questionsList.add(que3)
        val que4 = Question(
            4,
            "Giovanna?",
            R.drawable.ic_flag_of_brazil,
            "Eurospin",
            "7",
            "Trump",
            "Si",
            2
        )
        questionsList.add(que4)
        val que5 = Question(
            5,
            "Che cos'è ?",
            R.drawable.linux,
            "Linux",
            "Ubuntu",
            "Penguin",
            "MS-DOS",
            1

        )
        questionsList.add(que5)
        val que6 = Question(
            6,
            "Qual è la lettera finale del nome di questa azienda?",
            R.drawable.quicksilver,
            "S",
            "D",
            "R",
            "N",
            3
        )
        questionsList.add(que6)
        val que7 = Question(
            7,
            "Quale di queste affermazioni è vera?",
            R.drawable.starbucks,
            "Vendono dolci",
            "E' nata in California",
            "Non ci sono punti vendita a Roma",
            "Sbagliano sempre il tuo nome",
            4
        )
        questionsList.add(que7)
        val que8= Question(
            8,
            "Quando è fallita questa azienda?",
            R.drawable.motorola,
            "2011",
            "2014",
            "Esiste ancora",
            "Si è scissa in due aziende",
            4
        )
        questionsList.add(que8)
        val que9 = Question(
            9,
            "Quale di queste affermazioni è vera?",
            R.drawable.paypal,
            "Elon Musk era uno dei soci fondatori",
            "Viene accettato come metodo di pagamento su Amazon",
            "E' stata controllata da Ebay per un periodo",
            "Ha circa 200 milioni di clienti",
            3
        )
        questionsList.add(que9)
        val que10=Question(
            10,
            "Questa azienda è lo sponsor ufficiale di..?",
            R.drawable.rolex,
            "Federer",
            "Moto GP",
            "Nadal",
            "Formula E",
            1

        )
        questionsList.add(que10)
        questionsList.shuffle()
        return questionsList
    }

}