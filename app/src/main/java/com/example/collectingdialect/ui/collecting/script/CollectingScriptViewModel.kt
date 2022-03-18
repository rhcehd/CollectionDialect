package com.example.collectingdialect.ui.collecting.script

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.ItemScriptImageBinding
import com.example.collectingdialect.ui.collecting.CollectingViewModel

class CollectingScriptViewModel: CollectingViewModel() {

    val adapter = ScriptImageAdapter()

    override fun onClickNextButton(view: View) {
        super.onClickNextButton(view)
    }

    override fun onClickPreviousButton(view: View) {
        super.onClickPreviousButton(view)
    }

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
}