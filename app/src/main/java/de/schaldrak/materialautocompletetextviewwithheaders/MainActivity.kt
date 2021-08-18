package de.schaldrak.materialautocompletetextviewwithheaders

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout
import de.schaldrak.listviewwithheaders.adapter.CustomAdapter
import de.schaldrak.listviewwithheaders.model.TempModel
import de.schaldrak.listviewwithheaders.tools.doAfterItemSelected
import de.schaldrak.listviewwithheaders.tools.setSelectedItem

class MainActivity : AppCompatActivity() {

    private val tmpList: MutableList<TempModel> = mutableListOf()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListItem()
        val cakesTiet = findViewById<MaterialAutoCompleteTextView>(R.id.cakesTiet)
        val cakesTil = findViewById<TextInputLayout>(R.id.cakesTil)

        cakesTiet.setAdapter(CustomAdapter(this, tmpList))
        // to preselect a position
        cakesTiet.setSelectedItem(2)

        cakesTil.doAfterItemSelected { selectedIndex ->
            Log.i(this::class.java.canonicalName, "Selected Item << name: ${tmpList[selectedIndex]}, id: ${tmpList[selectedIndex].idChild}")

            findViewById<TextView>(R.id.showTextTv).text = "Selected Item << name: ${tmpList[selectedIndex]}, id: ${tmpList[selectedIndex].idChild}"
        }
    }

    private fun setListItem() {
        tmpList.add(TempModel(headerName = "Cake header 1", childName = null, idChild = null, isHeader = true))
        tmpList.add(TempModel(headerName = "", childName = "Cake 1", idChild = 1, isHeader = false))
        tmpList.add(TempModel(headerName = "", childName = "Cake 2", idChild = 2, isHeader = false))
        tmpList.add(TempModel(headerName = "", childName = "Cake 3", idChild = 3, isHeader = false))
        tmpList.add(TempModel(headerName = "", childName = "Cake 4", idChild = 4, isHeader = false))
        tmpList.add(TempModel(headerName = "Cake header 2", childName = null, idChild = null, isHeader = true))
        tmpList.add(TempModel(headerName = "", childName = "Cake 5", idChild = 5, isHeader = false))
        tmpList.add(TempModel(headerName = "", childName = "Cake 6", idChild = 6, isHeader = false))
        tmpList.add(TempModel(headerName = "", childName = "Cake 7", idChild = 7, isHeader = false))
        tmpList.add(TempModel(headerName = "", childName = "Cake 8", idChild = 8, isHeader = false))
    }
}