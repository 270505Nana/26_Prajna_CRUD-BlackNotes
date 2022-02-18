package com.example.roomdb_prajna_26_new.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//kalo @Database merah import
//kalo RoomDatabase merah kita import juga
//Context juga import

@Database(
    entities = [Note::class],
    //ini dia ke Note.kt
    //Kalau mau ditambah bisa disesuain aja
    version = 1
)
abstract class NoteDB : RoomDatabase(){

    abstract fun noteDao() : NoteDAO
    //Diambil dari NoteDAO atau dari class interface di NoteDAO
    //untuk meelakukan CRUD, kalo mau bikin 2 juga bisa
    //abstract fun noteDao() : NoteDAO (Nanti tinggal DAO nya apa)
    //terus vaariablenya diganti misal jadi noteDao2

    companion object {

        @Volatile private var instance : NoteDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDB::class.java,
            "note.db"

            //Disini ada database name, disini .db bukan sebuah ekstensi
            //Tapi cuman buat nunjukin kalo dia itu database
        ).build()

    }
}