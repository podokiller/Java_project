package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DifficultyActivity : AppCompatActivity() {
    lateinit var closeButton: Button    // closeButton 을 버튼 변수로 선언. 창 닫는 기능.
    lateinit var normalButton:Button    // 노말 난이도 게임 이동버튼 선언.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        // 닫기 버튼 누르면 액티비티 종료.
        closeButton=findViewById(R.id.close_button)
        closeButton.setOnClickListener {
            finish()
        }

        // 노말 버튼 누르면 노말 난이도 게임 엑티비티 실행.
        var normalIntent = Intent(this, FindSameCard::class.java)
        normalButton=findViewById(R.id.normal_button)
        normalButton.setOnClickListener{
            startActivity(normalIntent)
        }

    }
}