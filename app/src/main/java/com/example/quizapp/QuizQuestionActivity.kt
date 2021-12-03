package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    //if answered correctly, this will signal the penguin to throw the ball
    private var mAnsweredCorrectly: Int = 0
    private var mOpponentScore: Int = 0
    private var mYouWin: Int = 10 //you win:1, opponent win:2, draw: 3
    private var mGameMode: String? = "game_mode_NA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        Log.i("mUsername", "${mUserName}")
        mGameMode = intent.getStringExtra("game_mode")
        if (mGameMode == "practice") {
            tv_your_name.visibility = View.INVISIBLE
            tv_opponent_name.visibility = View.INVISIBLE
            iv_image.visibility = View.INVISIBLE
            progressBar2.visibility = View.INVISIBLE
            tv_progress2.visibility = View.INVISIBLE
            progressBar3.visibility = View.INVISIBLE
            tv_progress3.visibility = View.INVISIBLE
        }

        mQuestionsList = Constants.getQuestions()
        Log.i("Questions Size", "${mQuestionsList!!.size}")
        setQuestion()


        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)


    }

    private fun setQuestion() {
        val question: Question? = mQuestionsList!![mCurrentPosition - 1]
        defaultOptionsView()

        if(mCurrentPosition > mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }



        tv_question.text = question!!.question
        //iv_image.setImageResource(question.image)
        progressBar.progress = (mCurrentPosition - 1)
        tv_progress.text = "${progressBar.progress}" + "/" + progressBar.max

        progressBar2.progress = mCorrectAnswers
        tv_progress2.text = "${progressBar2.progress}" + "/" + progressBar2.max

        progressBar3.progress = mOpponentScore
        tv_progress3.text = "${progressBar3.progress}" + "/" + progressBar3.max

        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
        btn_submit.setOnClickListener(this)

        Log.i("mAnsweredCorrectly", "${mAnsweredCorrectly}")


    }

    //turn all buttons(actually textviews) into default appearance
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg)

        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tv_option_one ->{
                Log.i("mCurrentPosition", "${mCurrentPosition}")
                if (mSelectedOptionPosition != 10) {
                    selectedOptionView(tv_option_one,1)
                }
            }
            R.id.tv_option_two ->{
                if (mSelectedOptionPosition != 10) {
                    selectedOptionView(tv_option_two,2)
                }
            }
            R.id.tv_option_three ->{
                if (mSelectedOptionPosition != 10) {
                    selectedOptionView(tv_option_three,3)
                }
            }
            R.id.tv_option_four ->{
                if (mSelectedOptionPosition != 10) {
                    selectedOptionView(tv_option_four,4)
                }
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0) {
                    Toast.makeText(this, "Choose an answer!", Toast.LENGTH_SHORT).show()
                } else if(mSelectedOptionPosition == 10) {
                    mSelectedOptionPosition = 0
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        } else ->{
                            Toast.makeText(this, "toast!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            intent.putExtra(Constants.YOU_WIN, mYouWin)
                            intent.putExtra("game_mode", mGameMode)
                            startActivity(intent)
                            finish()

                        }
                    }

                } else {

                    progressBar.progress = (mCurrentPosition)
                    tv_progress.text = "${progressBar.progress}" + "/" + progressBar.max

                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        mAnsweredCorrectly = 0
                        animate(iv_image,0)
                    } else {
                        mCorrectAnswers++
                        mAnsweredCorrectly = 1
                        animate(iv_image, 1)

                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 10
                }
            }
        }
    }


    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)

    }

    private fun animate(iv: ImageView, isCorrect: Int) {
        if (mGameMode == "pvp") {
            var get_hit = (0..1).random()
            if (isCorrect == 1) {
                if (get_hit == 0) {
                    Log.i("get_hit","is 0")
                    iv.setImageResource(R.drawable.penguin1)
                } else {
                    mOpponentScore++
                    Log.i("get_hit","is 1")
                }


                var counter: Int = 0
                val timer = object: CountDownTimer(2500, 100) {
                    override fun onTick(millisUntilFinished: Long) {
                        if (counter==0) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin2)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_2)
                            }
                        } else if (counter==1) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin3)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_3)
                            }
                        } else if (counter==2) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin4)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_4)
                            }
                        } else if (counter==3) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin5)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_5)
                            }
                        } else if (counter==4) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin6)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_6)
                            }
                        } else if (counter==5) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin7)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_7)
                            }
                        } else if (counter==6) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin8)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_8)
                            }
                        } else if (counter==7) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin9)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_9)
                            }
                        } else if (counter==8) {
                            if (get_hit==0) {
                                iv.setImageResource(R.drawable.penguin10)
                            } else if (get_hit==1) {
                                iv.setImageResource(R.drawable.penguin_two_10)
                            }
                        } else if (counter==9) {
                            onFinish()
                        }
                        counter++
                    }

                    override fun onFinish() {
                        progressBar2.progress = mCorrectAnswers
                        tv_progress2.text = "${progressBar2.progress}" + "/" + progressBar2.max

                        progressBar3.progress = mOpponentScore
                        tv_progress3.text = "${progressBar3.progress}" + "/" + progressBar3.max
                        if (btn_submit.text == "FINISH") {
                            if (mCorrectAnswers > mOpponentScore) {
                                iv_image.setImageResource(R.drawable.penguin_win_1)
                                mYouWin = 1
                            } else if (mCorrectAnswers < mOpponentScore){
                                iv_image.setImageResource(R.drawable.penguin_win_2)
                                mYouWin = 2
                            } else {
                                mYouWin = 3
                            }
                        }
                    }
                }
                timer.start()

            } else if (isCorrect == 0){
                if (get_hit == 0) {
                    Log.i("get_hit","is 0")
                    iv.setImageResource(R.drawable.penguin1)
                    if (btn_submit.text == "FINISH") {
                        if (mCorrectAnswers > mOpponentScore) {
                            iv_image.setImageResource(R.drawable.penguin_win_1)
                            mYouWin = 1
                        } else if (mCorrectAnswers < mOpponentScore){
                            iv_image.setImageResource(R.drawable.penguin_win_2)
                            mYouWin = 2
                        } else {
                            mYouWin = 3
                        }
                    }
                } else { //right penguin hits left
                    mOpponentScore++
                    Log.i("get_hit","is 1")
                    iv.setImageResource(R.drawable.penguin_three_1)
                    var counter: Int = 0
                    val timer = object: CountDownTimer(2500, 100) {
                        override fun onTick(millisUntilFinished: Long) {
                            if (counter==0) {
                                iv.setImageResource(R.drawable.penguin_three_2)
                            } else if (counter==1) {
                                iv.setImageResource(R.drawable.penguin_three_3)
                            } else if (counter==2) {
                                iv.setImageResource(R.drawable.penguin_three_4)
                            } else if (counter==3) {
                                iv.setImageResource(R.drawable.penguin_three_5)
                            } else if (counter==4) {
                                iv.setImageResource(R.drawable.penguin_three_6)
                            } else if (counter==5) {
                                iv.setImageResource(R.drawable.penguin_three_7)
                            } else if (counter==6) {
                                iv.setImageResource(R.drawable.penguin_three_8)
                            } else if (counter==7) {
                                iv.setImageResource(R.drawable.penguin_three_9)
                            } else if (counter==8) {
                                iv.setImageResource(R.drawable.penguin_three_10)
                            } else if (counter==9) {
                                onFinish()
                            }
                            counter++
                        }

                        override fun onFinish() {
                            progressBar3.progress = mOpponentScore
                            tv_progress3.text = "${progressBar3.progress}" + "/" + progressBar3.max
                            if (btn_submit.text == "FINISH") {
                                if (mCorrectAnswers > mOpponentScore) {
                                    iv_image.setImageResource(R.drawable.penguin_win_1)
                                    mYouWin = 1
                                } else if (mCorrectAnswers < mOpponentScore){
                                    iv_image.setImageResource(R.drawable.penguin_win_2)
                                    mYouWin = 2
                                } else {
                                    mYouWin = 3
                                }
                            }
                        }
                    }
                    timer.start()

                }


            }
        }
    }
}
















