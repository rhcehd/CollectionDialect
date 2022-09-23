package com.example.collectingdialect.ui.collecting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.collectingdialect.R
import com.example.collectingdialect.record.RecordManager
import com.example.collectingdialect.databinding.ItemRecordAndPlayBinding
import java.io.File

class RecordAdapter(private var viewModelRequester: () -> CollectingViewModel): RecyclerView.Adapter<RecordViewHolder>() {
    private val recordList = arrayListOf<File>()
    private val viewHolderList = arrayListOf<RecordViewHolder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemRecordAndPlayBinding>(layoutInflater, R.layout.item_record_and_play, parent, false)
        binding.viewModel = viewModelRequester.invoke()
        return RecordViewHolder(binding).apply {
            viewHolderList.add(this)
        }
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        val file = recordList[position]
        holder.binding.fileName = file.name
        holder.binding.indexString = if(position + 1 < 10) {
            "0${position + 1}."
        } else {
            "${position + 1}."
        }
        val recordDirectory = holder.binding.viewModel?.recordDirectory
        holder.binding.recordTimeString = RecordManager.getRecordTime(recordDirectory, file.name)
    }

    override fun getItemCount(): Int {
        return recordList.size
    }

    fun refreshRecordList(recordDirectory: File?, fileNamePrefix: String) {
        val recordList = RecordManager.getRecordListStartWith(recordDirectory, fileNamePrefix)
        this.recordList.clear()
        this.recordList.addAll(recordList)
        viewHolderList.forEach {
            it.binding.recordButton.setBackgroundResource(R.drawable.re_recording)
        }
        notifyDataSetChanged()

    }
}

class RecordViewHolder(val binding: ItemRecordAndPlayBinding): RecyclerView.ViewHolder(binding.root)