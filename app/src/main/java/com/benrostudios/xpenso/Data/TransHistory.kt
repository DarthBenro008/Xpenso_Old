package com.benrostudios.xpenso.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



    @Entity(tableName = "TransHistory")
    class TransHistory(
        //All the columns of room
        @PrimaryKey(autoGenerate = true)
        var uid: Int?=0,

                  @field:ColumnInfo(name = "entity")
                  var entity: String,
                  @field:ColumnInfo(name = "amount")
                  var amt: Double,
                  @field:ColumnInfo(name = "phyvirtu")
                  var pv: String,
                  @field:ColumnInfo(name = "type")
                  var type: String,
                  @field:ColumnInfo(name = "description")
                  var descp: String,
                  @field:ColumnInfo(name = "time")
                  var timo: String)
    {
        constructor():this(null,"",0.0,"","","",
            "")
    }



