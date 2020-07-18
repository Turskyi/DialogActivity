package io.github.turskyi.dialogactivity

import android.accounts.AccountManager
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Activity"
        val tv = TextView(this)
        tv.text = getString(R.string.activity_itself)
        tv.textSize = 20F
        tv.setPadding(20, 20, 20, 20)
        setContentView(tv)
        tv.setOnClickListener(onViewClickListener)
    }

    private var onViewClickListener: View.OnClickListener = View.OnClickListener { _ ->
        val am = AccountManager.get(this)
        /* another option */
//        val am = getSystemService(ACCOUNT_SERVICE) as AccountManager

        val accounts = am.accounts

        for (account in accounts) {
            Log.i("Account==>", account.type)
            when {
                account.type.equals("com.google", ignoreCase = true) ->
                    Toast.makeText(this@MainActivity, "google account ${account.name.trimIndent()}", Toast.LENGTH_LONG).show()
                account.type.equals("com.osp.app.signin", ignoreCase = true) ->
                    Toast.makeText(this@MainActivity, "samsung account ${account.name.trimIndent()}", Toast.LENGTH_LONG).show()
                else -> Toast.makeText(this@MainActivity, "${accounts.size} accounts", Toast.LENGTH_LONG).show()
            }
        }

    }
}