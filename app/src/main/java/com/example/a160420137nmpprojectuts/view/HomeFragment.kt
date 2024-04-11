package com.example.a160420137nmpprojectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160420137nmpprojectuts.R
import com.example.a160420137nmpprojectuts.databinding.FragmentHomeBinding
import com.example.a160420137nmpprojectuts.viewmodel.ListViewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: ListViewModel
    private val studentListAdapter  = GunplaAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    // will be implemented once Layouts is ready
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        binding.recyclerView.layoutManager=LinearLayoutManager(context)
        binding.recyclerView.adapter=studentListAdapter
        observeViewModel()
        if (arguments != null) {
            val username = HomeFragmentArgs.fromBundle(requireArguments()).username
           // binding.txtTextView.text = "$username's Turn"
        }
        binding.swiperefreshLayout.setOnRefreshListener {
            binding.recyclerView.visibility = View.GONE
            binding.txtError.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            viewModel.refresh()
            binding.swiperefreshLayout.isRefreshing = false
        }

    }
    fun observeViewModel()
    {
        viewModel.gunplaLD.observe(viewLifecycleOwner, Observer {
            studentListAdapter.updateGunplaList(it)
        })
        viewModel.gunplaLoadErrorLD.observe(viewLifecycleOwner, Observer {if(it == true) {
            binding.txtError?.visibility = View.VISIBLE
        } else {
            binding.txtError?.visibility = View.GONE
        }
        })
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {  if(it == true) {
            binding.recyclerView.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.recyclerView.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
        })




    }
}
