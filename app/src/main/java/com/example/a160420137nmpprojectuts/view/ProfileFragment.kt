package com.example.a160420137nmpprojectuts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a160420137nmpprojectuts.R
import androidx.navigation.Navigation

import com.example.a160420137nmpprojectuts.databinding.FragmentProfileBinding
import com.example.a160420137nmpprojectuts.databinding.FragmentRegisterBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set onClickListener for the change password button
       binding.btnChangePassword.setOnClickListener {
            // Handle change password logic here
            // For example, you can get the current password and new password from EditText views
            val currentPassword =        binding.currentPasswordEditText.text.toString()
            val newPassword =       binding. newPasswordEditText.text.toString()

            // Call a function to change the password
            changePassword(currentPassword, newPassword)
        }

        // Set onClickListener for the logout button
        binding.logoutButton.setOnClickListener {
            // Handle logout logic here
            logout()
        }
    }

    private fun changePassword(currentPassword: String, newPassword: String) {
        // Implement the logic to change the password here
        // You can use Firebase Auth, Retrofit, or any other method to communicate with your backend
        // For demonstration purposes, let's just log the passwords to the console
        println("Current Password: $currentPassword, New Password: $newPassword")
    }

    private fun logout() {
        // Implement the logout logic here
        // For example, you can clear user session, navigate to the login screen, etc.
        // For demonstration purposes, let's just print a message to the console
        println("User logged out")
    }
}
