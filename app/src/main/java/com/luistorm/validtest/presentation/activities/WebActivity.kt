package com.luistorm.validtest.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luistorm.validtest.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        intent.extras?.let {
            if(it.getString(URL, "").isNotEmpty()) {
                webView.loadUrl(it.getString(URL))
            }
        }
    }

    companion object {
        const val URL = "URL"
    }
}
