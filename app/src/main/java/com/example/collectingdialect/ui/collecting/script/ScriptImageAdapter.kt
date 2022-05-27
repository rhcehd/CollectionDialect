package com.example.collectingdialect.ui.collecting.script

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.ItemScriptImageBinding

class ScriptImageAdapter: RecyclerView.Adapter<ScriptImageViewHolder>() {
    private val scriptImageList = arrayListOf(R.drawable.corner_ball, R.drawable.flat_tire, R.drawable.highway)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScriptImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemScriptImageBinding>(layoutInflater, R.layout.item_script_image, parent, false)
        return ScriptImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScriptImageViewHolder, position: Int) {
        holder.binding.data = scriptImageList[position]
    }

    override fun getItemCount(): Int = scriptImageList.size
}

class ScriptImageViewHolder(val binding: ItemScriptImageBinding): RecyclerView.ViewHolder(binding.root)