package com.example.kursprogin.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursprogin.data.room.DbRoom
import com.example.kursprogin.databinding.FragmentFavoriteBinding
import com.example.kursprogin.ui.home.AdapterList
import kotlinx.coroutines.runBlocking

lateinit var dbbbb: DbRoom

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val adapter = AdapterList()
    private lateinit var favoriteViewModel : FavoriteViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbbbb = DbRoom(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoriteViewModel =
            ViewModelProvider(this).get(FavoriteViewModel::class.java)



        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        _binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        _binding!!.recyclerView.adapter = adapter
        runBlocking { favoriteViewModel.readDbRoom() }
        favoriteViewModel.text1.observe(viewLifecycleOwner){
                adapter.differ.submitList(it)
                adapter.notifyDataSetChanged()
            }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        runBlocking { favoriteViewModel.readDbRoom() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}