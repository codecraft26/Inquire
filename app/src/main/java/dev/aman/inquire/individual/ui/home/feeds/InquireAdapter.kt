package dev.aman.inquire.individual.ui.home.feeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import dev.aman.inquire.R
import dev.aman.inquire.individual.data.model.Inquire

class InquireAdapter(options: FirestoreRecyclerOptions<Inquire>, private val listener: FeedsFragment):
    FirestoreRecyclerAdapter<Inquire, InquireAdapter.PostViewHolder>(options) {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val title:TextView=view.findViewById(R.id.inquire_title)
        val description:TextView=view.findViewById(R.id.inquire_description)
        val date:TextView=view.findViewById(R.id.time_stamp)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int, model: Inquire) {

        holder.title.text=model.title
        holder.description.text=model.description





    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }


}





































    interface IPostAdapter {

    }

