package com.example.a160420137nmpprojectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160420137nmpprojectuts.databinding.FragmentLoginBinding
import com.example.a160420137nmpprojectuts.viewmodel.DetailLoginLoginViewModel
import com.example.a160420137nmpprojectuts.viewmodel.LoginLoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginLoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(
            inflater,
            container, false
        )
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(LoginLoginViewModel::class.java)
        binding.btnRegister.setOnClickListener {
            val action = LoginFragmentDirections.loginToRegister()
            Navigation.findNavController(it).navigate(action)

        }
        binding.btnLogin.setOnClickListener{
            val username=binding.txtUsername.text.toString()

            //will be implemented once Database is set.
            val action = LoginFragmentDirections.loginToHome(username)
            Navigation.findNavController(it).navigate(action)

        }
    }

}