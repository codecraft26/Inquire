package dev.aman.inquire.individual.ui.home.feeds

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import dev.aman.inquire.databinding.FragmentFeedsBinding
import dev.aman.inquire.individual.data.model.Inquire

class FeedsFragment : Fragment() {
    private lateinit var binding: FragmentFeedsBinding
    private lateinit var mAdapter: FeedsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var inquireList:ArrayList<Inquire>
    private lateinit var db:FirebaseFirestore
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
        recyclerView=binding.feedsRecylerViewer
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        inquireList=ArrayList()
        mAdapter= FeedsAdapter(inquireList)
        recyclerView.adapter=mAdapter
        EvenChangeList()


    }

    private fun EvenChangeList() {
        db = FirebaseFirestore.getInstance()
        db.collection("posts").addSnapshotListener { value, error ->


            if(error!=null){
                Log.e("firebase error",error.message.toString())
                return@addSnapshotListener
            }
            for(dc:DocumentChange in value!!.documentChanges){
                if(dc.type== DocumentChange.Type.ADDED){
                    val inquire=dc.document.toObject(Inquire::class.java)
                    inquireList.add(inquire)
                    mAdapter.notifyDataSetChanged()
                }
            }
        }
    }








}






