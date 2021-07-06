package com.danielzbarnes.viewpagernavigation.ui.navFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.danielzbarnes.viewpagernavigation.R

class FragmentViaNavigation: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_via_navigation, container, false)
    }

}