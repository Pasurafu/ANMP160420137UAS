package com.example.a160420137nmpprojectuts.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420137nmpprojectuts.databinding.GunplaListItemBinding
import com.example.a160420137nmpprojectuts.model.Gunpla
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class GunplaAdapter(val gunplaList:ArrayList<Gunpla>,
                    val adapterOnClick : (Gunpla) -> Unit)

    :RecyclerView.Adapter<GunplaAdapter.GunplaViewHolder>(),GunplaEditClick

{
    class GunplaViewHolder(var view: GunplaListItemBinding)
        :RecyclerView.ViewHolder(view.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GunplaViewHolder {
       val binding = GunplaListItemBinding.inflate(LayoutInflater.from(parent.context),
           parent,false)
        return GunplaViewHolder(binding)

    }
    override fun onBindViewHolder(parent: ViewGroup, position: Int):GunplaViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = GunplaListItemBinding.inflate(
            inflater, parent,
            false
        )
        return GunplaViewHolder(view)
    }
    override fun onBindViewHolder(holder: GunplaViewHolder, position: Int) {
        holder.view.gunpla = gunplaList[position]

        holder.view.editListener = this
    }


    override fun getItemCount(): Int {
        return gunplaList.size
    }

    override fun onGunplaEditClick(v: View) {
        val uuid = v.tag.toString().toInt()
        val action = HomeFragmentDirections.homeToDetail(uuid)
        Navigation.findNavController(v).navigate(action)
    }


}
      /*  holder.view.txtID.text=gunplaList[position].id
        holder.view.txtName.text=gunplaList[position].name
        holder.view.txtDescription.text=gunplaList[position].descr
        holder.view.btnDetail.setOnClickListener{
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

*/


