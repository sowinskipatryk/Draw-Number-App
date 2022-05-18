package com.example.shufflr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // grasping the elements from xml layout
        val drawButton = findViewById<Button>(R.id.drawButton)
        val resultsTextView = findViewById<TextView>(R.id.resultTextView)
        val optionBar = findViewById<SeekBar>(R.id.optionBar)
        val progressTextView = findViewById<TextView>(R.id.progressTextView)

        // adding functionality at the click of a button
        drawButton.setOnClickListener {
            // creating a variable that draws a number between 1 and seekBar.progress
            // we are adding 2 to the progress as its value has to be equal to 1 at least
            // (0 + 2 = 2) where 2 is excluded hence we get 1
            // then we add 1 to the result because we want to choose from at least two options
            val rand = Random().nextInt(optionBar.progress + 2) + 1
            // assigning the result converted to string to the text view element
            resultsTextView.text = rand.toString()

        }

        // method that listens for the seek bar element to catch occuring changes
        optionBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // function executed when the value of the seek bar element changes
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // assigning the number of options from the seekbar to the text view element
                progressTextView.text = "${progress+2}"
            }

            // empty methods required by the object
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        }
    }