package com.example.wordle

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {
    @Insert
    suspend fun insertAll(vararg words: Word)

    @Query("SELECT * from word")
    suspend fun getAll(): List<Word>

    @Query("SELECT count(*) from word")
    suspend fun countAll(): Int

    @Query("DELETE from word")
    suspend fun deleteAll()
}