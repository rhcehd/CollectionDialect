package com.example.collectingdialect.ui.collecting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.ItemRecordAndPlayBinding
import com.example.collectingdialect.ui.BaseViewModel

class RecordAdapter(private var viewModel: () -> CollectingViewModel): RecyclerView.Adapter<RecordViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemRecordAndPlayBinding>(layoutInflater, R.layout.item_record_and_play, parent, false)
        binding.viewModel = viewModel.invoke()
        return RecordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }
}

class RecordViewHolder(val binding: ItemRecordAndPlayBinding): RecyclerView.ViewHolder(binding.root)