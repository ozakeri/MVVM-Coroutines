package com.example.mvvmapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmapplication.R
import com.example.mvvmapplication.model.User
import kotlinx.android.synthetic.main.items.view.*
import javax.inject.Inject

class UserListAdapter @Inject constructor() : RecyclerView.Adapter<UserListAdapter.CustomView>() {

    private val userList = ArrayList<User>()

    class CustomView(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(user: User) {
            itemView.apply {
                textViewUserName.text = user.name
                textViewUserEmail.text = user.email
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView = CustomView(
        LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
    )

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        holder.bind(userList.get(position))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun addData(users: List<User>) {
        userList.addAll(users)
    }
}