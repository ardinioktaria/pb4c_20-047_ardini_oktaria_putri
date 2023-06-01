package com.example.tugaspratikum34

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tugaspratikum34.data.AppDatabase
import com.example.tugaspratikum34.data.entity.User

class EditActivity : AppCompatActivity() {

    private lateinit var fullName: EditText
    private lateinit var jurusan: EditText
    private lateinit var fakultas: EditText
    private lateinit var alamat: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        fullName = findViewById(R.id.full_name)
        fakultas = findViewById(R.id.fakultas)
        jurusan = findViewById(R.id.jurusan)
        alamat = findViewById(R.id.alamat)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        var intent = intent.extras
        if (intent!=null){
            var user = database.userDao().get(intent.getInt("id"))
            fullName.setText(user.fullName)
            fakultas.setText(user.fakultas)
            jurusan.setText(user.jurusan)
            alamat.setText(user.alamat)

        }

        btnSave.setOnClickListener {
            if(fullName.text.isNotEmpty() && jurusan.text.isNotEmpty() && fakultas.text.isNotEmpty() && alamat.text.isNotEmpty()){
                if(intent!=null){
                    // Edit Data
                    database.userDao().update(User(
                        intent.getInt("id",0),
                        fullName.text.toString(),
                        jurusan.text.toString(),
                        fakultas.text.toString(),
                        alamat.text.toString()
                    ))
                }
                else{
                    // Tambah Data
                    database.userDao().insertAll(
                        User(
                            null,
                            fullName.text.toString(),
                            jurusan.text.toString(),
                            fakultas.text.toString(),
                            alamat.text.toString()
                        ))
                }

                finish()
            }
            else{
                Toast.makeText(applicationContext,"Silahkan Isi semua data dengan valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}