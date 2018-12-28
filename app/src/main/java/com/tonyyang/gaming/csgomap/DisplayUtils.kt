package com.tonyyang.gaming.csgomap

import android.content.Context


/**
 * @author tonyyang
 */
class DisplayUtils {
    companion object {
        /**
         * Covert dp to px
         * @param dp
         * @param context
         * @return pixel
         */
        fun convertDpToPixel(dp: Float, context: Context): Float {
            return dp * getDensity(context)
        }

        /**
         * Covert px to dp
         * @param px
         * @param context
         * @return dp
         */
        fun convertPixelToDp(px: Float, context: Context): Float {
            return px / getDensity(context)
        }

        /**
         * 取得螢幕密度
         * 120dpi = 0.75
         * 160dpi = 1 (default)
         * 240dpi = 1.5
         * @param context
         * @return
         */
        fun getDensity(context: Context): Float {
            val metrics = context.resources.displayMetrics
            return metrics.density
        }
    }
}