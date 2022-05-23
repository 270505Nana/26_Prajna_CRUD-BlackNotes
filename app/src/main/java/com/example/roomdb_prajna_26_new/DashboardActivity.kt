package com.example.roomdb_prajna_26_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_list.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val list : ImageView = findViewById(R.id.button_list)
        list.setOnClickListener {viewlist()}
        //membuat buttonnya mengarah ke halaman selanjutnya, menggunakan intent

        val next : ImageView = findViewById(R.id.button_update)
        next.setOnClickListener {viewnext()}

    }

    private fun viewlist() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    private fun viewnext() {
        val intent = Intent(this, PlannerActivity::class.java)
        startActivity(intent)
    }


}