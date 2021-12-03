package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        var timeScore = 0   // game 액티비티에서 time 받아올 변수.

        // game 액티비티에서 time 받아옴.
        val intent = getIntent()
        timeScore = intent.getIntExtra("TIME", 0)

        // 점수 텍스트 뷰 변수 선언. id 할당.
        lateinit var txtTime: TextView
        txtTime=findViewById(R.id.score_view)

        val min = timeScore / (100 * 60)
        val sec = (timeScore % (100 * 60)) / 100
        val milli = timeScore % 100

        // 텍스트 뷰에 시간 표시
        txtTime?.text = "${min} : ${sec} : ${milli}"

        val pref=this.getPreferences(0)
        // 키에 해당되는 밸류를 가져우는 데 저장된 값이 없으면 0을 가져온다.
        // 시간은 짧으면 점수가 높은것이기 때문에 초기값 1000 초로 설정.
        val height=pref.getInt("KEY_HEIGHT", 0)
        val lastHighScore=pref.getInt("KEY_WEIGHT", 1000000)

        // 현재 클리어 시간이 저번 클리어 시간 최단 기록보다 짧으면
        if(lastHighScore > timeScore) {
            // 점수 저장.
            saveData(timeScore, timeScore)
        }

        // 최단 기록 보여줌.
        loadData()

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
        reTryButton=findViewById(R.id.retry_btn)
        reTryButton.setOnClickListener {
            startActivity(reTryIntent)
            finish()
        }

    }

    // 데이터 파일에 데이터 저장하는 함수
    private fun saveData (height : Int, weight : Int) {
        val pref = this.getPreferences(0)
        val editor=pref.edit()

        // 키와 밸류 쌍으로 저장하고 apply 한다.
        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()
    }

    // 데이터 파일에서 데이터 불러오는 함수.
    private fun loadData () {
        // 최고점수 변수.
        lateinit var highScore : TextView
        highScore=findViewById(R.id.high_score)

        val pref=this.getPreferences(0)
        // 키에 해당되는 밸류를 가져우는 데 저장된 값이 없으면 0을 가져온다.
        // 시간은 짧으면 점수가 높은것이기 때문에 초기값 1000 초로 설정.
        val height=pref.getInt("KEY_HEIGHT", 0)
        val weight=pref.getInt("KEY_WEIGHT", 1000000)

        val min = weight / (100 * 60)
        val sec = (weight % (100 * 60)) / 100
        val milli = weight % 100

        if (height != 0 && weight != 0) {
            //highScore.setText(weight.toString())
            highScore?.text = "${min} : ${sec} : ${milli}"
        }
    }

}