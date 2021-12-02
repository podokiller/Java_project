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

        // 텍스트 뷰 변수 선언. id 할당.
        lateinit var txtTime: TextView
        txtTime=findViewById(R.id.score_view)

        val min = timeScore / (100 * 60)
        val sec = (timeScore % (100 * 60)) / 100
        val milli = timeScore % 100

        // 텍스트 뷰에 시간 표시
        txtTime?.text = "${min} : ${sec} : ${milli}"


    }
}