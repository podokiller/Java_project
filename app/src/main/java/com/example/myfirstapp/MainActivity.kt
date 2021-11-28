package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var ruleButton:Button  // 규칙 창 여는 버튼 선언.
    lateinit var startButton:Button // 게임시작 창 여는 버튼 선언. 난이도 선택 액티비티로 이동.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ruleIntent = Intent(this, RuleActivity::class.java)
        // 게임설명 버튼 누르면 RuleActivity 로 이동.
        ruleButton=findViewById(R.id.Rule)
        ruleButton.setOnClickListener {
            startActivity(ruleIntent)
        }

        var startIntent = Intent(this, DifficultyActivity::class.java)
        // 게임시작 버튼 누르면 DifficultyActivity 로 이동.
        startButton=findViewById(R.id.start_button)
        startButton.setOnClickListener {
            startActivity(startIntent)
        }
    }
}