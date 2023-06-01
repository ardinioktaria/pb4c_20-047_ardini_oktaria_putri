package com.example.tugaspratikum6

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "full_name") var fullName: String?,
    @ColumnInfo(name = "jurusan") var jurusan: String?,
    @ColumnInfo(name = "fakultas") var fakultas: String?,
    @ColumnInfo(name = "alamat") var alamat: String?,
)

