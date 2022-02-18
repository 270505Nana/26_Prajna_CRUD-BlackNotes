package com.example.roomdb_prajna_26_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_list.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        //val back : Button = findViewById(R.id.back)
        //ack.setOnClickListener {viewback()}

        val list : Button = findViewById(R.id.list)
        list.setOnClickListener {viewlist()}
        //membuat buttonnya mengarah ke halaman selanjutnya, menggunakan intent

        val add : Button = findViewById(R.id.add)
        add.setOnClickListener {viewadd()}

    }

    private fun viewlist() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    //private fun viewback() {
       // val intent = Intent(this, PlannerActivity::class.java)
       // startActivity(intent)
    //}
    //ini kalo nanti di nonaktiif bisa masuk

    private fun viewadd() {
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    } //ini juga addnya ga bisa :"(








}