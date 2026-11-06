package com.example.petagram


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val mascotas = ArrayList<Mascota>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        val rvMascotas = findViewById<RecyclerView>(R.id.rvMascotas)

        rvMascotas.layoutManager = LinearLayoutManager(this)

        inicializarMascotas()
        rvMascotas.adapter = MascotaAdaptador(mascotas)

        findViewById<FloatingActionButton>(R.id.fabCamara).setOnClickListener { v ->
            Snackbar.make(v, "Subir foto (próximamente)", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun inicializarMascotas() {
        mascotas.add(Mascota("Catty", R.drawable.dog_1, 5))
        mascotas.add(Mascota("Ronny", R.drawable.dog_2, 3))
        mascotas.add(Mascota("Luna", R.drawable.dog_3, 4))
        mascotas.add(Mascota("Rocky", R.drawable.dog_4, 2))
        mascotas.add(Mascota("Coco", R.drawable.dog_5, 1))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        menu.findItem(R.id.action_favoritas).actionView?.setOnClickListener {
            startActivity(Intent(this, MascotasFavoritasActivity::class.java))
        }
        return true
    }
}