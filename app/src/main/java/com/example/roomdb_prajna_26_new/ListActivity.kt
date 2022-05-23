package com.example.roomdb_prajna_26_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb_prajna_26_new.room.Constant
import com.example.roomdb_prajna_26_new.room.Note
import com.example.roomdb_prajna_26_new.room.NoteDB
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListActivity : AppCompatActivity() {
    private val db by lazy { NoteDB(this) }
    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setuplistener()
        setupRecyclerview()
    }
//  Bikin adapter untuk menghubungkan datnya
    override fun onStart(){
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.noteDao().getNotes() //artinya kita ambil data
            Log.d("ListActivity", "dbResponse::$notes" )
            withContext(Dispatchers.Main){
                noteAdapter.setData(notes)
            }
//                abis itu disini pake entiti yan kita pake gitu nantinya


    }

    }

    fun setuplistener() {
        button_create.setOnClickListener {
            intentEdit(0,Constant.TYPE_CREATE)
        }
        //jadi ini pas button createnya diketik dia bakal pindah halaman
        //yang buat bikin notes.Itu button.create diambil dari id yang ada di
        //activity_list
    }

    fun intentEdit(noteId:Int, intentType: Int){
        startActivity(
            Intent(applicationContext, AddActivity::class.java)
                .putExtra("intent_id",noteId)
                .putExtra("intent_type",intentType)
        )
    }

    private fun setupRecyclerview(){
        noteAdapter = NoteAdapter(arrayListOf(), object:NoteAdapter.OnAdapterListener{

            //object perlu implement members
            override fun onClick(note: Note) {
//                read detail note
                intentEdit(note.id, Constant.TYPE_READ)

            }

            override fun onUpdate(note: Note) {
                intentEdit(note.id, Constant.TYPE_UPDATE)
            }
        })
        list_note.apply{
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = noteAdapter
        }
    }
}



