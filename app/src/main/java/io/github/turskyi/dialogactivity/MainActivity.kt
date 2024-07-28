package io.github.turskyi.dialogactivity

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity"
        val tv = TextView(this)
        tv.text = getString(R.string.activity_itself)
        tv.textSize = 20F
        tv.setPadding(20, 20, 20, 20)
        setContentView(tv)
    }
}