package com.az.letterlingo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play = findViewById<Button>(R.id.btPlay)

        play.setOnClickListener {
            var name = findViewById<EditText>(R.id.txtPlayerName)
            var emptyName = name.text

            if (emptyName.trim().length>0 )
            {
                //Toast.makeText(this, "Lets Play, " + name.text, Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity,GameActivity::class.java)
                intent.putExtra("Username", "$emptyName")
                startActivity(intent)
                finish()

                //startActivity(Intent(this, GameActivity::class.java).apply { putExtra("playerName", emptyName) })
            }
            else
            {
                Toast.makeText(this, "Enter a Name to Play", Toast.LENGTH_SHORT).show()
            }
        }

        val help = findViewById<ImageButton>(R.id.btHelp)

        help.setOnClickListener{
            Toast.makeText(this, "Click Play  ;)", Toast.LENGTH_SHORT).show()
        }

    }

}