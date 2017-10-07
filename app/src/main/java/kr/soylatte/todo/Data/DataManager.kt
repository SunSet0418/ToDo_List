package kr.soylatte.todo.Data

import org.json.JSONArray
import org.json.JSONException
import android.content.SharedPreferences

class DataManager {

    fun StringToArrayList(data: String?): ArrayList<String> {
        val arraylist = ArrayList<String>()
        val json = data
        if (json != null) {
            try {
                val a = JSONArray(json)
                for (i in 0..a.length() - 1) {
                    val url = a.optString(i)
                    arraylist.add(url)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

        }
        return arraylist
    }

    fun ArrayListToString(arraylist: ArrayList<String>?, editor: SharedPreferences.Editor, name : String) {
        if (arraylist != null && !arraylist.isEmpty()) {

            val a = JSONArray()

            for (i in 0..arraylist.size - 1) {

                a.put(arraylist[i])
            }
            editor.putString(name, a.toString())
        }
        else {
            editor.putString(name, null)
        }
        editor.apply()
    }
}