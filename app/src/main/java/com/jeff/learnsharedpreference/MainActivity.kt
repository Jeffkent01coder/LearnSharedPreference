package com.jeff.learnsharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jeff.learnsharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)


        //mode means only this app can access
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        binding.saveNote.setOnClickListener {
            val note = binding.note.text.toString()
            val sharedEdit = sharedPreferences.edit()
            sharedEdit.putString("note", note)
            sharedEdit.apply()
            Toast.makeText(this, "Note Saved Successfully", Toast.LENGTH_SHORT).show()
            binding.note.text.clear()
        }

        binding.displayNotes.setOnClickListener {
            val storedNote = sharedPreferences.getString("note", "")
            binding.notes.text = "$storedNote"
        }

    }
}