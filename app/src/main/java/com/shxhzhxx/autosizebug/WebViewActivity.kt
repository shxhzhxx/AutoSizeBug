package com.shxhzhxx.autosizebug

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web_view.*
import me.jessyan.autosize.internal.CustomAdapt

class WebViewActivity : AppCompatActivity(), CustomAdapt {
    override fun isBaseOnWidth(): Boolean {
        return true
    }

    override fun getSizeInDp(): Float {
        return 400f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView.loadUrl("https://github.com/JessYanCoding/AndroidAutoSize")
    }

    override fun onDestroy() {
        super.onDestroy()
        webView.destroy()
    }
}