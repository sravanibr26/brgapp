package com.bingerdranch.android.brgapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity


class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        // Find your views using the generated IDs
        val layoutCall = view.findViewById<LinearLayout>(R.id.layoutcall)
        val layoutMessage = view.findViewById<LinearLayout>(R.id.layoutMessage)
        val layoutEmail = view.findViewById<LinearLayout>(R.id.layoutEmail)
        val layoutInsta = view.findViewById<LinearLayout>(R.id.layoutInsta)

        // Set click listeners or perform any other actions as needed

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listeners for call, message, email, and Instagram icons
        view.findViewById<LinearLayout>(R.id.layoutcall).setOnClickListener {
            makePhoneCall()
        }

        view.findViewById<LinearLayout>(R.id.layoutMessage).setOnClickListener {
            sendMessage()
        }

        view.findViewById<LinearLayout>(R.id.layoutEmail).setOnClickListener {
            sendEmail()
        }

        view.findViewById<LinearLayout>(R.id.layoutInsta).setOnClickListener {
            openInstagramProfile()
        }

        // Handle the web link click
        view.findViewById<TextView>(R.id.weblinkText).setOnClickListener {
            // Replace "your_website_url" with the actual website URL
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://brg2019.github.io/BRG_Website/"))
            startActivity(webIntent)
        }
    }

    private fun makePhoneCall() {
        val phoneNumber = "+919032665999" // Replace with your phone number
        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(dialIntent)
    }

    private fun sendMessage() {
        val phoneNumber = "+919032665999" // Replace with your phone number
        val smsIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
        startActivity(smsIntent)
    }

    private fun sendEmail() {
        val email = "mahenderreddy9876@gmail.com" // Replace with your email address
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
        startActivity(emailIntent)
    }

    private fun openInstagramProfile() {
        val instagramUsername = "brg_function_hall_" // Replace with your Instagram username
        val uri = Uri.parse("http://instagram.com/_u/$instagramUsername")
        val likeIng = Intent(Intent.ACTION_VIEW, uri)

        likeIng.setPackage("com.instagram.android")

        try {
            startActivity(likeIng)
        } catch (e: Exception) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/$instagramUsername")))
        }
    }

    // Handle the web link click
    fun onLinkClick(view: View) {
        // Replace "your_website_url" with the actual website URL
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://brg2019.github.io/BRG_Website/"))
        startActivity(webIntent)
    }
}

