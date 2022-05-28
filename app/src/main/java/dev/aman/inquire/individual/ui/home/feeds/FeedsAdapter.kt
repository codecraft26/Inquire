package dev.aman.inquire.individual.ui.home.feeds

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.aman.inquire.R
import dev.aman.inquire.databinding.ItemPostBinding
import dev.aman.inquire.individual.data.model.Inquire
import dev.aman.inquire.individual.ui.home.HomeFragment
import dev.aman.inquire.individual.ui.home.HomeFragmentDirections
import dev.aman.inquire.utils.Utils

class FeedsAdapter(private val inquireList:ArrayList<Inquire>):RecyclerView.Adapter<FeedsAdapter.FeedsViewHolder>() {
    class FeedsViewHolder(val binding:ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(inquire: Inquire){
           with(binding){
               inquireTitle.text=inquire.title
               inquireDescription.text=inquire.description
               commentButton.setOnClickListener{

               }
               root.setOnClickListener{
                   val action= HomeFragmentDirections.actionHomeFragmentToFeedsDescriptionFragment(
                       inquire.id
                   )
                   it.findNavController().navigate(action)




               }

           }

       }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedsViewHolder {
        return FeedsViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return inquireList.size
    }

    override fun onBindViewHolder(holder: FeedsAdapter.FeedsViewHolder, position: Int) {
        val inquire = inquireList[position]
      holder.bind(inquireList[position])
        /*Glide.with(this).load(model.photo).circleCrop().into(binding.imageViewUserImage)*/



    }
}