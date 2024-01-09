package com.bingerdranch.android.brgapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment

class BookingFragment : Fragment() {

    // Declare your UI elements
    private lateinit var personNameEditText: EditText
    private lateinit var personAddressEditText: EditText
    private lateinit var personEmailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var peopleNumberEditText: EditText
    private lateinit var datePicker: DatePicker
    private lateinit var startTimePicker: TimePicker
    private lateinit var endTimePicker: TimePicker
    private lateinit var eventTypeSpinner: Spinner
    private lateinit var otherEventNameEditText: EditText
    private lateinit var serviceOption1CheckBox: CheckBox
    private lateinit var serviceOption2CheckBox: CheckBox
    private lateinit var serviceOption3CheckBox: CheckBox
    private lateinit var serviceOption4CheckBox: CheckBox
    private lateinit var serviceOption5CheckBox: CheckBox
    private lateinit var serviceOption6CheckBox: CheckBox
    private lateinit var serviceOption7CheckBox: CheckBox
    private lateinit var serviceOption8CheckBox: CheckBox
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_booking, container, false)

        // Initialize your UI elements
        personNameEditText = view.findViewById(R.id.PersonName)
        personAddressEditText = view.findViewById(R.id.PersonAddress)
        personEmailEditText = view.findViewById(R.id.PersonEmail)
        phoneEditText = view.findViewById(R.id.Phone)
        peopleNumberEditText = view.findViewById(R.id.PeopleNumber)
        datePicker = view.findViewById(R.id.datePicker)
        startTimePicker = view.findViewById(R.id.startTimePicker)
        endTimePicker = view.findViewById(R.id.endTimePicker)
        eventTypeSpinner = view.findViewById(R.id.eventTypeSpinner)
        otherEventNameEditText = view.findViewById(R.id.otherEventName)
        serviceOption1CheckBox = view.findViewById(R.id.serviceOption1)
        serviceOption2CheckBox = view.findViewById(R.id.serviceOption2)
        serviceOption3CheckBox = view.findViewById(R.id.serviceOption3)
        serviceOption4CheckBox = view.findViewById(R.id.serviceOption4)
        serviceOption5CheckBox = view.findViewById(R.id.serviceOption5)
        serviceOption6CheckBox = view.findViewById(R.id.serviceOption6)
        serviceOption7CheckBox = view.findViewById(R.id.serviceOption7)
        serviceOption8CheckBox = view.findViewById(R.id.serviceOption8)
        submitButton = view.findViewById(R.id.SubmitButton)

        // Set click listener for the Submit button
        submitButton.setOnClickListener {
            // Validate the form
            validateForm()
        }

        return view
    }

    private fun validateForm(): Boolean {
        val name = personNameEditText.text.toString()
        val address = personAddressEditText.text.toString()
        val email = personEmailEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val peopleNumber = peopleNumberEditText.text.toString()

        // Perform your validation checks
        val isValid = !(name.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty() || peopleNumber.isEmpty())

        // If the form is valid, send details as a message and email
        if (isValid) {
            sendMessage()
            sendEmail()

            // Optionally, you can reset the form or navigate to another screen
            resetForm()

            // Show a success message
            Toast.makeText(requireContext(), "Booking submitted successfully! We will get back ASAP!!", Toast.LENGTH_SHORT).show()
        } else {
            // Show an error message if validation fails
            Toast.makeText(requireContext(), "Please fill in all required fields.", Toast.LENGTH_SHORT).show()
        }

        return isValid
    }

    private fun sendMessage() {
        val phoneNumber = "+919032665999" // Replace with the actual phone number
        val message = buildMessage()

        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle the exception or show an error message
        }
    }

    private fun sendEmail() {
        val recipient = "mahenderreddy9876@gmail.com"
        val subject = "Booking Details"
        val message = buildMessage()

        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }

        try {
            startActivity(emailIntent)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
            // Handle the exception or show an error message
        }
    }

    private fun resetForm() {
        // Clear all EditText fields
        personNameEditText.text.clear()
        personAddressEditText.text.clear()
        personEmailEditText.text.clear()
        phoneEditText.text.clear()
        peopleNumberEditText.text.clear()

        // Uncheck checkboxes
        serviceOption1CheckBox.isChecked = false
        serviceOption2CheckBox.isChecked = false
        // ... (do the same for other checkboxes)
    }

    private fun buildMessage(): String {
        // Build the message with the entered details
        val name = personNameEditText.text.toString()
        val address = personAddressEditText.text.toString()
        val email = personEmailEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val peopleNumber = peopleNumberEditText.text.toString()
        val eventDate = "${datePicker.dayOfMonth}/${datePicker.month + 1}/${datePicker.year}"
        val startTime = "${startTimePicker.hour}:${startTimePicker.minute}"
        val endTime = "${endTimePicker.hour}:${endTimePicker.minute}"
        val eventType = eventTypeSpinner.selectedItem.toString()
        val otherEventName = otherEventNameEditText.text.toString()
        val services = buildServicesString()

        return """
            Name: $name
            Address: $address
            Email: $email
            Phone: $phone
            People Number: $peopleNumber
            Event Date: $eventDate
            Event Time: $startTime - $endTime
            Event Type: $eventType
            Other Event Name: $otherEventName
            Services: $services
        """.trimIndent()
    }

    private fun buildServicesString(): String {
        // Build a string with selected services
        val services = mutableListOf<String>()
        if (serviceOption1CheckBox.isChecked) services.add("Decoration")
        if (serviceOption2CheckBox.isChecked) services.add("Food Catering")
        if (serviceOption3CheckBox.isChecked) services.add("Lighting and Music")
        if (serviceOption4CheckBox.isChecked) services.add("Banquet Hall Requirement")
        if (serviceOption5CheckBox.isChecked) services.add("Event Permission")
        if (serviceOption6CheckBox.isChecked) services.add("Security Guards")
        if (serviceOption7CheckBox.isChecked) services.add("Waiters")
        if (serviceOption8CheckBox.isChecked) services.add("Coolers")

        return services.joinToString(", ")
    }
}
