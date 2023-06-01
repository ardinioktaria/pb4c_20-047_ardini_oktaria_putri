package com.example.tugaspratikum6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class EditFragment : Fragment() {
    private lateinit var fullName: EditText
    private lateinit var jurusan: EditText
    private lateinit var fakultas: EditText
    private lateinit var alamat: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_edit, container, false)

        fullName = rootView.findViewById(R.id.full_name)
        fakultas = rootView.findViewById(R.id.fakultas)
        jurusan = rootView.findViewById(R.id.jurusan)
        alamat = rootView.findViewById(R.id.alamat)
        btnSave = rootView.findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(requireContext())

        val intent = requireActivity().intent
        if (intent != null && intent.hasExtra("id")) {
            val id = intent.getIntExtra("id", 0)
            val user = database.userDao().get(id)

            if (user != null) {
                fullName.setText(user.fullName)
                fakultas.setText(user.fakultas)
                jurusan.setText(user.jurusan)
                alamat.setText(user.alamat)
            } else {
                // Handle case when user is null or not found
            }
        }


        btnSave.setOnClickListener {
            if(fullName.text.isNotEmpty() && jurusan.text.isNotEmpty() && fakultas.text.isNotEmpty() && alamat.text.isNotEmpty()){
                if (intent != null && intent.hasExtra("id")) {
                    val id = intent.getIntExtra("id", 0)
                    val user = database.userDao().get(id)

                    if (user != null) {
                        fullName.text.toString()
                        jurusan.text.toString()
                        fakultas.text.toString()
                        alamat.text.toString()

                        database.userDao().update(user)
                    } else {
                        // Handle case when user is null or not found
                    }
                } else {
                    // Tambah Data
                    database.userDao().insertAll(
                        User(
                            null,
                            fullName.text.toString(),
                            jurusan.text.toString(),
                            fakultas.text.toString(),
                            alamat.text.toString()
                        )
                    )
                }

                requireActivity().finish()
            } else {
                Toast.makeText(requireContext(), "Data Tidak Diisi Dengan Valid", Toast.LENGTH_SHORT).show()
            }
        }

        return rootView
    }
}