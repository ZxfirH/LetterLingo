package com.az.letterlingo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.UserDictionary.Words
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.az.letterlingo.databinding.ActivityAllwordsBinding
import com.google.android.material.navigation.NavigationView

class AllWordsActivity : AppCompatActivity()  {

    private lateinit var newRecyclerView: RecyclerView

    private lateinit var binding: ActivityAllwordsBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAllwordsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawerLayout = findViewById(R.id.my_drawer_layout_format)
        navigationView = findViewById(R.id.navigation_all)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val username = intent.getStringExtra("Username")

        navigationView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            drawerLayout.closeDrawer(GravityCompat.START)
            when (id) {
                R.id.nav_home -> {

                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_play -> {
                    val intent = Intent(this@AllWordsActivity, GameActivity::class.java)
                    intent.putExtra("Username", "$username")
                    startActivity(intent)
                    finish()
                    true
                }

                else -> {
                    false
                }

            }
        }


        //var aaw = intent.getSerializableExtra("Words") as ArrayList<String>
        //val allAvailableWordss = intent.getStringArrayExtra("Words" )
        //val allWordss = intent.getStringExtra("Words")

        var obj = WordsActivity()
        var displayWordArray = obj.realWords
        Toast.makeText(this,"$displayWordArray", Toast.LENGTH_LONG).show()

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)





        getUserData()


    }

    private fun getUserData() {
        //val allWordsToShow = intent.getStringArrayExtra("Words")
        /*if (allWordsToShow != null) {
            for(i in allWordsToShow.indices){

                val eachWord = allWordsToShow[i]

                newArrayList.add(eachWord)
            }
        }*/

        var obj = WordsActivity()
        var displayWordArray = obj.realWords
        //for(item in displayWordArray){
        //    newArrayList
       // }


        //newArrayList.add("Farrrtttt")
        //newArrayList.add("Poooooop")
        //newArrayList.add("kaaaaaak")

        newRecyclerView.adapter = ItemAdapter(displayWordArray)

    }
}
