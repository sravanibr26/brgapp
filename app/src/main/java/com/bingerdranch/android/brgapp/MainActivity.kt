package com.bingerdranch.android.brgapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController =navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        setupWithNavController(bottomNavigationView, navController)

        // Set click listener for bottom navigation items
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom_home -> {
                    // Handle home fragment click
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.bottom_images -> {
                    // Handle images fragment click
                    navController.navigate(R.id.imagesFragment)
                    true
                }
                R.id.bottom_contact -> {
                    // Handle contact fragment click
                    navController.navigate(R.id.contactFragment)
                    true
                }
                R.id.bottom_booking -> {
                    // Handle location fragment click
                    navController.navigate(R.id.bookingFragment)
                    true
                }
                R.id.bottom_about -> {
                    // Handle about fragment click
                    navController.navigate(R.id.aboutFragment)
                    true
                }
                else -> false
            }
        }


        // Set click listener for the logout icon
        val btnLogout: ImageButton = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            showLogoutConfirmationDialog()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.logout_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_logout -> {
                showLogoutConfirmationDialog()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showLogoutConfirmationDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_confirm_logout, null)

        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)

        val alertDialog = dialogBuilder.create()

        val btnCancel = dialogView.findViewById<Button>(R.id.button_cancel)
        val btnConfirm = dialogView.findViewById<Button>(R.id.button_confirm)

        btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }

        btnConfirm.setOnClickListener {
            // User confirmed, perform logout
            performLogout()
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun performLogout() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        // 3. Finish the current activity
        finish()
    }
}
