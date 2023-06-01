package com.example.tugaspraktikum5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class HistoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvImage: ImageView= view.findViewById(R.id.konten_satu2)
        val tvImage2: ImageView= view.findViewById(R.id.konten_dua2)
        val tvLabel: TextView = view.findViewById(R.id.hari)
        val tvImage3: ImageView= view.findViewById(R.id.konten_empat2)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        tvImage.setImageResource(R.drawable.konten1)
        tvImage2.setImageResource(R.drawable.konten)
        tvLabel.text = getString(R.string.content_history, index)
        tvImage3.setImageResource(R.drawable.kontenempat)
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}