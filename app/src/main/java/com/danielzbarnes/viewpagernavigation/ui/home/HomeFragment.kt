package com.danielzbarnes.viewpagernavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.danielzbarnes.viewpagernavigation.R
import com.danielzbarnes.viewpagernavigation.ui.viewpager.FragmentListContainerDirections

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var navButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        navButton = root.findViewById(R.id.nav_button)
        navButton.setOnClickListener {

            // even though the button is in the HomeFragment
            // the navigation still technically happens from the fragment containing the viewpager which holds the fragment
            val action = FragmentListContainerDirections.actionFragmentListContainerToFragmentViaNavigation()
            findNavController().navigate(action)
        }

        return root
    }

    companion object{
        fun newInstance(): HomeFragment{
            return HomeFragment()
        }
    }
}