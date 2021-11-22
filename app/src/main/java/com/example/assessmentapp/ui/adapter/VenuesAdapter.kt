package com.example.assessmentapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentapp.databinding.VenueListItemBinding
import com.example.assessmentapp.ui.model.VenueListModel

class VenuesAdapter : RecyclerView.Adapter<VenuesAdapter.VenuesViewHolder>() {

    private var venuesList = ArrayList<VenueListModel>()
    private var recyclerViewClickListener: RecyclerViewClickListener? = null

    fun setVenueList(venuesList: List<VenueListModel>) {
        this.venuesList = venuesList as ArrayList<VenueListModel>
        notifyDataSetChanged()
    }

    fun setRecyclerViewClick(recyclerViewClickListener: RecyclerViewClickListener) {
        this.recyclerViewClickListener = recyclerViewClickListener
    }

    class VenuesViewHolder(viewBinding: VenueListItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        val venueTitleTextView: TextView = viewBinding.venueTitleTextView
        val venueLocationTextView: TextView = viewBinding.venueLocationTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenuesViewHolder {
        return VenuesViewHolder(VenueListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return venuesList.size
    }

    override fun onBindViewHolder(holder: VenuesViewHolder, position: Int) {
        holder.venueTitleTextView.text = venuesList[position].venueName
        holder.venueLocationTextView.text = venuesList[position].venueAddress
        holder.itemView.setOnClickListener {
            recyclerViewClickListener?.onRecyclerViewClick(venuesList[position])
        }
    }

    interface RecyclerViewClickListener {
        fun onRecyclerViewClick(venueListModel: VenueListModel)
    }
}