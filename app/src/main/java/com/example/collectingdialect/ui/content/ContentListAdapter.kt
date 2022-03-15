package com.example.collectingdialect.ui.content

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.ItemContentListBinding

class ContentListAdapter(private val viewModelRequester: () -> ContentViewModel): RecyclerView.Adapter<ContentListViewHolder>() {
    private val contentList: ArrayList<String> = arrayListOf("(1) 그림 설명하기", "(2) 인터뷰", "(3) 사물 이름 말하기")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemContentListBinding>(layoutInflater, R.layout.item_content_list, parent, false)
        binding.viewModel = viewModelRequester.invoke()
        return ContentListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentListViewHolder, position: Int) {
        holder.binding.data = contentList[position]
        holder.binding.position = position
    }

    override fun getItemCount(): Int = contentList.size
}

class ContentListViewHolder(val binding: ItemContentListBinding): RecyclerView.ViewHolder(binding.root)
