package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var box_one_text: TextView
    private lateinit var box_two_text: TextView
    private lateinit var box_three_text: TextView
    private lateinit var box_four_text: TextView
    private lateinit var box_five_text: TextView
    private lateinit var main: ConstraintLayout
    private lateinit var button_red: Button
    private lateinit var button_yellow: Button
    private lateinit var button_green: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setListeners();
    }

    private fun setListeners()  {
        box_one_text = findViewById(R.id.box_one_text);
        box_two_text = findViewById(R.id.box_two_text);
        box_three_text = findViewById(R.id.box_three_text);
        box_four_text = findViewById(R.id.box_four_text);
        box_five_text = findViewById(R.id.box_five_text);
        main = findViewById(R.id.main);
        button_red = findViewById(R.id.button_red);
        button_yellow = findViewById(R.id.button_yellow);
        button_green = findViewById(R.id.button_green);

        val clickableViews: List<View> = listOf(box_one_text, box_two_text, box_three_text, box_four_text, box_five_text, main, button_red, button_yellow, button_green);

        for(item in clickableViews) {
            item.setOnClickListener{ makeColored(it) };
        }
    }

    private fun makeColored(view: View) = when(view.id) {
        R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY);
        R.id.box_two_text -> view.setBackgroundColor(Color.GRAY);

        R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light);
        R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark);
        R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light);

        R.id.button_red -> box_three_text.setBackgroundResource(R.color.my_red)
        R.id.button_yellow -> box_four_text.setBackgroundResource(R.color.my_yellow)
        R.id.button_green -> box_five_text.setBackgroundResource(R.color.my_green)

        else -> view.setBackgroundColor(Color.LTGRAY);
    }
}