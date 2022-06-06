package com.example.kursprogin.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kursprogin.databinding.ItemHomeRecyBinding
import com.squareup.picasso.Picasso

class AdapterList: RecyclerView.Adapter<AdapterList.FavouriteViewHolder>() {

    inner class FavouriteViewHolder(val binding: ItemHomeRecyBinding): RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<DataFromList>(){
        override fun areItemsTheSame(
            oldItem: DataFromList,
            newItem: DataFromList
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: DataFromList,
            newItem: DataFromList
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHomeRecyBinding.inflate(inflater, parent, false)
        return FavouriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val event = differ.currentList[position]
        with(holder.binding){
            Picasso.with(holder.itemView.context)
                .load(event.imageUrl)
                .into(imageView)
            textViewNameDisck.text = event.name

            holder.itemView.setOnClickListener {
                onItemClickListener?.let { it1 -> it1(event.id) }
            }
        }
    }

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener:(Int) -> Unit){
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}