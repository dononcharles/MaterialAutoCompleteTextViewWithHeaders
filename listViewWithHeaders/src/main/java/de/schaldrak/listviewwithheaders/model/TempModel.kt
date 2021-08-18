package de.schaldrak.listviewwithheaders.model

/**
 * @author komi.donon
 * @since 8/17/2021
 */
class TempModel(val headerName: String?, val childName: String?, val idChild: Int?, val isHeader: Boolean = false) {
    override fun toString(): String = childName.toString()
}