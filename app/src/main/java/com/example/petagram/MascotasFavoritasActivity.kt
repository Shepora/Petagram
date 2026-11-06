package com.example.petagram


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/** En el futuro guardará las últimas 5 mascotas que recibieron like. */
class MascotasFavoritasActivity : AppCompatActivity() {

    private val favoritas = ArrayList<Mascota>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favoritas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // flecha "<"

        val rv = findViewById<RecyclerView>(R.id.rvFavoritas)
        rv.layoutManager = LinearLayoutManager(this)

        favoritas.add(Mascota("Ronny", R.drawable.dog_2, 3))
        favoritas.add(Mascota("Catty", R.drawable.dog_1, 5))
        favoritas.add(Mascota("Luna", R.drawable.dog_3, 4))
        favoritas.add(Mascota("Rocky", R.drawable.dog_4, 2))
        favoritas.add(Mascota("Coco", R.drawable.dog_5, 1))
        rv.adapter = MascotaAdaptador(favoritas)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
