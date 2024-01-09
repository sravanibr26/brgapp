package com.bingerdranch.android.brgapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout


class ImagesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_images, container, false)

        // Find your views using the generated IDs
        val layoutImage01 = view.findViewById<LinearLayout>(R.id.layoutimage01)
        val layoutImage02 = view.findViewById<LinearLayout>(R.id.layoutimage02)
        val layoutImage03 = view.findViewById<LinearLayout>(R.id.layoutimage03)
        val layoutImage04 = view.findViewById<LinearLayout>(R.id.layoutimage04)
        val layoutImage05 = view.findViewById<LinearLayout>(R.id.layoutimage05)
        val layoutImage06 = view.findViewById<LinearLayout>(R.id.layoutimage06)
        val layoutImage07 = view.findViewById<LinearLayout>(R.id.layoutimage07)
        val layoutImage08 = view.findViewById<LinearLayout>(R.id.layoutimage08)
        val layoutImage09 = view.findViewById<LinearLayout>(R.id.layoutimage09)
        val layoutImage10 = view.findViewById<LinearLayout>(R.id.layoutimage10)
        val layoutImage11 = view.findViewById<LinearLayout>(R.id.layoutimage11)
        val layoutImage12 = view.findViewById<LinearLayout>(R.id.layoutimage12)
        // Add similar lines for other layouts

        // Set image resources
        setImageResource(layoutImage01, R.drawable.image01, R.id.imageView01)
        setImageResource(layoutImage02, R.drawable.image02, R.id.imageView02)
        setImageResource(layoutImage03, R.drawable.image03, R.id.imageView03)
        setImageResource(layoutImage04, R.drawable.image04, R.id.imageView04)
        setImageResource(layoutImage05, R.drawable.image05, R.id.imageView05)
        setImageResource(layoutImage06, R.drawable.image06, R.id.imageView06)
        setImageResource(layoutImage07, R.drawable.image07, R.id.imageView07)
        setImageResource(layoutImage08, R.drawable.image08, R.id.imageView08)
        setImageResource(layoutImage09, R.drawable.image09, R.id.imageView09)
        setImageResource(layoutImage10, R.drawable.image10, R.id.imageView10)
        setImageResource(layoutImage11, R.drawable.image11, R.id.imageView11)
        setImageResource(layoutImage12, R.drawable.image12, R.id.imageView12)
        // Add similar lines for other images

        return view
    }

    // Helper method to set image resource to ImageView
    private fun setImageResource(layout: LinearLayout, imageResource: Int, imageViewId: Int) {
        val imageView = layout.findViewById<ImageView>(imageViewId)
        imageView.setImageResource(imageResource)
    }
}