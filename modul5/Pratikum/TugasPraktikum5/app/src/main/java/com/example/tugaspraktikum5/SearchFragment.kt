package com.example.tugaspraktikum5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvLabel: TextView = view.findViewById(R.id.hari2)
        val tvImage3: ImageView = view.findViewById(R.id.konten_satu23)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        tvLabel.text = getString(R.string.content_search, index)
        tvImage3.setImageResource(R.drawable.kontenempat)
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}