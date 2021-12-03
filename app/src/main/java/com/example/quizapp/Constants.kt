package com.example.quizapp

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val YOU_WIN: String = "you_win"


    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "What's 13+5?",
            R.drawable.penguin1,
            "18",
            "20",
            "22",
            "25",
            correctAnswer = 1
        )
        val que2 = Question(
            2,
            "What's 5+26?",
            R.drawable.penguin1,
            "25",
            "29",
            "31",
            "34",
            correctAnswer = 3
        )
        val que3 = Question(
            3,
            "What's 13+12?",
            R.drawable.penguin1,
            "20",
            "21",
            "23",
            "25",
            correctAnswer = 4
        )
        val que4 = Question(
            4,
            "What's 20+8?",
            R.drawable.penguin1,
            "23",
            "25",
            "28",
            "30",
            correctAnswer = 3
        )
        val que5 = Question(
            5,
            "What's 31+9",
            R.drawable.penguin1,
            "39",
            "40",
            "41",
            "42",
            correctAnswer = 2
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        return questionsList

    }

    fun getQuestions2(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "What's 13 + 13 + 13 + 13?",
            R.drawable.penguin1,
            "50",
            "51",
            "52",
            "53",
            correctAnswer = 3
        )

        questionsList.add(que1)
        return questionsList

    }
}