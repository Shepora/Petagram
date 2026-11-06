package com.example.petagram


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MascotaAdaptador(private val mascotas: ArrayList<Mascota>) :
    RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mascota, parent, false)
        return MascotaViewHolder(v)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotas[position]

        holder.imgFoto.setImageResource(mascota.foto)
        holder.tvNombre.text = mascota.nombre
        holder.tvRating.text = mascota.rating.toString()

        // Hueso blanco = dar "like"
        holder.btnLike.setOnClickListener { v ->
            mascota.rating++
            holder.tvRating.text = mascota.rating.toString()
            Toast.makeText(v.context, "Le diste like a ${mascota.nombre}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = mascotas.size

    /** ViewHolder (clase anidada): guarda las vistas de cada item. */
    class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFoto: ImageView = itemView.findViewById(R.id.imgFoto)
        val btnLike: ImageButton = itemView.findViewById(R.id.btnLike)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
    }
}