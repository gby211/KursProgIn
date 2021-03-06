package com.example.kursprogin.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.kursprogin.R
import com.example.kursprogin.databinding.FragmentProfileBinding
import com.example.kursprogin.discLiked
import com.example.kursprogin.discViewed
import com.example.kursprogin.modelProfileAll

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        binding.buttonAbout.setOnClickListener{
            navController.navigate(R.id.aboutAppFragment)
        }
        binding.profile.text = android.os.Build.MODEL
        binding.textViewDiscsLiked.text = modelProfileAll.liked.toString()
        binding.textViewDiscsViewed.text = modelProfileAll.viewed.toString()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}