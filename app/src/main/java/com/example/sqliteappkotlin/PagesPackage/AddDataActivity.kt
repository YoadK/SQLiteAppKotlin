package com.example.sqliteappkotlin.PagesPackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqliteappkotlin.DataPackage.DataBaseHandler
import com.example.sqliteappkotlin.ModelsPackage.ModelFavorites
import com.example.sqliteappkotlin.R
import kotlinx.android.synthetic.main.activity_add_data.*

class AddDataActivity : AppCompatActivity() {

    var dbHandler: DataBaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        initDB()
        addData()
    }

    private fun initDB() {
        dbHandler = DataBaseHandler(this)
    }

    private fun addData() {
        btnSave.setOnClickListener {
            dbHandler!!.insertData(title = titleET.text.toString())
            startActivity(Intent(this, ListActivity::class.java))
        }
    }

}
