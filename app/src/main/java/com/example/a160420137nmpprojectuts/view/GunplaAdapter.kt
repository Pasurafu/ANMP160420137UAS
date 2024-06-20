package com.example.a160420137nmpprojectuts.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420137nmpprojectuts.databinding.GunplaListItemBinding
import com.example.a160420137nmpprojectuts.model.Gunpla
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class GunplaAdapter(val gunplaList:ArrayList<Gunpla>,
                    val adapterOnClick : (Gunpla) -> Unit)

    :RecyclerView.Adapter<GunplaAdapter.GunplaViewHolder>()

{
    class GunplaViewHolder(var binding: GunplaListItemBinding)
        :RecyclerView.ViewHolder(binding.root) {


    }

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
        holder.binding.txtDescription.text=gunplaList[position].descr
        holder.binding.btnDetail.setOnClickListener{
            val action = HomeFragmentDirections.homeToDetail(gunplaList[position].uuid)
            Navigation.findNavController(it).navigate(action)


        }

        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
       // picasso.build().load(gunplaList[position].imageUrl).into(holder.imgPhoto, object: Callback {
         //   override fun onSuccess() {
           //     holder.binding.imageView.visibility = View.VISIBLE

            //}

            //override fun onError(e: Exception?) {
              //  Log.e("picasso_error", e.toString())

           // }


 //       })
    }
    fun updateGunplaList(newGunplaList: ArrayList<Gunpla>) {
        gunplaList.clear()
        gunplaList.addAll(newGunplaList)
        notifyDataSetChanged()
    }



}