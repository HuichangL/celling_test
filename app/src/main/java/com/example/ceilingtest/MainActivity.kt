package com.example.ceilingtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ceilingtest.adapter.RecyclerViewAdapter
import com.example.ceilingtest.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<String>
    private var state: CollapsingToolbarLayoutState = CollapsingToolbarLayoutState.EXPANDED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initList()
        initView()
    }

    private fun initList() {
        list = ArrayList()
        for (i in 1..100) {
            list.add("item $i")
        }
    }

    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(this)
        val normalAdapter = RecyclerViewAdapter(list)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.isNestedScrollingEnabled = false
        binding.recyclerView.adapter = normalAdapter

        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset == 0) {
                if (state != CollapsingToolbarLayoutState.EXPANDED) {
                    state = CollapsingToolbarLayoutState.EXPANDED
                    binding.text.text = "展开状态"
                }
            } else if (abs(verticalOffset) >= appBarLayout.totalScrollRange) {
                if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                    binding.text.text = "吸顶状态"
                    state = CollapsingToolbarLayoutState.COLLAPSED
                }
            }
        })

    }
}

enum class CollapsingToolbarLayoutState{
    EXPANDED,
    COLLAPSED,
}