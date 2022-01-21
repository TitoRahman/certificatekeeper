package com.speedwagon.certificatekeeper

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.template_recentlyfile, parent, false)) {

    private var imgView: ImageView? = null
    private var titlefile: TextView? = null

    init {
        imgView= itemView.findViewById(R.id.img_rf)
        titlefile= itemView.findViewById(R.id.namefile)
    }

    fun bind(data: recentlyfile){
        imgView?.setImageResource(data.imagerf)
        titlefile?.text= data.titlefile
    }

}