package dev.aman.inquire.individual.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.aman.inquire.R
import dev.aman.inquire.individual.model.Inquire
import dev.aman.inquire.individual.ui.home.feeds.FeedsFragment

class HomeAdapter(
    private val context: FeedsFragment,
    private val dataset: List<Inquire>
): RecyclerView.Adapter<HomeAdapter.ItemViewHolder>(){
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.textView_title)
        val description: TextView = view.findViewById(R.id.textView_description)
        val image: ImageView = view.findViewById(R.id.imageView_output)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_inquire, parent, false)

        return ItemViewHolder(adapterLayout)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
       holder.title.text = item.stringResourceId
        holder.description.text = item.descriptionResourceId
        holder.image.setImageResource(item.imageResourceId)
    }
    override fun getItemCount() = dataset.size





}