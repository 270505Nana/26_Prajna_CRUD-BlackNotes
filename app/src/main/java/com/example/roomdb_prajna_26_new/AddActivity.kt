package com.example.roomdb_prajna_26_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.roomdb_prajna_26_new.room.Constant
import com.example.roomdb_prajna_26_new.room.Note
import com.example.roomdb_prajna_26_new.room.NoteDB
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    //manggil DB, pertama buat variable DB nya dulu

    private val db by lazy { NoteDB(this) }
    private var noteId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupView()
        setupListener()
    }

    fun setupView(){
        val intentType = intent.getIntExtra("intent_type",0)
        when (intentType){
            Constant.TYPE_CREATE -> {

            }

            Constant.TYPE_READ -> {
                button_save.visibility = View.GONE
                getNote()
            }
        }
    }

    fun setupListener() {
        button_save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.noteDao().addNote(

                    Note(0,
                        edit_title.text.toString(),
                        edit_note.text.toString())
                )
//                abis itu disini pake entiti yan kita pake gitu nantinya
                finish()

            }
        }
    }

    fun getNote(){
        noteId = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.noteDao().getNote( noteId ) [0]
            edit_title.setText( notes.title )
            edit_note.setText( notes.note )
        }
    }
}

