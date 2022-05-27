package com.example.collectingdialect.ui

import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.collectingdialect.R
import com.google.android.material.textfield.MaterialAutoCompleteTextView

open class BaseViewModel: ViewModel(), Observable {
    companion object {
        @JvmStatic
        @BindingAdapter("custom:list")
        fun setList(view: MaterialAutoCompleteTextView, list: ArrayList<String>) {
            val adapter = ArrayAdapter(view.context, R.layout.item_region_dropdown, R.id.region_text, list)
            view.setAdapter(adapter)
        }

        @JvmStatic
        @BindingAdapter("custom:adapter")
        fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
            view.adapter = adapter
        }

        @JvmStatic
        @BindingAdapter("script:image")
        fun setImage(view: ImageView, drawableResId: Int) {
            Glide.with(view).load(drawableResId).centerCrop().into(view)
        }
    }

    private val propertyChangeRegistry = PropertyChangeRegistry()
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

    fun notifyChange(id: Int) {
        propertyChangeRegistry.notifyChange(this, id)
    }

    open fun onClickPreviousButton(view: View) {

    }

    open fun onClickNextButton(view:View) {

    }
}