package ru.surf.cocktailbar.ui.main_fragment

import androidx.fragment.app.Fragment
import ru.surf.cocktailbar.R
import ru.surf.cocktailbar.databinding.FragmentMainBinding
import ru.surf.cocktailbar.ui.base.viewBinding


class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding { FragmentMainBinding.bind(it) }
//    private val applicationComponent
//        get() = App.get(requireContext()).applicationComponent

}