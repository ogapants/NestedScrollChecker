package com.github.ogapants.nestedscrollchecker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        var a = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (a % 2 == 0) {
            Toast.makeText(this, "--25--", Toast.LENGTH_SHORT).show()
            setContentView(R.layout.activity_main25)
        } else {
            Toast.makeText(this, "--27--", Toast.LENGTH_SHORT).show()
            setContentView(R.layout.activity_main27)
        }
        a++
    }
}
