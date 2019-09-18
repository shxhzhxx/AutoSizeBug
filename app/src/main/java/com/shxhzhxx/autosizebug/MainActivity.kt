package com.shxhzhxx.autosizebug

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import me.jessyan.autosize.AutoSizeCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MyAdapter()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        refresh.setOnClickListener { adapter.notifyDataSetChanged() }
    }

    /**
     * work around
     *
    override fun onResume() {
        super.onResume()
        AutoSizeCompat.autoConvertDensityOfGlobal(resources)
    }
     */
}

class MyAdapter : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)).apply {
            itemView.setOnClickListener { v ->
                v.context.let { c ->
                    c.startActivity(Intent(c, WebViewActivity::class.java))
                }
            }
        }

    override fun getItemCount() = 100

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
    }

}

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
