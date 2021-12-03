package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer

class EndActivity : AppCompatActivity() {
    var diff = 0        // game 액티비티에서 난이도 받아올 변수.
    var highScore = 0   // 최단기록 저장 변수.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        var timeScore = 0   // game 액티비티에서 time 받아올 변수.

        // game 액티비티에서 time, diff 받아옴.
        val intent = getIntent()
        timeScore = intent.getIntExtra("TIME", 0)
        diff = intent.getIntExtra("DIFFICULTY", 0)

        // 점수 난이도 뷰 변수.
        lateinit var diffTxt: TextView
        diffTxt=findViewById(R.id.score_diff)

        if (diff == 0) {
           diffTxt.setText("Easy 난이도")
        }
        else if (diff == 1) {
            diffTxt.setText("Normal 난이도")
        }
        else if (diff == 2) {
            diffTxt.setText("Hard 난이도")
        }

        // 점수 텍스트 뷰 변수 선언. id 할당.
        lateinit var txtTime: TextView
        txtTime=findViewById(R.id.score_view)

        val min = timeScore / (100 * 60)
        val sec = (timeScore % (100 * 60)) / 100
        val milli = timeScore % 100

        // 텍스트 뷰에 시간 표시
        txtTime?.text = "${min} : ${sec} : ${milli}"

        // 액티비티 내에 데이터 저장하기 위한 변수.
        val pref=this.getPreferences(0)
        val editor=pref.edit()      // 데이터 수정하기 위한 에디터.

        // 신기록 달성 시 보이는 텍스트 뷰.
        lateinit var conMsg : TextView
        conMsg=findViewById(R.id.congratulation)

        // 최고 점수 나오는 텍스트 뷰
        lateinit var highScoreTxt : TextView
        highScoreTxt=findViewById(R.id.high_score)



        // 난이도에 따라 키값 다르게 줘서 저장. 최고점 출력.
        var lastHighScore = 0
        if (diff == 0) {        // easy 난이도.
            // 시간은 짧으면 점수가 높은것이기 때문에 초기값 1000 초로 설정.
            lastHighScore = pref.getInt("0", 1000000)
            if (lastHighScore > timeScore) {    // 현재 시간 점수가 더 짧다면 값 변경.
                editor.putInt("0", timeScore).apply()
                conMsg.setVisibility(View.VISIBLE)
            }
            highScore = pref.getInt("0", 1000000)
            val min = highScore / (100 * 60)
            val sec = (highScore % (100 * 60)) / 100
            val milli = highScore % 100
            highScoreTxt?.text = "${min} : ${sec} : ${milli}"
        }
        else if (diff == 1) {   // normal 난이도
            lastHighScore = pref.getInt("1", 1000000)
            if (lastHighScore > timeScore) {
                editor.putInt("1", timeScore).apply()
                conMsg.setVisibility(View.VISIBLE)
            }
            highScore = pref.getInt("1", 1000000)
            val min = highScore / (100 * 60)
            val sec = (highScore % (100 * 60)) / 100
            val milli = highScore % 100
            highScoreTxt?.text = "${min} : ${sec} : ${milli}"
        }
        else if (diff == 2) {   // hard 난이도
            lastHighScore = pref.getInt("2", 1000000)
            if (lastHighScore > timeScore) {
                editor.putInt("2", timeScore).apply()
                conMsg.setVisibility(View.VISIBLE)
            }
            highScore = pref.getInt("2", 1000000)
            val min = highScore / (100 * 60)
            val sec = (highScore % (100 * 60)) / 100
            val milli = highScore % 100
            highScoreTxt?.text = "${min} : ${sec} : ${milli}"
        }
        ///




        // 메인 화면 가게 하는 버튼.
        lateinit var goMainButton: Button

        val goMainIntent = Intent(this, MainActivity::class.java)
        goMainButton=findViewById(R.id.go_main)
        goMainButton.setOnClickListener {
            startActivity(goMainIntent)
            finish()
        }

        // 재도전 버튼.
        lateinit var reTryButton: Button

        val reTryIntent = Intent(this, FindSameCard::class.java)
        reTryIntent.putExtra("DIFFICULTY", diff)
        reTryButton=findViewById(R.id.retry_btn)
        reTryButton.setOnClickListener {
            startActivity(reTryIntent)
            finish()
        }

    }

}