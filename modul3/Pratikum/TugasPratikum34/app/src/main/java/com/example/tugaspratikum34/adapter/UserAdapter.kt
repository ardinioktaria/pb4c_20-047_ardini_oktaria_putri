package com.example.tugaspratikum34.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspratikum34.R
import com.example.tugaspratikum34.data.entity.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog){
        this.dialog= dialog
    }

    interface Dialog {
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var fullName: TextView
        var jurusan: TextView
        var fakultas: TextView
        var alamat: TextView
        init {
            fullName = view.findViewById(R.id.full_name)
            jurusan = view.findViewById(R.id.jurusan)
            fakultas = view.findViewById(R.id.fakultas)
            alamat = view.findViewById(R.id.alamat)
            view.setOnClickListener{
                dialog.onClick(layoutPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_menu,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fullName.text = list[position].fullName
        holder.jurusan.text = list[position].jurusan
        holder.fakultas.text = list[position].fakultas
        holder.alamat.text = list[position].alamat
    }
}