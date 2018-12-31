package com.tonyyang.gaming.csgomap

import android.graphics.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import it.sephiroth.android.library.imagezoom.ImageViewTouch

/**
 * @author tonyyang
 */

class MapFragment : Fragment() {

    companion object {
        const val EXTRA_DATA = "data"

        fun newInstance(data: MapData): MapFragment {
            return MapFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(EXTRA_DATA, data)
                }
            }
        }
    }

    private val data by lazy {
        arguments?.getSerializable(EXTRA_DATA) as MapData
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val image: ImageViewTouch = view.findViewById(R.id.image)
        image.setImageBitmap(getMapBitmap())
        return view
    }

    private fun getMapBitmap(): Bitmap {
        val bitmap = BitmapFactory.decodeResource(resources, data.mapImageRes)
        val config = bitmap.config
        val width = bitmap.width
        val height = bitmap.height
        val newBitmap = Bitmap.createBitmap(width, height, config)
        val canvas = Canvas(newBitmap)
        canvas.drawBitmap(bitmap, 0F, 0F, null)
        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        paint.textSize = 150F
        val textRect = Rect()
        paint.getTextBounds(data.mapName, 0, data.mapName.length, textRect)
        canvas.drawText(data.mapName, (width / 2 - textRect.width() / 2).toFloat(), 150F, paint)
        return newBitmap
    }
}