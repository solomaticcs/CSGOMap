package com.tonyyang.gaming.csgomap

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mDataList by lazy {
        arrayListOf(
                MapData("de_mirage", R.drawable.de_mirage_map_callouts),
                MapData("de_dust2", R.drawable.de_dust2_map_callouts),
                MapData("de_inferno", R.drawable.de_inferno_map_callout),
                MapData("de_nuke", R.drawable.de_nuke_map_callout),
                MapData("de_cache", R.drawable.de_cache_map_callouts),
                MapData("de_cbble", R.drawable.de_cbble_map_callouts),
                MapData("de_overpass", R.drawable.de_overpass_map_callouts),
                MapData("de_train", R.drawable.de_train_map_callouts),
                MapData("de_season", R.drawable.de_season_map_callout)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        viewpager.apply {
            adapter = MapAdapter(supportFragmentManager, mDataList)
            overScrollMode = View.OVER_SCROLL_ALWAYS
        }
    }
}
