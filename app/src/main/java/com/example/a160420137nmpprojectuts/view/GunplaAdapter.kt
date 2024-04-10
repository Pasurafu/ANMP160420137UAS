package com.example.a160420137nmpprojectuts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420137nmpprojectuts.databinding.GunplaListItemBinding
import com.example.a160420137nmpprojectuts.model.Gunpla

class GunplaAdapter(val gunplaList:ArrayList<Gunpla>)
    :RecyclerView.Adapter<GunplaAdapter.GunplaViewHolder>()

{
    class GunplaViewHolder(var binding: GunplaListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GunplaViewHolder {
       val binding = GunplaListItemBinding.inflate(LayoutInflater.from(parent.context),
           parent,false)
        return GunplaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gunplaList.size
    }

    override fun onBindViewHolder(holder: GunplaViewHolder, position: Int) {
        holder.binding.txtID.text=gunplaList[position].id
        holder.binding.txtName.text=gunplaList[position].name
        holder.binding.txtDescription.text=gunplaList[position].desc
        holder.binding.btnDetail.setOnClickListener{
            val action = HomeFragmentDirections.homeToDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateGunplaList(newGunplaList: ArrayList<Gunpla>) {
        gunplaList.clear()
        gunplaList.addAll(newGunplaList)
        notifyDataSetChanged()
    }



}