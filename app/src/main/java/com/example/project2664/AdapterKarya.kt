package com.example.project2664

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project2664.model.KaryaModel

class AdapterKarya(private val list: ArrayList<KaryaModel>) :
    RecyclerView.Adapter<AdapterKarya.KaryaViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterKarya.KaryaViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardview_hasilkarya,
            parent, false)

        return KaryaViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: AdapterKarya.KaryaViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class KaryaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textJudul1: TextView = itemView.findViewById(R.id.textJudul)
        val textNama: TextView = itemView.findViewById(R.id.textNama)
        val image: ImageView = itemView.findViewById(R.id.imageKarya)

        fun bind(data: KaryaModel) {
            val nama1: String = data.name
            val nama: String = data.namasi
            val gambar: Bitmap = data.image

            textJudul1.text = nama1
            textNama.text = nama
            image.setImageBitmap(gambar)
        }
    }
}