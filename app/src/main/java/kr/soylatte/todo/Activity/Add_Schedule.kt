package kr.soylatte.todo.Activity

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_schedule.*
import kr.soylatte.todo.Data.DataManager
import kr.soylatte.todo.R
import android.content.Intent
import android.util.Log
import android.widget.Toast


class Add_Schedule : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val color = Color.parseColor("#6dcaff")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_schedule)
        gettitle.background.setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }

    fun send(V : View){
        val dm = DataManager()
        val intent = Intent(this@Add_Schedule, MainActivity::class.java)
        val sp : SharedPreferences = getSharedPreferences("ToDo", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sp.edit()
        val title : String = gettitle.getText().toString()

        val data : ArrayList<String> = dm.StringToArrayList(sp.getString("ToDo",null))

        Log.e("Before DATA ", data.toString())

        data.add(title)

        Log.e("New DATA ", gettitle.getText().toString())

        dm.ArrayListToString(data, editor, "ToDo")

        Log.e("After DATA ", sp.getString("ToDo", null))

        startActivity(intent)
    }

    fun back(V : View){
        val intent = Intent(this@Add_Schedule, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
