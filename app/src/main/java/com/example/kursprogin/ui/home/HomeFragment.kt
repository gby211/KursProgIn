package com.example.kursprogin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursprogin.R
import com.example.kursprogin.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel : HomeViewModel
    private val adapter = AdapterList()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel.readDb()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.text1.observe(viewLifecycleOwner){
            adapter.differ.submitList(it)
            adapter.notifyDataSetChanged()
        }

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putInt("idDisk", it.id)
                putString("nameDisk", it.nameDisk)
                putString("imageDisk", it.imageUrl)
            }
            navController.navigate(
                R.id.detailsFragment,
                bundle
            )
        }
        _binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        _binding!!.recyclerView.adapter = adapter



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}