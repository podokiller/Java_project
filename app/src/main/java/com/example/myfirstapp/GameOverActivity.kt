package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        var diff = 0        // game 액티비티에서 난이도 받아올 변수.

        val intent = getIntent()
        diff = intent.getIntExtra("DIFFICULTY", 0)

        // 메인 화면 가게 하는 버튼.
        lateinit var goMainButton: Button

        val goMainIntent = Intent(this, MainActivity::class.java)
        goMainButton=findViewById(R.id.go_main)
        goMainButton.setOnClickListener {
            startActivity(goMainIntent)
            finish()
        }

        val reTryIntent = Intent(this, FindSameCard::class.java)
        reTryIntent.putExtra("DIFFICULTY", diff)

        // 재도전 버튼.
        lateinit var reTryButton: Button
        reTryButton=findViewById(R.id.retry_btn)
        reTryButton.setOnClickListener {
            startActivity(reTryIntent)
            finish()
        }
    }
}