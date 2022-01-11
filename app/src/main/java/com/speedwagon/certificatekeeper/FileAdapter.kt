package com.speedwagon.certificatekeeper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class FileAdapter (
    val certAndFilesListPath : File,
    val context : Context
) : RecyclerView.Adapter<FileAdapter.FAViewHolder>() {

    inner class FAViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val imgView : ImageView = itemView.findViewById(R.id.fileIV)
        val txtView : TextView = itemView.findViewById(R.id.folderTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cert_and_folder, parent, false)
        return FAViewHolder (itemView)
    }

    override fun onBindViewHolder(holder: FAViewHolder, position: Int) {
        val certAndFilesList = certAndFilesListPath.listFiles()
        val selectedFile : File = certAndFilesList[position]
        holder.txtView.text = selectedFile.name
        if (selectedFile.isDirectory)
        {
            holder.imgView.setImageResource(R.drawable.ic_folder)
        } else
        {
            holder.imgView.setImageResource(R.drawable.ic_file)
        }
        holder.itemView.setOnClickListener {
            if (selectedFile.isDirectory)
            {
                val fileExplorerIntent = Intent(holder.itemView.context, FileExplorer::class.java)
                val path : String = selectedFile.absolutePath
                fileExplorerIntent.putExtra("Path", path)
                fileExplorerIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(fileExplorerIntent)

            } else
            {
                Toast.makeText(holder.itemView.context, "${selectedFile.name} opened!", Toast.LENGTH_SHORT).show()
            }
        }

    }


    override fun getItemCount(): Int {
        return certAndFilesListPath.listFiles().size
    }
}
