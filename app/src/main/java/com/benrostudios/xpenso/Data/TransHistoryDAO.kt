package com.benrostudios.xpenso.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TransHistoryDAO {

    @get:Query("SELECT * from TransHistory ORDER BY uid DESC")
    val allHistory: List<TransHistory>

    @get:Query("SELECT COUNT(*) FROM TransHistory")
    val count: Int

    @Insert
    fun insert(historyItem: TransHistory)

    @Delete
    fun delete(historyItem: TransHistory)

    @Query("DELETE FROM TransHistory")
    fun deleteAllHistory()
}