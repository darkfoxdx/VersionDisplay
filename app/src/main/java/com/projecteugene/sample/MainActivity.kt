package com.projecteugene.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.projecteugene.versiondisplay.VersionUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VersionUtil.display(this, Gravity.RIGHT or Gravity.BOTTOM, "Test V Test")
    }
}
