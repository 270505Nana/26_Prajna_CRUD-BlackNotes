package com.example.roomdb_prajna_26_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdb_prajna_26_new.room.Note
import com.example.roomdb_prajna_26_new.room.NoteDB
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    //manggil DB, pertama buat variable DB nya dulu
    //


    private val db by lazy {NoteDB(this)}
    private var noteId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        //setUpListener()

    }

    //private fun setUpListener(){
        //button_create.setOnClickListener {
            //CoroutineScope(Dispatchers.IO).launch{
                //db.noteDao().addNote(
                    //abis itu disini pake entiti
                   //Note(0, edit_title.text.toString(),edit_note.text.toString())
                //)
               //finish()

            }
        //}
    //}

//}