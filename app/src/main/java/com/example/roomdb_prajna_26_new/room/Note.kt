package com.example.roomdb_prajna_26_new.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note (

    //Disini juga ngetik primary key => berfungsi untuk membedakan satu data
    //ke data yang lain.Ini nambah primarykey
    //kita butuh id, judul sama catatan disini kita buat
    //ini disini kita milih mau pake tipe data apa,
    // kalo id kan integer karena dia pake angka
    //kurung kurawalnya diubah jadi kurung biasa

    //fungsi auto generated true, jadi nanti  nilai yang perlu,
    //kita simpan dalam note ini cukup title sama notenya aja buat id nanti dia generated sendiri

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val note:String
)