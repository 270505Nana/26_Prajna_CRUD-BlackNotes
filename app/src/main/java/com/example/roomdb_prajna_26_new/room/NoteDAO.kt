package com.example.roomdb_prajna_26_new.room

import androidx.room.*

@Dao
interface NoteDAO {

    //ini kayanya biar si daonya itu bisa nambah data, update data
    //sama delete data terus biar kebaca dan ditampilin
    //karena pake list jadi pake query
    //ini tuh note manggil yang note class.kt itu
    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
    //ini pake suspend karena nanti akan pakai coroutines

    @Query("SELECT * FROM note")
    suspend fun getNotes():List<Note>
    //ini nampilin datanya dalam bentuk list dari mana? dari
    //dari Note gitu...
    //tadinya yang select * from note(notenya masih merah karena belum add entitynya
    //nambahinnya di Note.kt @Entity

    @Query("SELECT * FROM note WHERE id=:note_id")
    suspend fun getNote(note_id: Int):List<Note>

//    membuat var id=> akan diapakai menjadi parameter
//    jadi sesuai id, mana yang mau kita edit
}