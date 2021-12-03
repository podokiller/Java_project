package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class FindSameCard : AppCompatActivity() {
    // 실패 횟수
    var failNum = 0

    // 짝을 맞춘 카드와 못맞춘 카드를 넣어 둘 리스트.
    private val openedCard=ArrayList<ImageButton>()      // 짝 맞춤
    private var closedCard=ArrayList<ImageButton>()      // 못맞춤.

    // 클릭된 두 카드 넣어둘 리스트.
    private val checkedCard=ArrayList<ImageButton>()

    // drawable 파일 넣어줄 리스트 만듦.
    private var cardList=ArrayList<Int>()
    // 각 이미지버튼 할당할 변수.
    lateinit var cardID1: ImageButton
    lateinit var cardID2: ImageButton
    lateinit var cardID3: ImageButton
    lateinit var cardID4: ImageButton
    lateinit var cardID5: ImageButton
    lateinit var cardID6: ImageButton
    lateinit var cardID7: ImageButton
    lateinit var cardID8: ImageButton
    lateinit var cardID9: ImageButton
    lateinit var cardID10: ImageButton
    lateinit var cardID11: ImageButton
    lateinit var cardID12: ImageButton
    lateinit var cardID13: ImageButton
    lateinit var cardID14: ImageButton
    lateinit var cardID15: ImageButton
    lateinit var cardID16: ImageButton


    protected var time = 0
    protected var timerTask : Timer? = null

    lateinit var startButton: Button
    lateinit var stopButton: Button     // 시간 정지 버튼. 임시 버튼이고 후에 게임 클리어 하면 멈추게 변경.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_same_card)

        // 카드 리스트에 drawable 파일 넣어줌.
        cardList.add(R.drawable.pororo)
        cardList.add(R.drawable.pororo_girl)
        cardList.add(R.drawable.edi)
        cardList.add(R.drawable.roopy)
        cardList.add(R.drawable.pobi)
        cardList.add(R.drawable.krong)
        cardList.add(R.drawable.robo_edi)
        cardList.add(R.drawable.bird)
        // 같은 카드 한 번 더 넣어줌. List 는 내용물 같아도 인덱스 다르면 구분 가능.
        cardList.add(R.drawable.pororo)
        cardList.add(R.drawable.pororo_girl)
        cardList.add(R.drawable.edi)
        cardList.add(R.drawable.roopy)
        cardList.add(R.drawable.pobi)
        cardList.add(R.drawable.krong)
        cardList.add(R.drawable.robo_edi)
        cardList.add(R.drawable.bird)
        //

        // 카드 셔플해서 그때그때 위치 달라지게 함.
        // cardList= cardList.shuffled() as ArrayList<Int>

        // 변수 초기값 설정.
        cardID1=findViewById(R.id.imageButton1)
        cardID2=findViewById(R.id.imageButton2)
        cardID3=findViewById(R.id.imageButton3)
        cardID4=findViewById(R.id.imageButton4)
        cardID5=findViewById(R.id.imageButton5)
        cardID6=findViewById(R.id.imageButton6)
        cardID7=findViewById(R.id.imageButton7)
        cardID8=findViewById(R.id.imageButton8)
        cardID9=findViewById(R.id.imageButton9)
        cardID10=findViewById(R.id.imageButton10)
        cardID11=findViewById(R.id.imageButton11)
        cardID12=findViewById(R.id.imageButton12)
        cardID13=findViewById(R.id.imageButton13)
        cardID14=findViewById(R.id.imageButton14)
        cardID15=findViewById(R.id.imageButton15)
        cardID16=findViewById(R.id.imageButton16)


        // 뒤집혀 있는 카드 리스트에 모든 카드들 넣어줌.
        closedCard.add(cardID1)
        closedCard.add(cardID2)
        closedCard.add(cardID3)
        closedCard.add(cardID4)
        closedCard.add(cardID5)
        closedCard.add(cardID6)
        closedCard.add(cardID7)
        closedCard.add(cardID8)
        closedCard.add(cardID9)
        closedCard.add(cardID10)
        closedCard.add(cardID11)
        closedCard.add(cardID12)
        closedCard.add(cardID13)
        closedCard.add(cardID14)
        closedCard.add(cardID15)
        closedCard.add(cardID16)
        //


        // 게임 시작 전 카드 터치 못함.
        beforeStartCantTouch()

        // 임시로 카드리스트의 인덱스 정해서 넣어주지만, 후에 cardList 랜덤인덱스 받아서 넣어줄 것
        // 아니면 리스트 셔플해도 될듯.
        // 카드 클릭 시 이미지 변경. -> 앞면 보여주는 것.
        cardID1.setOnClickListener {
            cardID1.setImageResource(cardList[0])
            checkCard(cardID1)
        }

        cardID2.setOnClickListener {
            cardID2.setImageResource(cardList[1])
            checkCard(cardID2)
        }

        cardID3.setOnClickListener {
            cardID3.setImageResource(cardList[2])
            checkCard(cardID3)
        }

        cardID4.setOnClickListener {
            cardID4.setImageResource(cardList[3])
            checkCard(cardID4)
        }

        cardID5.setOnClickListener {
            cardID5.setImageResource(cardList[4])
            checkCard(cardID5)
        }

        cardID6.setOnClickListener {
            cardID6.setImageResource(cardList[5])
            checkCard(cardID6)
        }

        cardID7.setOnClickListener {
            cardID7.setImageResource(cardList[6])
            checkCard(cardID7)
        }

        cardID8.setOnClickListener {
            cardID8.setImageResource(cardList[7])
            checkCard(cardID8)
        }

        cardID9.setOnClickListener {
            cardID9.setImageResource(cardList[8])
            checkCard(cardID9)
        }

        cardID10.setOnClickListener {
            cardID10.setImageResource(cardList[9])
            checkCard(cardID10)
        }

        cardID11.setOnClickListener {
            cardID11.setImageResource(cardList[10])
            checkCard(cardID11)
        }

        cardID12.setOnClickListener {
            cardID12.setImageResource(cardList[11])
            checkCard(cardID12)
        }

        cardID13.setOnClickListener {
            cardID13.setImageResource(cardList[12])
            checkCard(cardID13)
        }

        cardID14.setOnClickListener {
            cardID14.setImageResource(cardList[13])
            checkCard(cardID14)
        }

        cardID15.setOnClickListener {
            cardID15.setImageResource(cardList[14])
            checkCard(cardID15)
        }

        cardID16.setOnClickListener {
            cardID16.setImageResource(cardList[15])
            checkCard(cardID16)
        }


        // 게임 시작 버튼 클릭 시 타이머 시작.    후에 게임 진행되는 함수도 만들 예정.
        startButton=findViewById(R.id.game_start)
        startButton.setOnClickListener {
            // 시작 버튼 클릭 시 앞면 잠시 보여줌.
            cardID1.setImageResource(cardList[0])
            cardID2.setImageResource(cardList[1])
            cardID3.setImageResource(cardList[2])
            cardID4.setImageResource(cardList[3])
            cardID5.setImageResource(cardList[4])
            cardID6.setImageResource(cardList[5])
            cardID7.setImageResource(cardList[6])
            cardID8.setImageResource(cardList[7])
            cardID9.setImageResource(cardList[8])
            cardID10.setImageResource(cardList[9])
            cardID11.setImageResource(cardList[10])
            cardID12.setImageResource(cardList[11])
            cardID13.setImageResource(cardList[12])
            cardID14.setImageResource(cardList[13])
            cardID15.setImageResource(cardList[14])
            cardID16.setImageResource(cardList[15])

            // 카드가 다시 뒤집어짐.
            Handler(Looper.getMainLooper()).postDelayed({
                allClose()
                //closedCardCanTouch()
                closedCardCanTouch()
                // 뒤집어지고 타이머 시작.
                startTimer()
            },1000)

        }

        /*
        // 정지 버튼 클릭 시 타이머 스탑.
        stopButton=findViewById(R.id.time_stop)
        stopButton.setOnClickListener {
            stopTimer()

        }*/
    }

    // 타이머 동작.
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
    // 타이머 정지.
    private fun stopTimer() {
        lateinit var scoreTime : TextView
        timerTask?.cancel()
    }


    // 짝을 못맞춘 카드 리스트에 있는 모든 카드를 뒷면으로 뒤집는 함수.
    private fun allClose() {
        for(i in closedCard.indices) {
            closedCard[i].setImageResource(R.drawable.card_back)
        }
    }

    // 선택한 두 카드의 짝이 맞다면 openedCard 리스트에 넣어주고, 다르면 다시 뒤집음.
    private fun matching(cardID : ImageButton, nextCardID : ImageButton) {    // cardList 에 있는 카드의 아이디 비교할거임.
        // 스위치 문으로 ID 값 정해주기. 어차피 같은 cardID 에는 항상 같은 인덱스 들어갈 거니까.( 인덱스 셔플해줘서 게임 진행 시 항상 카드 순서 같은 경우 걱정할 필요없음)
        var ID : Int = 0
        var ID2 : Int = 0

        lateinit var tryChance : TextView
        tryChance=findViewById(R.id.try_chance)

        when (cardID) {
            cardID1 -> ID = cardList[0]
            cardID2 -> ID = cardList[1]
            cardID3 -> ID = cardList[2]
            cardID4 -> ID = cardList[3]
            cardID5 -> ID = cardList[4]
            cardID6 -> ID = cardList[5]
            cardID7 -> ID = cardList[6]
            cardID8 -> ID = cardList[7]
            cardID9 -> ID = cardList[8]
            cardID10 -> ID = cardList[9]
            cardID11 -> ID = cardList[10]
            cardID12 -> ID = cardList[11]
            cardID13 -> ID = cardList[12]
            cardID14 -> ID = cardList[13]
            cardID15 -> ID = cardList[14]
            cardID16 -> ID = cardList[15]
        }

        when (nextCardID) {
            cardID1 -> ID2 = cardList[0]
            cardID2 -> ID2 = cardList[1]
            cardID3 -> ID2 = cardList[2]
            cardID4 -> ID2 = cardList[3]
            cardID5 -> ID2 = cardList[4]
            cardID6 -> ID2 = cardList[5]
            cardID7 -> ID2 = cardList[6]
            cardID8 -> ID2 = cardList[7]
            cardID9 -> ID2 = cardList[8]
            cardID10 -> ID2 = cardList[9]
            cardID11 -> ID2 = cardList[10]
            cardID12 -> ID2 = cardList[11]
            cardID13 -> ID2 = cardList[12]
            cardID14 -> ID2 = cardList[13]
            cardID15 -> ID2 = cardList[14]
            cardID16 -> ID2 = cardList[15]
        }

        // endActivity 에 보낼 변수. 시간 기록.
        val endIntent = Intent(this, EndActivity::class.java)
        endIntent.putExtra("TIME", time)

        // 기회 0 이 되어 실패한 경우 이동할 액티비티.
        val failIntent = Intent(this, GameOverActivity::class.java)

        if (ID == ID2) {    // 짝 맞춘 경우.
            openedCard.add(cardID)
            openedCard.add(nextCardID)
            //openedCardCantTouch()

            closedCard.remove(cardID)
            closedCard.remove(nextCardID)

            closedCardCanTouch()    // checkCard 함수에서 checkedCard 리스트의 사이즈가 2일때 다른 카드들 터치 막아뒀던 거 해제.

            // 뒤집힌 카드가 하나도 없을 때 게임 종료.
            if(closedCard.isEmpty()) {
                stopTimer()
                // 스코어 타임 나오는 액티비티로 이동.
                startActivity(endIntent)

                // 점수 화면에서 뒤로 못돌아오게함.
                finish()
            }
        }

        else if (ID != ID2) {
            failNum += 1
            println(failNum)
            when (failNum) {
                1 -> tryChance.setText("기회 X 2")
                2 -> tryChance.setText("기회 X 1")
                3 -> tryChance.setText("기회 X 0")
            }
            if (failNum == 3) {
                startActivity(failIntent)
                finish()
            }
            // 뒤집은 두 카드가 짝이 맞지 않는다면 0.5초 보여주고 덮음.
            Handler(Looper.getMainLooper()).postDelayed({
                allClose()
                closedCardCanTouch()
            },500)
        }

    }

    // 카드를 두 개 선택하면 matching 함수 호출.
    private fun checkCard(cardID : ImageButton) {
        checkedCard.add(cardID)
        checkedCardCantTouch()

        if (checkedCard.size == 2) {
            beforeStartCantTouch()  // 빠르게 터치 했을 때 추가로 3, 4 장 더 뒤집는거 방지.
            matching(checkedCard[0], checkedCard[1])
            checkedCard.clear()
            return
        }

        else return
    }

    // 체크된 카드를 다시 터치할 수 없게 함.
    private fun checkedCardCantTouch() {
        for(i in checkedCard.indices) {
            checkedCard[i].setEnabled(false)
        }
    }

    /*
    private fun openedCardCantTouch() {
        for(i in openedCard.indices) {
            openedCard[i].setEnabled(false)
        }
    }
    */

    // 카드를 다시 뒤집으면 터치할 수 있도록 함.
    private fun closedCardCanTouch() {
        for(i in closedCard.indices) {
            closedCard[i].setEnabled(true)
        }
    }

    // 시작 전에 카드 터치 불가.
    private fun beforeStartCantTouch() {
        for(i in closedCard.indices) {
            closedCard[i].setEnabled(false)
        }
    }
}