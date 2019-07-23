package com.projecteugene.versiondisplay

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import kotlinx.android.synthetic.main.popup.view.*

/**
 * Created by Eugene Low
 */

class VersionUtil(activity: Activity) {
    private var pw: PopupWindow? = null

    init {
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //Inflate the view from a predefined XML layout
        val layout = inflater.inflate(R.layout.popup,
                activity.findViewById<View>(android.R.id.content) as ViewGroup)
        pw = PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        pw?.isTouchable = false
        pw?.isOutsideTouchable = true
        pw?.isFocusable = false
    }

    fun setGravity(gravity: Int): VersionUtil {
        pw?.contentView?.tv_version?.gravity = gravity
        return this
    }

    fun setText(version: String): VersionUtil {
        pw?.contentView?.tv_version?.text = version
        return this
    }

    fun setTextColor(color: Int): VersionUtil {
        pw?.contentView?.tv_version?.setTextColor(color)
        return this
    }

    fun setTextBackgroundResource(backgroundRes: Int): VersionUtil {
        pw?.contentView?.tv_version?.setBackgroundResource(backgroundRes)
        return this
    }

    companion object {
        private var util: VersionUtil? = null
        fun display(activity: Activity, gravity: Int, text: String) {
            if (util == null) {
                util = VersionUtil(activity)
                    .setGravity(gravity)
                    .setText(text)
            }
        }

        fun display(activity: Activity, gravity: Int, text: String, textColor: Int, backgroundRes: Int) {
            if (util == null) {
                util = VersionUtil(activity)
                    .setGravity(gravity)
                    .setText(text)
                    .setTextColor(textColor)
                    .setTextBackgroundResource(backgroundRes)
            }
        }
        fun getInstance(): VersionUtil? {
            return util
        }
    }
}