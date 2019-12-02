package com.tonyyang.gaming.csgomap

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import java.io.Serializable
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager


/**
 * Reference to this link:
 * https://android.googlesource.com/platform/packages/apps/DeskClock/+/master/src/com/android/deskclock/VerticalViewPager.java
 */
class VerticalViewPager @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null
) : ViewPager(context, attrs), Serializable {

    init {
        setPageTransformer(true, VerticalPageTransformer())
        overScrollMode = View.OVER_SCROLL_NEVER
    }

    private fun swapXY(ev: MotionEvent): MotionEvent {
        val newX = (ev.y / height) * width
        val newY = (ev.x / width) * height
        ev.setLocation(newX, newY)
        return ev
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val intercepted = super.onInterceptTouchEvent(swapXY(ev))
        swapXY(ev)
        return intercepted
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        val handle = super.onTouchEvent(swapXY(ev))
        swapXY(ev)
        return handle
    }

    override fun canScrollHorizontally(direction: Int): Boolean {
        return false
    }

    override fun canScrollVertically(direction: Int): Boolean {
        return super.canScrollHorizontally(direction)
    }

    private inner class VerticalPageTransformer : PageTransformer {

        override fun transformPage(view: View, position: Float) {
            val pageWidth = view.width
            val pageHeight = view.height
            when {
                position < -1 -> {
                    view.alpha = 0F
                }
                position <= 1 -> {
                    view.alpha = 1F
                    view.translationX = pageWidth * -position
                    view.translationY = pageHeight * position
                }
                else -> {
                    view.alpha = 0F
                }
            }
        }
    }
}