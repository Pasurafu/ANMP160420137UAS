package com.example.a160420137nmpprojectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.a160420137nmpprojectuts.R
import com.example.a160420137nmpprojectuts.databinding.FragmentDetailBinding
import com.example.a160420137nmpprojectuts.viewmodel.ListViewModel
import com.bumptech.glide.Glide



class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: ListViewModel
    private var currentGunplaIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the view model
        viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)

        // Observe the LiveData for gunpla list
        viewModel.gunplaLD.observe(viewLifecycleOwner) { gunplaList ->
            // Check if the list is not empty
            if (gunplaList.isNotEmpty()) {
                // Update currentGunplaIndex if it's out of bounds
                if (currentGunplaIndex >= gunplaList.size) {
                    currentGunplaIndex = gunplaList.size - 1
                } else if (currentGunplaIndex < 0) {
                    currentGunplaIndex = 0
                }

                val gunpla = gunplaList[currentGunplaIndex]

                // Populate views with data from the Gunpla object
                binding.txtNameD.text = gunpla.name
                binding.txtDescD.text = gunpla.desc
                // Use an image loading library like Glide or Picasso to load the image
                // For now, let's just assume you have an ImageView named imageViewGunpla
                Glide.with(this).load(gunpla.imageUrl).into(binding.imageViewGunpla)
            }
        }

        // Observe the LiveData for error state
        viewModel.gunplaLoadErrorLD.observe(viewLifecycleOwner) { isError ->
            Toast.makeText(requireContext(), "Failed to load Gunpla data", Toast.LENGTH_SHORT)
                .show()
        }

        // Fetch the gunpla data
        viewModel.refresh()

        // Set up click listeners for navigation buttons
        binding.btnPreviousPage.setOnClickListener {
            currentGunplaIndex--
            viewModel.refresh()
        }

        binding.btnNextPage.setOnClickListener {
            currentGunplaIndex++
            viewModel.refresh()
        }
    }
}

