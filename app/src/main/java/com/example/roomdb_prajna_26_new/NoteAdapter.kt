package com.example.roomdb_prajna_26_new

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb_prajna_26_new.room.Note
import kotlinx.android.synthetic.main.adapter_note.view.*

class NoteAdapter (private val notes: ArrayList<Note>, private val listener: OnAdapterListener) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.adapter_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.view.text_title.text = note.title
        holder.view.text_title.setOnClickListener{
            listener.onClick(note)
        }

        holder.view.icon_edit.setOnClickListener{
            listener.onUpdate(note)
        }

        holder.view.icon_delete.setOnClickListener{}
    }

    override fun getItemCount() = notes.size

    class NoteViewHolder (val view: View) : RecyclerView.ViewHolder(view)
//  untuk mengambil view dari layout

    fun setData(list: List<Note>){
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClick(note: Note)
        fun onUpdate(note: Note)
    }

}