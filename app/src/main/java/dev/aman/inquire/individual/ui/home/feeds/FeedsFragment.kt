package dev.aman.inquire.individual.ui.home.feeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import dev.aman.inquire.databinding.FragmentFeedsBinding
import dev.aman.inquire.individual.data.InquireViewModel
import dev.aman.inquire.individual.data.model.Inquire


class FeedsFragment : Fragment() {
    private lateinit var binding: FragmentFeedsBinding
    private lateinit var mAdapter:InquireAdapter
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFeedsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        val postCollections=InquireViewModel().inquireCollections
        val query = postCollections.orderBy("createdAt", Query.Direction.DESCENDING)
        val recyclerViewOption = FirestoreRecyclerOptions.Builder<Inquire>().setQuery(query, Inquire::class.java).build()
        mAdapter = InquireAdapter(recyclerViewOption, this)
        binding.feedsRecylerViewer.adapter=mAdapter
      binding.feedsRecylerViewer.layoutManager=LinearLayoutManager(context)

    }




}
