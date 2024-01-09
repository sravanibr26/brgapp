package com.bingerdranch.android.brgapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController



class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the "Book" button by its ID
        val btnBook: Button = view.findViewById(R.id.btnBook)

        // Set an OnClickListener for the button
        btnBook.setOnClickListener {
            // Navigate to the BookingFragment when the button is clicked
            findNavController().navigate(R.id.action_homeFragment_to_bookingFragment)
        }
    }
}