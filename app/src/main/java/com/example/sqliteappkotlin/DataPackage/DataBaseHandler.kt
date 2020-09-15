package com.example.sqliteappkotlin.DataPackage

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.sqliteappkotlin.ModelsPackage.ModelFavorites

val DATABASENAME = "MY DATABASE"
val TABLENAME = "Users"
val COL_TITLE = "title"
val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(
    context, DATABASENAME, null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $TABLENAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_TITLE VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onCreate(db);
    }

    fun insertData(modelFavorites: ModelFavorites) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_TITLE, modelFavorites.title)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    fun readData(): MutableList<ModelFavorites> {
        val list: MutableList<ModelFavorites> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val modelFavorites = ModelFavorites()
                modelFavorites.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                modelFavorites.title = result.getString(result.getColumnIndex(COL_TITLE))
                list.add(modelFavorites)
            } while (result.moveToNext())
        }
        return list
    }
}