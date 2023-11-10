package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpan.setOnClickListener { view ->
            tambahData()
            aturDataRecyclerView()
        }
    }
    private fun tambahData() {
        val nama = binding.etNama.text.toString()
        val nim = binding.etNim.text.toString()
        val databaseHandler: DatabaseHandler =
            DatabaseHandler(this)
        if (!nama.isEmpty() && !nim.isEmpty()) {
            val status =
                databaseHandler.tambahMahasiswa(DataModelClass(0, nama,
                    nim))
            if (status > -1) {
                Toast.makeText(applicationContext, "Data disimpan", Toast.LENGTH_LONG).show()
                        binding.etNama.text.clear()
                        binding.etNim.text.clear()
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Nama atau NIM tidak boleh kosong",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}