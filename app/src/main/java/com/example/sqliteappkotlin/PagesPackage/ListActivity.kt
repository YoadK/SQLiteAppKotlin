package com.example.sqliteappkotlin.PagesPackage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqliteappkotlin.AdaptersPackage.CustomAdapterFavorites
import com.example.sqliteappkotlin.DataPackage.DataBaseHandler
import com.example.sqliteappkotlin.ModelsPackage.ModelFavorites
import com.example.sqliteappkotlin.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    var dbHandler: DataBaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initDB()
        buttons()
    }

    private fun initDB() {
        dbHandler = DataBaseHandler(this)
        initRecyclerView(dbHandler!!.readData())
    }

    private fun initRecyclerView(dataList: List<ModelFavorites>) {
        recyclerView.adapter = CustomAdapterFavorites(dataList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun buttons() {
        btnAdd.setOnClickListener {
            startActivity(Intent(this, AddDataActivity::class.java))
        }
    }

}
