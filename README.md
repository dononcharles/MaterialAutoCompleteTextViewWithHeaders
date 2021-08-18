![](https://jitpack.io/v/dononcharles/MaterialAutoCompleteTextViewWithHeaders.svg)
https://jitpack.io/#dononcharles/MaterialAutoCompleteTextViewWithHeaders

# ListViewWithHeaders
Timer custom dialog is a second converter tool. It converts hours, minutes and seconds into seconds.

# How to use
* Add dependency
```gradle
allprojects {
  repositories {
      maven { url 'https://jitpack.io' }
  }
}
```
```gradle
 implementation implementation 'com.github.dononcharles:MaterialAutoCompleteTextViewWithHeaders:Tag@aar'
```
* Add TextInputEditText in your layout file
```xml
<com.google.android.material.textfield.TextInputLayout
        android:id="@+id/cakesTil"
        style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.Dense.ExposedDropdownMenu"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:visibility="visible">

        <com.google.android.material.textfield.MaterialAutoCompleteTextView
            android:id="@+id/cakesTiet"
            style="@style/ThemeOverlay.MaterialComponents.TextInputEditText.OutlinedBox.Dense"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Cakes"
            android:imeOptions="actionDone"
            android:inputType="none" />

</com.google.android.material.textfield.TextInputLayout>
```
* In your activity class
```kotlin
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
```

```kotlin
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
```

### See "app" folder for usage

# DEMO
<img src="https://github.com/dononcharles/MaterialAutoCompleteTextViewWithHeaders/blob/master/media/screenshot.gif" width="350" height="768"/>