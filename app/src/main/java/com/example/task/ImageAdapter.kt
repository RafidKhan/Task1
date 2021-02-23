package com.example.task


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.model.ResultsItem


class ImageAdapter(imageList: List<ResultsItem?>, context: Context) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    var imageLists: List<ResultsItem?>? = null
    var context: Context ?= null

    init {
        this.imageLists = imageList
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_items, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvname?.setText(imageLists?.get(position)?.title)
        holder.tvrating?.setText(imageLists?.get(position)?.voteAverage.toString())
        holder.tvoverview?.setText(imageLists?.get(position)?.overview)
        //holder.ivposter?.setImageURI(imageLists.get(position)?.posterPath)



    }

    override fun getItemCount(): Int {
        Log.d("LIST_SIZE", imageLists?.size.toString())
        return imageLists?.size!!
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        /*super(itemView)*/
        val tvname: TextView? = itemView?.findViewById(R.id.itemnameTV)
        val tvrating: TextView? = itemView?.findViewById(R.id.itemratingTV)
        val tvoverview: TextView? = itemView?.findViewById(R.id.itemoverviewTV)
        //val ivposter: ImageView? = itemView?.findViewById(R.id.itemposterIV)


    }

}