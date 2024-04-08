package com.example.a160420137nmpprojectuts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a160420137nmpprojectuts.databinding.FragmentHomeBinding
import com.example.a160420137nmpprojectuts.databinding.FragmentRegisterBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // will be implemented once Layouts is ready
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val username = HomeFragmentArgs.fromBundle(requireArguments()).username
            binding.txtTextView.text = "$username's Turn"
        }

    }
}
