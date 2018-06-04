package com.github.ogapants.nestedscrollchecker

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val switch = findViewById<Switch>(R.id.switch_scrollbar)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            replaceFragmentWith(checkedId, switch.isChecked)
        }
        switch.setOnCheckedChangeListener { _, isChecked ->
            replaceFragmentWith(radioGroup.checkedRadioButtonId, isChecked)
        }
        radioGroup.check(R.id.origin)
    }

    private fun replaceFragmentWith(checkedId: Int, checked: Boolean) {
        replaceFragment(when (checkedId) {
            R.id.l22 -> if (checked) R.layout.fragment_main22 else R.layout.fragment_main22_non_bar
            R.id.m23 -> if (checked) R.layout.fragment_main23 else R.layout.fragment_main23_non_bar
            R.id.n25 -> if (checked) R.layout.fragment_main25 else R.layout.fragment_main25_non_bar
            R.id.o27 -> if (checked) R.layout.fragment_main27 else R.layout.fragment_main27_non_bar
            R.id.origin -> if (checked) R.layout.fragment_main else R.layout.fragment_main_non_bar
            else -> throw Exception("oops")
        })
    }

    private fun replaceFragment(resId: Int) {
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