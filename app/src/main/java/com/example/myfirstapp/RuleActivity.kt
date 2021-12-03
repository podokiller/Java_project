package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RuleActivity : AppCompatActivity() {
    lateinit var closeButton:Button // closeButton 을 버튼 변수로 선언. 창 닫는 기능.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rule)

        // 닫기 버튼 누르면 액티비티 종료.
        closeButton=findViewById(R.id.close_button)
        closeButton.setOnClickListener {
            finish()
        }

    }

}