package com.example.plantapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    //variables
    private lateinit var imageViewPlant: ImageView
    private var health = 100
    private var water = 0
    private var sunlight = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageViewPlant = findViewById(R.id.imageViewPlant)

        //buttons
        val buttonWater = findViewById<Button>(R.id.buttonWater)
        val buttonFertilize = findViewById<Button>(R.id.buttonFertilize)
        val buttonSun = findViewById<Button>(R.id.buttonSun)



        updateUI()

        buttonWater.setOnClickListener {
            val waterAnimation = null
            imageViewPlant.startAnimation(waterAnimation)
            waterPlant()
            updateUI()
            imageViewPlant.setImageResource(R.drawable.cactus_happy)
        }

        buttonSun.setOnClickListener {
            val sunAnimation = null
            imageViewPlant.startAnimation(sunAnimation)
            putPlantInSun()
            updateUI()
        }

        buttonFertilize.setOnClickListener {
            val fertilizeAnimation = null
            imageViewPlant.startAnimation(fertilizeAnimation)
            fertilizePlant()
            updateUI()
        }
    }

    //methods
    private fun waterPlant() {
        sunlight -= 5
        if (water < 0) water = 0
        if (water < 100) water += 10
    }

    private fun fertilizePlant() {
        health = 100
    }

    private fun putPlantInSun() {
        health -= 10
        if (health > 100) health = 100
        sunlight += 10
        if (water > 100) water = 100
        water -= 5
        if (sunlight < 0) sunlight = 0
    }

    private fun updateUI() {
        val textViewHealth = findViewById<TextView>(R.id.textViewHealth)
        val textViewSun = findViewById<TextView>(R.id.textViewSun)
        val textViewWater = findViewById<TextView>(R.id.textViewWater)

        textViewWater.text = "Water: $water"
        textViewSun.text = "Sun: $sunlight"
        textViewHealth.text = "Health: $health"

    }
}
