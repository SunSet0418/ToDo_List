package kr.soylatte.todo.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_setting.*
import kr.soylatte.todo.R
import android.widget.Toast



class Setting_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        setSupportActionBar(toolbar)
        checkbox.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {

            override fun onCheckedChanged(buttonView: CompoundButton,
                                 isChecked: Boolean) {
                if (buttonView.id == R.id.checkbox) {
                    if (isChecked) {
                        Toast.makeText(applicationContext, "Night Mode ON", Toast.LENGTH_SHORT).show()
                        nightmodech.setText("Night Mode ON")

                    } else {

                        Toast.makeText(applicationContext, "Noght Mode OFF", Toast.LENGTH_SHORT).show()
                        nightmodech.setText("Night Mode Off")
                    }
                }
            }
        })
    }
}
