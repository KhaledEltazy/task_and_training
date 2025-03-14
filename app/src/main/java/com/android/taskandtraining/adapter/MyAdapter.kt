package com.android.taskandtraining.adapter

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.taskandtraining.R
import com.android.taskandtraining.databinding.ItemsBinding
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MyAdapter @Inject constructor() :
    RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder>() {
    private var list : List<String> = emptyList()
    private var add : Boolean? = null
    private var delete : Boolean? = null
    private var fav : Boolean? = null

    fun setData(newList : List<String>, checkAdd : Boolean, checkDelete : Boolean, checkFav : Boolean){
        list = newList
        add = checkAdd
        delete = checkDelete
        fav = checkFav
        notifyDataSetChanged()
    }

    var selectedItem = -1
    var itemSelected: ((String, View) -> Unit)? = null
    var addBtnSelected: ((View) -> Unit)? = null
    var deleteBtnSelected: ((View) -> Unit)? = null
    var favBtnSelected: ((View) -> Unit)? = null

    class MyAdapterViewHolder(val binding: ItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, isSelected: Boolean) {
            binding.apply {
                itemText.text = item
                if (isSelected) {
                    itemLayout.background =
                        ColorDrawable(itemView.context.resources.getColor(R.color.selectedItem))
                    selectedIcon.visibility = View.VISIBLE
                } else {
                    itemLayout.background =
                        ColorDrawable(itemView.context.resources.getColor(R.color.cardViewColor))
                    selectedIcon.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterViewHolder {
        return MyAdapterViewHolder(
            ItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyAdapterViewHolder, position: Int) {
        val currentItem = list[position]

        holder.bind(currentItem, selectedItem == position)

        holder.itemView.setOnClickListener {
            if (selectedItem == holder.adapterPosition) {
                notifyItemChanged(selectedItem)
                selectedItem = -1
            } else {
                if (selectedItem >= 0) {
                    notifyItemChanged(selectedItem)
                }
                selectedItem = holder.adapterPosition
                notifyItemChanged(selectedItem)
                itemSelected?.invoke(currentItem, it)
            }
        }

        holder.binding.apply {
            if (add == true) {
                addBtn.setOnClickListener {
                    addBtnSelected?.invoke(it)
                }
            } else addBtn.visibility = View.GONE

            if (delete == true) {
                deleteBtn.setOnClickListener {
                    deleteBtnSelected?.invoke(it)
                }
            } else deleteBtn.visibility = View.GONE

            if (fav == true) {
                favBtn.setOnClickListener {
                    favBtnSelected?.invoke(it)
                }
            } else favBtn.visibility = View.GONE

        }

    }

}