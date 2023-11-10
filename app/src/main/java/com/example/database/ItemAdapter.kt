package com.example.database

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.database.databinding.ItemsRowBinding


class ItemAdapter (val context: Context, val items: ArrayList<DataModelClass>) :
RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val binding = ItemsRowBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder (binding)
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val item = items.get(position)
        holder.binding.tvNama.text = item.nama
        holder.binding.tvNim.text = item.nim
//Mengabdate warna background
        if (position % 2 == 0) {
            holder.binding.llMain.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorLightGrey
                )
            )
        } else {
            holder.binding.llMain.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

