package com.github.ogapants.nestedscrollchecker

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            replace(when (checkedId) {
                R.id.l22 -> R.layout.fragment_main22
                R.id.m23 -> R.layout.fragment_main23
                R.id.n25 -> R.layout.fragment_main25
                R.id.o27 -> R.layout.fragment_main27
                else -> throw Exception("oops")
            })
        }
    }

    private fun replace(resId: Int) {
        val fragment = ScrollFragment.newInstance(resId)
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }
}

class ScrollFragment : Fragment() {

    companion object {
        fun newInstance(@LayoutRes resId: Int) =
                ScrollFragment().apply {
                    arguments = Bundle().apply {
                        putInt("res", resId)
                    }
                }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(arguments!!.getInt("res"), null)
    }
}