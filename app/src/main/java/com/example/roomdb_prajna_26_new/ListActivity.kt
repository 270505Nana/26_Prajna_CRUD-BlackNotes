package com.example.roomdb_prajna_26_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//        val add : Button = findViewById(R.id.button_create)
//        add.setOnClickListener {viewadd2()}


        setuplistener()
    }

//    private fun viewadd2() {
//        val intent = Intent(this, AddActivity::class.java)
//        startActivity(intent)
//    }

    fun setuplistener() {
        button_create.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }


        //jadi ini pas button createnya diketik dia bakal pindah halaman
        //yang buat bikin notes.Itu button.create diambil dari id yang ada di
        //activity_list
    }
}



