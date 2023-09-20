package com.example.latihanbarvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inisialisasi komponen
        private lateinit var edtWidth: EditText
        private lateinit var edtHeight: EditText
        private lateinit var edtLength: EditText
        private lateinit var btnCalculate: Button
        private lateinit var tvResult: TextView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            edtWidth = findViewById(R.id.edt_width)
            edtHeight = findViewById(R.id.edt_height)
            edtLength = findViewById(R.id.edt_length)
            btnCalculate = findViewById(R.id.btn_calculate)
            tvResult = findViewById(R.id.tv_result)

            btnCalculate.setOnClickListener(this)
        }
    }
}