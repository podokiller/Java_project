package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer

class FindSameCard : AppCompatActivity() {
    private var time = 0
    private var timerTask : Timer? = null

    lateinit var startButton: Button
    lateinit var stopButton: Button     // 시간 정지 버튼. 임시 버튼이고 후에 게임 클리어 하면 멈추게 변경.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_same_card)

        // 게임 시작 버튼 클릭 시 타이머 시작.    후에 게임 진행되는 함수도 만들 예정.
        startButton=findViewById(R.id.game_start)
        startButton.setOnClickListener {
            startTimer()
        }

        // 정지 버튼 클릭 시 타이머 스탑.
        stopButton=findViewById(R.id.time_stop)
        stopButton.setOnClickListener {
            stopTimer()
        }
    }

    private fun startTimer(){
        lateinit var txtTime: TextView

        txtTime=findViewById(R.id.text_timer)

        timerTask = timer(period = 10) {
            time++

            val min = time / (100 * 60)
            val sec = (time % (100 * 60)) / 100
            val milli = time % 100

            runOnUiThread {
                //val txtTime = "00:00:00"
                txtTime?.text = "${min} : ${sec} : ${milli}"
            }

        }
    }

    private fun stopTimer() {
        timerTask?.cancel()
    }
}