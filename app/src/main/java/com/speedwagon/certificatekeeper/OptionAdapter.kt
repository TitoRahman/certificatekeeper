package com.speedwagon.certificatekeeper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.speedwagon.certificatekeeper.databinding.OptionItemBinding

class OptionAdapter (
    var optionList : List<Option>
    ) : RecyclerView.Adapter<OptionAdapter.CVHolder>() {
    inner class CVHolder(val binding: OptionItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVHolder {
        return CVHolder(
            OptionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CVHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = optionList[position].toolTitle
            itemImage.setImageResource(optionList[position].toolIcon)
        }
    }

    override fun getItemCount(): Int {
        return optionList.size
    }
}
