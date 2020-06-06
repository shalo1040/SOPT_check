package com.example.sopkathon

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.activity_answer_admin.*
import kotlinx.android.synthetic.main.activity_answer_admin.tv_date
import java.util.*


class AnswerAdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.sopkathon.R.layout.activity_answer_admin)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        //날짜 선택
        setDateLayout.setOnClickListener() {
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                tv_date.setText(""  + year + "." + (month+1) + "." + day)
            }, year, month, day)
            datePicker.show()
        }

        //시간 선택
        linearLayout.setOnClickListener() {
            val timePicker =
                TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    tv_time.setText("" + hour + ":" + minute)
                }, hour, minute, false)
            timePicker.show()
        }

        et_answer.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable?) = Unit

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    btn_finish.setBackgroundResource(R.drawable.round_green)
                    btn_finish.setTextColor(Color.WHITE)
                }
            }
        )
        //완료 버튼 클릭
        btn_finish.setOnClickListener() {
            startActivity(Intent(this, CheckAdminActivity::class.java))
        }
    }
}