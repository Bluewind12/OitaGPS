package momonyan.oitagps

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import momonyan.oitagps.function_list.getNowDate

class MainActivity : AppCompatActivity() {

    private var listName = arrayListOf<String>()
    private var listInfo = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainSubmitButton.setOnClickListener {
            val view = this.currentFocus
            if (view != null) {
                val inputManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }

            listName.add(mainTextInputEditText.text.toString())
            listInfo.add(getNowDate())

            val listItems = arrayListOf<Map<String, String>>()

            for (i in 0 until listName.size) {
                val tempItem = hashMapOf<String, String>()
                tempItem["name"] = listName[i]
                tempItem["info"] = listInfo[i]

                listItems.add(tempItem)
            }
            val adapter = SimpleAdapter(
                this, listItems, android.R.layout.simple_expandable_list_item_2,
                arrayOf("name", "info"),
                intArrayOf(android.R.id.text1, android.R.id.text2)
            )
            mainListView.adapter = adapter
            mainTextInputEditText.text?.clear()
        }
    }
}
