package com.tonyyang.gaming.csgomap

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author tonyyang
 */

class MapAdapter(fm: FragmentManager, private val mapList: List<MapData>): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return MapFragment.newInstance(mapList[position])
    }

    override fun getCount() = mapList.size
}