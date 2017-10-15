package kr.soylatte.todo.Activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kr.soylatte.todo.Data.DataManager
import kr.soylatte.todo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val dm = DataManager()
        var data = ArrayList<String>()
        val sp = getSharedPreferences("ToDo", Context.MODE_PRIVATE)
        data = dm.StringToArrayList(sp.getString("ToDo", null))
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        listview.setAdapter(adapter)
    }

    fun add(V : View){
        val intent = Intent(this@MainActivity, Add_Schedule::class.java)
        startActivity(intent)
    }
    fun more(V : View){
        val intent = Intent(this@MainActivity, Setting_Activity::class.java)
        startActivity(intent)
    }

}
