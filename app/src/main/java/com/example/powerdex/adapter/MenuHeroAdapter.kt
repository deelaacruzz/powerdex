package com.example.powerdex.adapter

import android.graphics.Rect
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.powerdex.data.model.SuperHeroModel
import com.example.powerdex.databinding.ItemMenuHeroBinding

class MenuHeroAdapter(
    private val arrayList: ArrayList<SuperHeroModel> = arrayListOf(),
    private val listener: (SuperHeroModel) -> Unit
) :
    RecyclerView.Adapter<MenuHeroAdapter.MenuHeroHolder>() {

    private var list: ArrayList<SuperHeroModel> = arrayListOf()

    init {
        list = arrayList
    }

    class MenuHeroHolder(private val itemRoot: ItemMenuHeroBinding) :
        RecyclerView.ViewHolder(itemRoot.root) {
        fun bind(data: SuperHeroModel) {
            itemRoot.tvNombre.text = data.name
            Glide.with(itemRoot.root.context).load(data.image.url).into(itemRoot.ivImage)



        }
    }




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuHeroHolder {
        val rootView =
            ItemMenuHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuHeroHolder(rootView)
    }

    override fun onBindViewHolder(holder: MenuHeroHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            listener(list[position])
        }

    }

    override fun getItemCount(): Int = list.size
}