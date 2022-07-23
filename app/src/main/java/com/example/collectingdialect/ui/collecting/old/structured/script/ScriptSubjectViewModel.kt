package com.example.collectingdialect.ui.collecting.old.structured.script

import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.Bindable
import androidx.navigation.findNavController
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.ui.collecting.SubjectViewModel

class ScriptSubjectViewModel: SubjectViewModel() {
    var regionText: String = ""
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.regionText)
            }
        }

    override fun onClickButton1(view: View) {
        super.onClickButton1(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_AGRICULTURE))
    }

    override fun onClickButton2(view: View) {
        super.onClickButton2(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_FAMILY))
    }

    override fun onClickButton3(view: View) {
        super.onClickButton3(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_CLOTHING))
    }

    override fun onClickButton4(view: View) {
        super.onClickButton4(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_FOOD))
    }

    override fun onClickButton5(view: View) {
        super.onClickButton5(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_SHELTER))
    }

    override fun onClickButton6(view: View) {
        super.onClickButton6(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_NATURE))
    }

    override fun onClickButton7(view: View) {
        super.onClickButton7(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_HEALTH))
    }

    override fun onClickButton8(view: View) {
        super.onClickButton8(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_CUSTOM))
    }

    override fun onClickButton9(view: View) {
        super.onClickButton9(view)
        view.findNavController().navigate(R.id.scriptFragment, bundleOf(KEY_SUBJECT to SUBJECT_EMERGENCY))
    }
}