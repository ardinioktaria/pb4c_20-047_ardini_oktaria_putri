package com.example.tugaspratikum6

import androidx.room.*

@Dao
interface UserDao {

    // Mengambil semua data
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    // Mengambil data berdasarkan ID
    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user WHERE id= :id")
    fun get(id: Int) : User

    @Update
    fun update(user: User)

}