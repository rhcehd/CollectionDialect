package com.example.collectingdialect.ui.collecting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.collectingdialect.R
import com.example.collectingdialect.databinding.ItemRecordAndPlayBinding
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import java.io.File

class RecordAdapter(private var viewModelRequester: () -> CollectingViewModel): RecyclerView.Adapter<RecordViewHolder>() {
    private val recordList = arrayListOf<File>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemRecordAndPlayBinding>(layoutInflater, R.layout.item_record_and_play, parent, false)
        binding.viewModel = viewModelRequester.invoke()
        return RecordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.binding.file = recordList[position]
        holder.binding.indexString = if(position + 1 < 10) {
            "0${position + 1}."
        } else {
            "${position + 1}."
        }
    }

    override fun getItemCount(): Int {
        return recordList.size
    }

    fun requestRecordList(fileNamePrefix: String) {
        val context = MainActivity.contextRequester?.invoke()
        if(context != null) {
            this.recordList.clear()
            val mediaDirectory = context.filesDir
            val recordList = mediaDirectory?.listFiles { file ->
                file.name.startsWith(fileNamePrefix)
            }?: emptyArray()
            this.recordList.addAll(recordList)
            notifyDataSetChanged()
        } else {
            showToast("파일을 불러올 수 없습니다. 앱을 재시작 후 이용해주세요")
        }
    }
}

class RecordViewHolder(val binding: ItemRecordAndPlayBinding): RecyclerView.ViewHolder(binding.root)