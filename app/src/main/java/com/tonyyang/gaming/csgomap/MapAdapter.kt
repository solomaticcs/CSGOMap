package com.tonyyang.gaming.csgomap

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class MapAdapter(fm: FragmentManager, private val mapList: List<MapData>): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return MapFragment.newInstance(mapList[position])
    }

    override fun getCount() = mapList.size
}