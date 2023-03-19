package com.az.letterlingo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.UserDictionary.Words
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import com.az.letterlingo.databinding.ActivityGameBinding
import com.google.android.material.navigation.NavigationView
import com.az.letterlingo.WordsActivity


class GameActivity : AppCompatActivity() {

    // on below line creating a
    // variable for activity binding.
    private lateinit var binding: ActivityGameBinding

    var obj = WordsActivity()
    var secondLists = obj.realWords
    //private val WORD = randomElement
    val randomElement = obj.realWords.asSequence().shuffled().find { true }


        lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
        lateinit var drawerLayout: DrawerLayout
        lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            binding = ActivityGameBinding.inflate(layoutInflater)
            setContentView(binding.root)
            drawerLayout = findViewById(R.id.my_drawer_layout)
            navigationView = findViewById(R.id.navigation)
            actionBarDrawerToggle =
                    ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
            drawerLayout.addDrawerListener(actionBarDrawerToggle)
            actionBarDrawerToggle.syncState()
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

            val username = intent.getStringExtra("Username")
            val showBTPlayAgain = findViewById<Button>(R.id.btPlayAgain)
            showBTPlayAgain.isVisible = false
            showBTPlayAgain.isEnabled = false

            navigationView.setNavigationItemSelectedListener { menuItem ->
                    val id = menuItem.itemId
                    drawerLayout.closeDrawer(GravityCompat.START)
                    when (id) {
                            R.id.nav_home -> {

                                    startActivity(Intent(this, MainActivity::class.java))
                                    finish()
                                    true
                            }
                            R.id.nav_settings -> {
                                    val intent = Intent(this@GameActivity, AllWordsActivity::class.java)
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

        // on below line calling method to
        // pass focus to next edit text.
        keepPassingFocus()



        val capitalWordsConverting = ArrayList<String>()
        //var count = 10
        for (word in secondLists)
        {
                capitalWordsConverting.add(word.uppercase())
        }

        val BTPlayAgain = findViewById<Button>(R.id.btPlayAgain)
        BTPlayAgain.setOnClickListener{
            finish()
            startActivity(getIntent())
        }


        val guess = findViewById<Button>(R.id.btGuess)
        guess.setOnClickListener {
            var wordEntered = findViewById<EditText>(R.id.txtWordGuess)
            var wordChoice = wordEntered.text
            if (wordChoice.trim().length>0 )
            {

                if(wordChoice.length != 5)
                {
                    Toast.makeText(this, "That is not a 5 letter word  :(\nTry Again", Toast.LENGTH_SHORT).show()
                }
                else
                {

                        //val entryChecking = realWords.filter { it == "$wordChoice" }
                        val match = capitalWordsConverting.contains("$wordChoice")

                        if(!match)
                        {
                                Toast.makeText(this, "WORD DOES NOT EXIST", Toast.LENGTH_SHORT).show()
                        }
                        else
                        {


                                //Entering into edit texts

                                val x1 = wordChoice?.get(0).toString().uppercase()
                                val x2 = wordChoice?.get(1).toString().uppercase()
                                val x3 = wordChoice?.get(2).toString().uppercase()
                                val x4 = wordChoice?.get(3).toString().uppercase()
                                val x5 = wordChoice?.get(4).toString().uppercase()

                                val et1 = findViewById<EditText>(R.id.edt_11)
                                val et2 = findViewById<EditText>(R.id.edt_12)
                                val et3 = findViewById<EditText>(R.id.edt_13)
                                val et4 = findViewById<EditText>(R.id.edt_14)
                                val et5 = findViewById<EditText>(R.id.edt_15)

                                val et6 = findViewById<EditText>(R.id.edt_21)
                                val et7 = findViewById<EditText>(R.id.edt_22)
                                val et8 = findViewById<EditText>(R.id.edt_23)
                                val et9 = findViewById<EditText>(R.id.edt_24)
                                val et10 = findViewById<EditText>(R.id.edt_25)

                                val et11 = findViewById<EditText>(R.id.edt_31)
                                val et12 = findViewById<EditText>(R.id.edt_32)
                                val et13 = findViewById<EditText>(R.id.edt_33)
                                val et14 = findViewById<EditText>(R.id.edt_34)
                                val et15 = findViewById<EditText>(R.id.edt_35)

                                val et16 = findViewById<EditText>(R.id.edt_41)
                                val et17 = findViewById<EditText>(R.id.edt_42)
                                val et18 = findViewById<EditText>(R.id.edt_43)
                                val et19 = findViewById<EditText>(R.id.edt_44)
                                val et20 = findViewById<EditText>(R.id.edt_45)

                                val et21 = findViewById<EditText>(R.id.edt_51)
                                val et22 = findViewById<EditText>(R.id.edt_52)
                                val et23 = findViewById<EditText>(R.id.edt_53)
                                val et24 = findViewById<EditText>(R.id.edt_54)
                                val et25 = findViewById<EditText>(R.id.edt_55)

                                val et26 = findViewById<EditText>(R.id.edt_61)
                                val et27 = findViewById<EditText>(R.id.edt_62)
                                val et28 = findViewById<EditText>(R.id.edt_63)
                                val et29 = findViewById<EditText>(R.id.edt_64)
                                val et30 = findViewById<EditText>(R.id.edt_65)

                                if (et1.text.toString().trim().isEmpty() && et2.text.toString().trim().isEmpty() && et3.text.toString().trim().isEmpty() && et4.text.toString().trim().isEmpty() && et5.text.toString().trim().isEmpty() )
                                {
                                        et1?.requestFocus()
                                        et1?.setText(x1)
                                        et2?.setText(x2)
                                        et3?.setText(x3)
                                        et4?.setText(x4)
                                        et5?.setText(x5)
                                }
                                else if(et6.text.toString().trim().isEmpty() && et7.text.toString().trim().isEmpty() && et8.text.toString().trim().isEmpty() && et9.text.toString().trim().isEmpty() && et10.text.toString().trim().isEmpty() )
                                {
                                        et6?.requestFocus()
                                        et6?.setText(x1)
                                        et7?.setText(x2)
                                        et8?.setText(x3)
                                        et9?.setText(x4)
                                        et10?.setText(x5)
                                }
                                else if(et11.text.toString().trim().isEmpty() && et12.text.toString().trim().isEmpty() && et13.text.toString().trim().isEmpty() && et14.text.toString().trim().isEmpty() && et15.text.toString().trim().isEmpty() )
                                {
                                        et11?.requestFocus()
                                        et11?.setText(x1)
                                        et12?.setText(x2)
                                        et13?.setText(x3)
                                        et14?.setText(x4)
                                        et15?.setText(x5)
                                }
                                else if(et16.text.toString().trim().isEmpty() && et17.text.toString().trim().isEmpty() && et18.text.toString().trim().isEmpty() && et19.text.toString().trim().isEmpty() && et20.text.toString().trim().isEmpty() )
                                {
                                        et16?.requestFocus()
                                        et16?.setText(x1)
                                        et17?.setText(x2)
                                        et18?.setText(x3)
                                        et19?.setText(x4)
                                        et20?.setText(x5)
                                }
                                else if(et21.text.toString().trim().isEmpty() && et22.text.toString().trim().isEmpty() && et23.text.toString().trim().isEmpty() && et24.text.toString().trim().isEmpty() && et25.text.toString().trim().isEmpty() )
                                {
                                        et21?.requestFocus()
                                        et21?.setText(x1)
                                        et22?.setText(x2)
                                        et23?.setText(x3)
                                        et24?.setText(x4)
                                        et25?.setText(x5)
                                }
                                else if(et26.text.toString().trim().isEmpty() && et27.text.toString().trim().isEmpty() && et28.text.toString().trim().isEmpty() && et29.text.toString().trim().isEmpty() && et30.text.toString().trim().isEmpty() )
                                {
                                        et26?.requestFocus()
                                        et26?.setText(x1)
                                        et27?.setText(x2)
                                        et28?.setText(x3)
                                        et29?.setText(x4)
                                        et30?.setText(x5)
                                }

                                Toast.makeText(this, "WORD EXISTS, ${wordEntered.text}", Toast.LENGTH_SHORT).show()
                                wordEntered.text.clear()
                        }

                }
            }
            else
            {
                Toast.makeText(this, "Please guess a 5 letter word", Toast.LENGTH_SHORT).show()
            }
        }

        Toast.makeText(this, "Pick a random 5 letter word " + username, Toast.LENGTH_SHORT).show()

        // on below line adding text change listener
        // for last edit texts of each row

        binding.edt15.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    // on below line calling validate row to
                    // check the word entered in that row.
                    validateRow(
                        binding.edt11,
                        binding.edt12,
                        binding.edt13,
                        binding.edt14,
                        binding.edt15
                    )
                }
            }

        })

        binding.edt25.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    // on below line calling validate row to
                    // check the word entered in that row.
                    validateRow(
                        binding.edt21,
                        binding.edt22,
                        binding.edt23,
                        binding.edt24,
                        binding.edt25
                    )
                }
            }

        })

        binding.edt35.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    // on below line calling validate row to
                    // check the word entered in that row.
                    validateRow(
                        binding.edt31,
                        binding.edt32,
                        binding.edt33,
                        binding.edt34,
                        binding.edt35
                    )
                }
            }

        })

        binding.edt45.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    // on below line calling validate row to
                    // check the word entered in that row.
                    validateRow(
                        binding.edt41,
                        binding.edt42,
                        binding.edt43,
                        binding.edt44,
                        binding.edt45
                    )
                }
            }

        })

        binding.edt55.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    // on below line calling validate row to
                    // check the word entered in that row.
                    validateRow(
                        binding.edt51,
                        binding.edt52,
                        binding.edt53,
                        binding.edt54,
                        binding.edt55
                    )
                }
            }

        })

        binding.edt65.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    // on below line calling validate row to
                    // check the word entered in that row.
                    validateRow(
                        binding.edt61,
                        binding.edt62,
                        binding.edt63,
                        binding.edt64,
                        binding.edt65
                    )
                }
            }

        })
    }





    private fun makeGameInactive() {
        // on below line disabling all
        // edit text to make game inactive.
        binding.edt11.isEnabled = false
        binding.edt12.isEnabled = false
        binding.edt13.isEnabled = false
        binding.edt14.isEnabled = false
        binding.edt15.isEnabled = false
        binding.edt21.isEnabled = false
        binding.edt22.isEnabled = false
        binding.edt23.isEnabled = false
        binding.edt24.isEnabled = false
        binding.edt25.isEnabled = false
        binding.edt31.isEnabled = false
        binding.edt32.isEnabled = false
        binding.edt33.isEnabled = false
        binding.edt34.isEnabled = false
        binding.edt35.isEnabled = false
        binding.edt41.isEnabled = false
        binding.edt42.isEnabled = false
        binding.edt43.isEnabled = false
        binding.edt44.isEnabled = false
        binding.edt45.isEnabled = false
        binding.edt51.isEnabled = false
        binding.edt52.isEnabled = false
        binding.edt53.isEnabled = false
        binding.edt54.isEnabled = false
        binding.edt61.isEnabled = false
        binding.edt62.isEnabled = false
        binding.edt63.isEnabled = false
        binding.edt64.isEnabled = false
        binding.edt65.isEnabled = false
    }

    private fun validateRow(
        edt1: EditText,
        edt2: EditText,
        edt3: EditText,
        edt4: EditText,
        edt5: EditText
    ) {
        // on below line creating variables
        // to get text from edit texts.
        val edt1Txt = edt1.text.toString()
        val edt2Txt = edt2.text.toString()
        val edt3Txt = edt3.text.toString()
        val edt4Txt = edt4.text.toString()
        val edt5Txt = edt5.text.toString()

        // on below line creating variables
        // to get each char from word.
        val w1 = randomElement?.get(0).toString().uppercase()
        val w2 = randomElement?.get(1).toString().uppercase()
        val w3 = randomElement?.get(2).toString().uppercase()
        val w4 = randomElement?.get(3).toString().uppercase()
        val w5 = randomElement?.get(4).toString().uppercase()

        // on below line comparing if text entered in edt is equal to other words.
        if (edt1Txt == w2 || edt1Txt == w3 || edt1Txt == w4 || edt1Txt == w5) {
            // on below line changing background color of that edt.
            edt1.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        // on below line comparing if text entered in edt is equal to other words.
        if (edt2Txt == w1 || edt2Txt == w3 || edt2Txt == w4 || edt2Txt == w5) {
            // on below line changing background color of that edt.
            edt2.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        // on below line comparing if text entered in edt is equal to other words.
        if (edt3Txt == w1 || edt3Txt == w2 || edt3Txt == w4 || edt3Txt == w5) {
            // on below line changing background color of that edt.
            edt3.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        // on below line comparing if text entered in edt is equal to other words.
        if (edt4Txt == w1 || edt4Txt == w2 || edt4Txt == w3 || edt4Txt == w5) {
            // on below line changing background color of that edt.
            edt4.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        // on below line comparing if text entered in edt is equal to other words.
        if (edt5Txt == w1 || edt5Txt == w2 || edt5Txt == w3 || edt5Txt == w4) {
            // on below line changing background color of that edt.
            edt5.setBackgroundColor(Color.parseColor("#ffff00"))
        }

        // on below line checking if word is equal to text in edt
        if (edt1Txt == w1) {
            // on below line changing background color of that edt.
            edt1.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        // on below line checking if word is equal to text in edt
        if (edt2Txt == w2) {
            // on below line changing background color of that edt.
            edt2.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        // on below line checking if word is equal to text in edt
        if (edt3Txt == w3) {
            // on below line changing background color of that edt.
            edt3.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        // on below line checking if word is equal to text in edt
        if (edt4Txt == w4) {
            // on below line changing background color of that edt.
            edt4.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        // on below line checking if word is equal to text in edt
        if (edt5Txt == w5) {
            // on below line changing background color of that edt.
            edt5.setBackgroundColor(Color.parseColor("#33cc33"))
        }

        // on below line checking if entered by users is present
        // in the word which user has to find.
        if (edt1Txt != w1 && edt1Txt != w2 && edt1Txt != w3 && edt1Txt != w4 && edt1Txt != w5) {
            // on below line changing background color of that edt.
            edt1.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt2Txt != w1 && edt2Txt != w2 && edt2Txt != w3 && edt2Txt != w4 && edt2Txt != w5) {
            // on below line changing background color of that edt.
            edt2.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt3Txt != w1 && edt3Txt != w2 && edt3Txt != w3 && edt3Txt != w4 && edt3Txt != w5) {
            // on below line changing background color of that edt.
            edt3.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt4Txt != w1 && edt4Txt != w2 && edt4Txt != w3 && edt4Txt != w4 && edt4Txt != w5) {
            // on below line changing background color of that edt.
            edt4.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt5Txt != w1 && edt5Txt != w2 && edt5Txt != w3 && edt5Txt != w4 && edt5Txt != w5) {
            // on below line changing background color of that edt.
            edt5.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        // below method is called if user is able to guess the word.
        if (edt1Txt == w1 && edt2Txt == w2 && edt3Txt == w3 && edt4Txt == w4 && edt5Txt == w5) {
            // on below line setting text and changing the visibility of text.
            //binding.idTVCongo.text = "Congratulations, you have guessed the right word."
            //binding.idTVCongo.visibility = View.VISIBLE
            // on below line calling below method to make game inactive.

            // on below line displaying toast message.
                val username = intent.getStringExtra("Username")
            Toast.makeText(
                applicationContext,
                "Congratulations $username, you have guessed the right word  ;)",
                Toast.LENGTH_LONG
            ).show()
            val disableGuess = findViewById<EditText>(R.id.txtWordGuess)
            disableGuess.isEnabled = false
            val disableGuessBt = findViewById<Button>(R.id.btGuess)
            disableGuessBt.isEnabled = false
            makeGameInactive()
            val showBTPlayAgain = findViewById<Button>(R.id.btPlayAgain)
            showBTPlayAgain.isVisible = true
            showBTPlayAgain.isEnabled = true
            return
        }

        // below method is called if user is not able to guess the word.
        if (edt5.id == R.id.edt_65) {
            // on below line setting text if user is not able to guess
            // the word and changing its visibility
            //binding.idTVCongo.text = "Sorry you couldn't guess the word."
            //binding.idTVCongo.visibility = View.VISIBLE
            // on below line calling
            // inactive to make game inactive.

            // on below line displaying toast message
            Toast.makeText(
                applicationContext,
                "Unluckkkyyyyy, get better :( ",
                Toast.LENGTH_LONG
            ).show()
            val disableGuess = findViewById<EditText>(R.id.txtWordGuess)
            disableGuess.isEnabled = false
            val disableGuessBt = findViewById<Button>(R.id.btGuess)
            disableGuessBt.isEnabled = false
            makeGameInactive()
            val showBTPlayAgain = findViewById<Button>(R.id.btPlayAgain)
            showBTPlayAgain.isVisible = true
            showBTPlayAgain.isEnabled = true

        }
    }

    private fun keepPassingFocus() {
        // on below line calling method pass focus to next
        // to pass focus to next edt for row 1.
        passFocusToNextEdt(binding.edt11, binding.edt12)
        passFocusToNextEdt(binding.edt12, binding.edt13)
        passFocusToNextEdt(binding.edt13, binding.edt14)
        passFocusToNextEdt(binding.edt14, binding.edt15)

        // on below line calling method pass focus to next
        // to pass focus to next edt for row 2.
        passFocusToNextEdt(binding.edt21, binding.edt22)
        passFocusToNextEdt(binding.edt22, binding.edt23)
        passFocusToNextEdt(binding.edt23, binding.edt24)
        passFocusToNextEdt(binding.edt24, binding.edt25)

        // on below line calling method pass focus to next
        // to pass focus to next edt for row 3.
        passFocusToNextEdt(binding.edt31, binding.edt32)
        passFocusToNextEdt(binding.edt32, binding.edt33)
        passFocusToNextEdt(binding.edt33, binding.edt34)
        passFocusToNextEdt(binding.edt34, binding.edt35)

        // on below line calling method pass focus to next
        // to pass focus to next edt for row 4.
        passFocusToNextEdt(binding.edt41, binding.edt42)
        passFocusToNextEdt(binding.edt42, binding.edt43)
        passFocusToNextEdt(binding.edt43, binding.edt44)
        passFocusToNextEdt(binding.edt44, binding.edt45)

        // on below line calling method pass focus to next
        // to pass focus to next edt for row 5.
        passFocusToNextEdt(binding.edt51, binding.edt52)
        passFocusToNextEdt(binding.edt52, binding.edt53)
        passFocusToNextEdt(binding.edt53, binding.edt54)
        passFocusToNextEdt(binding.edt54, binding.edt55)

        // on below line calling method pass focus to next
        // to pass focus to next edt for row 6.
        passFocusToNextEdt(binding.edt61, binding.edt62)
        passFocusToNextEdt(binding.edt62, binding.edt63)
        passFocusToNextEdt(binding.edt63, binding.edt64)
        passFocusToNextEdt(binding.edt64, binding.edt65)
    }

    private fun passFocusToNextEdt(edt1: EditText, edt2: EditText) {
        // on below line we are passing focus to
        // next edt is previous one is filled.
        edt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    edt2.requestFocus()
                }
            }

        })
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {

                if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
                        return true
                }
                return super.onOptionsItemSelected(item)
        }

        override fun onBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                        super.onBackPressed()
                }
        }



}
