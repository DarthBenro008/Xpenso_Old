package com.benrostudios.xpenso.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



    @Entity(tableName = "TransHistory")
    class TransHistory(
                  @field:ColumnInfo(name = "entity")
                  val entity: String,
                  @field:ColumnInfo(name = "amount")
                  val amt: Float,
                  @field:ColumnInfo(name = "phyvirtu")
                  val pv: String,
                  @field:ColumnInfo(name = "type")
                  val type: String,
                  @field:ColumnInfo(name = "description")
                  val descp: String)

        @PrimaryKey(autoGenerate = true)
        var uid: Int = 0
