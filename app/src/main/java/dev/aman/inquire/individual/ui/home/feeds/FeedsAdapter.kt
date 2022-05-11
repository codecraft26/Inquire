package dev.aman.inquire.individual.ui.home.feeds/*
package dev.aman.inquire.individual.ui.home.feeds

*//*

package dev.aman.inquire.individual.ui.home.feeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.aman.inquire.R
import dev.aman.inquire.individual.model.Inquire

class FeedsAdapter(
    private val context: FeedsFragment,
    private val dataset: List<Inquire>
):RecyclerView.Adapter<FeedsAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.inquire_title)
        val description: TextView = view.findViewById(R.id.inquire_description)
        val image: ImageView = view.findViewById(R.id.inquire_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_inquire, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.text = item.title
        holder.description.text = item.description
        holder.image.setImageResource(item.profile)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}

*/
