package com.example.tatvaproject.ui.fragment.task2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tatvaproject.R
import com.example.tatvaproject.databinding.ItemUserBinding
import com.example.tatvaproject.model.UserResponse
import com.example.tatvaproject.utils.loadImage

class UserPagingAdapter :
    PagingDataAdapter<UserResponse.UserModel, UserPagingAdapter.UsersViewHolder>(
        PlayersDiffCallback()
    ) {

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UsersViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    inner class UsersViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val data = getItem(position)
            binding.let {
                it.userModel = data
                it.sivProfile.loadImage(data?.avatar ?: "", R.drawable.ic_person)
            }
        }
    }

    private class PlayersDiffCallback : DiffUtil.ItemCallback<UserResponse.UserModel>() {
        override fun areItemsTheSame(oldItem: UserResponse.UserModel, newItem: UserResponse.UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserResponse.UserModel, newItem: UserResponse.UserModel): Boolean {
            return oldItem == newItem
        }
    }
}