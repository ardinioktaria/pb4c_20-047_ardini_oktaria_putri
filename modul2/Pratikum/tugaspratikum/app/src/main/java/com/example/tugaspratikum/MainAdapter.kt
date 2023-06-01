package com.example.tugaspratikum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val getActivity: MainActivity,
    private val contohList : List<Data>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listmenu,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.nama.text = contohList[position].nama
        holder.ttl.text = contohList[position].ttl
        holder.alamat.text = contohList[position].alamat
        holder.gambar.setImageResource(contohList[position].gambar)

        holder.cardView.setOnClickListener{
            Toast.makeText(getActivity,contohList[position].nama,  Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return contohList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nama : TextView = itemView.findViewById(R.id.text1)
        val ttl : TextView = itemView.findViewById(R.id.text2)
        val alamat : TextView = itemView.findViewById(R.id.text3)
        val gambar : ImageView = itemView.findViewById(R.id.gambar1)
        val cardView : CardView = itemView.findViewById(R.id.card_satu)
    }
}