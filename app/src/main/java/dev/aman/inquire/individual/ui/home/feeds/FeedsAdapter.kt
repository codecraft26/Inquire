package dev.aman.inquire.individual.ui.home.feeds

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.aman.inquire.R
import dev.aman.inquire.individual.data.model.Inquire
import dev.aman.inquire.utils.Utils

class FeedsAdapter(private val inquireList:ArrayList<Inquire>):RecyclerView.Adapter<FeedsAdapter.FeedsViewHolder>() {
    class FeedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.inquire_title)
        val description: TextView = itemView.findViewById(R.id.inquire_description)
        val time: TextView = itemView.findViewById(R.id.time_stamp)
        val image:ImageView=itemView.findViewById(R.id.inquire_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedsViewHolder {
        val itemView = View.inflate(parent.context, R.layout.item_post, null)
        return FeedsViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return inquireList.size
    }

    override fun onBindViewHolder(holder: FeedsAdapter.FeedsViewHolder, position: Int) {
        val inquire = inquireList[position]
        holder.title.text = inquire.title
        holder.description.text = inquire.description
        /*Glide.with(this).load(model.photo).circleCrop().into(binding.imageViewUserImage)*/



    }
}