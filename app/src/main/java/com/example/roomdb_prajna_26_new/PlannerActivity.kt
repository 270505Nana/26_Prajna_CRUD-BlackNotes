package com.example.roomdb_prajna_26_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PlannerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planner)

        val next : Button = findViewById(R.id.button_back)
        next.setOnClickListener {viewback()}
    }

    private fun viewback() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }

}