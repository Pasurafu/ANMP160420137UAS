package com.example.a160420137nmpprojectuts.view

import DatabaseHelper
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.a160420137nmpprojectuts.R
import com.example.a160420137nmpprojectuts.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = 	ProfileFragmentArgs.fromBundle(requireArguments()).username
        val email = 	ProfileFragmentArgs.fromBundle(requireArguments()).email
        binding.txtUsernameEdit.text = "$username"

        binding.txtEmailEdit.text = "$email"
        dbHelper = DatabaseHelper(requireContext())

        binding.btnChangePassword.setOnClickListener {
            changePassword()
        }

        binding.btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun changePassword() {
        val newPassword = binding.txtPasswordEdit.text.toString()
        val confirmPassword = binding.txtPasswordReentry.text.toString()

        if (newPassword.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (newPassword == confirmPassword) {
                val updated = dbHelper.updatePassword(newPassword)
                if (updated) {
                    showToast("Password changed successfully")
                    binding.txtPasswordEdit.text.clear()
                    binding.txtPasswordReentry.text.clear()
                } else {
                    showToast("Failed to change password")
                }
            } else {
                showToast("Passwords do not match")
            }
        } else {
            showToast("Please fill in all fields")
        }
    }

    private fun logout() {
        // Implement the logout logic here
        // For demonstration purposes, let's just print a message to the console
        println("User logged out")
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
