package com.example.collectingdialect.ui

import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

open class BaseViewModel: ViewModel(), Observable {
    companion object {
        @JvmStatic
        @BindingAdapter("adapter")
        fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
            view.adapter = adapter
        }

        @JvmStatic
        @BindingAdapter("error")
        fun setError(view: TextInputLayout, error: String?) {
            view.error = error
        }

        @JvmStatic
        @BindingAdapter("dropdown")
        fun setDropdown(view: MaterialAutoCompleteTextView, array: Array<String>) {
            val adapter = ArrayAdapter(view.context, android.R.layout.simple_dropdown_item_1line, array)
            view.setAdapter(adapter)
        }

        @JvmStatic
        @BindingAdapter("scriptArray", "scriptIndex", requireAll = true)
        fun setScriptIndex(view: TextView, array: Array<String>, index: Int) {
            if(array.isEmpty()) {
                return
            }
            view.text = array[index]
        }

        @JvmStatic
        @BindingAdapter("imageArray", "imageIndex", requireAll = true)
        fun setScriptIndex(view: ImageView, array: Array<Int>, index: Int) {
            if(array.isEmpty()) {
                return
            }
            view.setImageResource(array[index])
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
}