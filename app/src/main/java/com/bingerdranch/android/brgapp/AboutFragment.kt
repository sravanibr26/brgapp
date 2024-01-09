package com.bingerdranch.android.brgapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bingerdranch.android.brgapp.R

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            // Handle the web link click
            view.findViewById<TextView>(R.id.locationText).setOnClickListener {
                // Replace "your_website_url" with the actual website URL
                val locationIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/BRG+Garden+and+Function+Hall/@17.4451494,78.2546048,17z/data=!4m6!3m5!1s0x3bcbed0da3fac375:0x3f1721a1bccb3f5a!8m2!3d17.4451494!4d78.2546048!16s%2Fg%2F11fsscrtsr?entry=ttu"))
                startActivity(locationIntent)
            }
        }

        // Handle the web link click
        fun onLinkClick(view: View) {
            // Replace "your_website_url" with the actual website URL
            val locationIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/BRG+Garden+and+Function+Hall/@17.4451494,78.2546048,17z/data=!4m6!3m5!1s0x3bcbed0da3fac375:0x3f1721a1bccb3f5a!8m2!3d17.4451494!4d78.2546048!16s%2Fg%2F11fsscrtsr?entry=ttu"))
            startActivity(locationIntent)
        }
    }

