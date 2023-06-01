 package com.example.tugaspratikum

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

 class MainActivity : AppCompatActivity() {

    private var mainAdapter : MainAdapter?=null
    private var recyclerView : RecyclerView?=null
     private var contohList = mutableListOf<Data>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contohList = ArrayList()

        recyclerView = findViewById<View>(R.id.r_satu) as RecyclerView
        mainAdapter = MainAdapter(this@MainActivity,contohList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = mainAdapter

        prepareContohList()
    }

     private fun prepareContohList() {
         var menu = Data("Tita Wandhita", "11 November 2002" , "Surabaya", R.drawable.gmbr1)
         contohList.add(menu)
         menu = Data("Ardini Oktaria Putri", "21 Oktober 2001" , "Jakarta", R.drawable.gmbr2)
         contohList.add(menu)
         menu = Data("Dini Ayu Cahyani", "28 April 2002" , "Bandung", R.drawable.gmbr3)
         contohList.add(menu)
         menu = Data("Khofidotun Nikmah", "08 Mei 2002" , "Solo", R.drawable.gmbr4)
         contohList.add(menu)
         menu = Data("Nur Fadilah", "01 Januari 2001" , "Madura", R.drawable.gmbr5)
         contohList.add(menu)
         menu = Data("Siti Khodijah", "10 Agustus 2002" , "Bojonegoro", R.drawable.gmbr6)
         contohList.add(menu)
         menu = Data("Asmaul Qusnah", "17 September 2002" , "Kediri", R.drawable.gmbr7)
         contohList.add(menu)
         menu = Data("Fatimah Azzahrah", "15 Desember 2001" , "Papua", R.drawable.gmbr8)
         contohList.add(menu)
         menu = Data("Mauliddya Putri", "20 Februari 2002" , "Gresik", R.drawable.gmbr9)
         contohList.add(menu)
         menu = Data("Rania Nuraini", "25 Juli 2002" , " Madura", R.drawable.gmbr10)
         contohList.add(menu)
         menu = Data("Putri Ayu", "31 Maret 2001" , "Jogja", R.drawable.gmbr11)
         contohList.add(menu)
         menu = Data("Maharani Ningtyas", "28 Juni 2002" , "Ngawi", R.drawable.gmbr12)
         contohList.add(menu)

         mainAdapter!!.notifyDataSetChanged()
     }
 }