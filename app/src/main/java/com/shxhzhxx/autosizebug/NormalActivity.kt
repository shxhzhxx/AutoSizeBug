package com.shxhzhxx.autosizebug

import androidx.appcompat.app.AppCompatActivity
import me.jessyan.autosize.internal.CustomAdapt

class NormalActivity: AppCompatActivity(),CustomAdapt {
    override fun isBaseOnWidth(): Boolean {
        return true
    }

    override fun getSizeInDp(): Float {
        return 400f
    }
}