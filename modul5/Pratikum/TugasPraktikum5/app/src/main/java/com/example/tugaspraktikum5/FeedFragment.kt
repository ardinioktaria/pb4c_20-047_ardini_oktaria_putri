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

class FeedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    @SuppressLint("StringFormatInvalid")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvImage: ImageView= view.findViewById(R.id.konten_satu)
        val tvImage2: ImageView= view.findViewById(R.id.konten_dua)
        val tvLabel: TextView = view.findViewById(R.id.panggil)
        val tvImage3: ImageView= view.findViewById(R.id.konten_tiga)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        tvImage.setImageResource(R.drawable.konten1)
        tvImage2.setImageResource(R.drawable.konten)
        tvLabel.text = getString(R.string.content_feed, index)
        tvImage3.setImageResource(R.drawable.kontentiga)
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}