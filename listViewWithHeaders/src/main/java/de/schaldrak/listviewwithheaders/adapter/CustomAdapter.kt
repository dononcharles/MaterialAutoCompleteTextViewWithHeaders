package de.schaldrak.listviewwithheaders.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.schaldrak.listviewwithheaders.R
import de.schaldrak.listviewwithheaders.model.TempModel

/**
 * @author komi.donon
 * @since 8/17/2021
 */
class CustomAdapter(context: Context, items: MutableList<TempModel>) : ArrayAdapter<TempModel>(context, 0, items) {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v: View?
        val dataItem = getItem(position)
        if (dataItem?.isHeader == true) {
            v = mInflater.inflate(R.layout.header_item, null)
            (v.findViewById(R.id.headerTile) as TextView).let { headerTile ->
                headerTile.setOnClickListener { headerTile.setOnClickListener(null) }
                headerTile.text = dataItem.headerName
            }
        } else {
            v = mInflater.inflate(R.layout.child_row_item, null)
            (v.findViewById(R.id.rowTitle) as TextView).let { rowTitle -> rowTitle.text = dataItem?.childName }
        }
        return v
    }
}