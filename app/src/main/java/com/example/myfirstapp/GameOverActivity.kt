package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        // 메인 화면 가게 하는 버튼.
        lateinit var goMainButton: Button

        val goMainIntent = Intent(this, MainActivity::class.java)
        goMainButton=findViewById(R.id.go_main)
        goMainButton.setOnClickListener {
            startActivity(goMainIntent)
            finish()
        }

        lateinit var reTryButton: Button

        val reTryIntent = Intent(this, FindSameCard::class.java)
        reTryButton=findViewById(R.id.retry_btn)
        reTryButton.setOnClickListener {
            startActivity(reTryIntent)
            finish()
        }
    }
}