package com.example.a160420137nmpprojectuts.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420137nmpprojectuts.databinding.FragmentLoginBinding
import com.example.a160420137nmpprojectuts.model.LoginLogin
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class LoginLoginAdapter(val loginLoginList:ArrayList<LoginLogin>,
                    val adapterOnClick : (LoginLogin) -> Unit)

    :RecyclerView.Adapter<LoginLoginAdapter.LoginLoginViewHolder>()

{
    class LoginLoginViewHolder(var view: FragmentLoginBinding)
        :RecyclerView.ViewHolder(view.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginLoginViewHolder {
        val binding =FragmentLoginBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return LoginLoginViewHolder(binding)

    }
    override fun onBindViewHolder(parent: ViewGroup, position: Int):LoginLoginViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = FragmentLoginBinding.inflate(
            inflater, parent,
            false
        )
        return LoginLoginViewHolder(view)
    }
    override fun onBindViewHolder(holder: LoginLoginViewHolder, position: Int) {
        holder.view.loginLogin = loginLoginList[position]
    }


    override fun getItemCount(): Int {
        return loginLoginList.size
    }


}
/*  holder.view.txtID.text=loginLoginList[position].id
  holder.view.txtName.text=loginLoginList[position].name
  holder.view.txtDescription.text=loginLoginList[position].descr
  holder.view.btnDetail.setOnClickListener{
      val action = HomeFragmentDirections.homeToDetail(loginLoginList[position].uuid)
      Navigation.findNavController(it).navigate(action)


  }

  val picasso = Picasso.Builder(holder.itemView.context)
  picasso.listener { picasso, uri, exception ->
      exception.printStackTrace()
  }
 // picasso.build().load(loginLoginList[position].imageUrl).into(holder.imgPhoto, object: Callback {
   //   override fun onSuccess() {
     //     holder.binding.imageView.visibility = View.VISIBLE

      //}

      //override fun onError(e: Exception?) {
        //  Log.e("picasso_error", e.toString())

     // }


//       })
}
fun updateLoginLoginList(newLoginLoginList: ArrayList<LoginLogin>) {
  loginLoginList.clear()
  loginLoginList.addAll(newLoginLoginList)
  notifyDataSetChanged()
}

*/


