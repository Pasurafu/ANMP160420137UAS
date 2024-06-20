package com.example.a160420137nmpprojectuts.view

import DatabaseHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160420137nmpprojectuts.databinding.FragmentRegisterBinding
import com.example.a160420137nmpprojectuts.viewmodel.DetailLoginLoginViewModel
import com.example.a160420137nmpprojectuts.viewmodel.LoginLoginViewModel

//import com.example.a160420137nmpprojectuts.model.User
//import com.example.a160420137nmpprojectuts.viewmodel.UserViewModel



class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var viewModel:DetailLoginLoginViewModel


    // private lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username=binding.txtUsername.text.toString()
        val password = binding.txtPassword.text.toString()
        val reenterPassword = binding.txtReenterPassword.text.toString()
        val email = binding.txtEmail.text.toString()
        val firstName = binding.txtNamaDepan.text.toString()
        val lastName = binding.txtNamaBelakang.text.toString()
        val action1 = RegisterFragmentDirections.registerToProfile(username, email)
        viewModel =
            ViewModelProvider(this).get(DetailLoginLoginViewModel::class.java)





        dbHelper = DatabaseHelper(requireContext())
        binding.btnBack.setOnClickListener {
            val action = RegisterFragmentDirections.registerToLogin()
            Navigation.findNavController(it).navigate(action)
        }
        binding.btnRegister.setOnClickListener{




            if (username.isEmpty() || password.isEmpty() || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || reenterPassword.isEmpty()) {
                // Show a toast or a message indicating that all fields are required
                Toast.makeText(requireContext(), "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != reenterPassword) {
                // Show a toast or a message indicating that passwords don't match
                Toast.makeText(requireContext(), "Passwords don't match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userId = dbHelper.addUser(username, password, email, firstName, lastName)
            if (userId != -1L) {
                // User added successfully
                // Now add retype password to retype password table

                dbHelper.addRetypePassword(reenterPassword)
            val action = RegisterFragmentDirections.registerToHome(username)
           Navigation.findNavController(it).navigate(action)
            }
            else {
                Toast.makeText(requireContext(), "Failed to register, please try again", Toast.LENGTH_SHORT).show()
            }


    }




}}