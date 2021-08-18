package de.schaldrak.listviewwithheaders.tools

import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

/**
 * @author komi.donon
 * @since 8/18/2021
 */
fun MaterialAutoCompleteTextView.setSelectedItem(position: Int) {
    adapter?.takeIf { listAdapter -> !listAdapter.isEmpty }?.let { listAdapter ->
        if (position in 0 until listAdapter.count) {
            setText(listAdapter.getItem(position).toString(), false)
        }
    }
}

fun TextInputLayout.doAfterItemSelected(onItemSelected: (Int) -> Unit) {
    (editText as? AutoCompleteTextView)?.setOnItemClickListener { _, _, position, _ -> onItemSelected(position) }
}