package com.example.birthdaygreet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.birthdaygreet.databinding.FragmentBirthdayBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BirthdayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BirthdayFragment : Fragment() {

      private val sharedViewModel : NameViewModel by activityViewModels()

      private var binding : FragmentBirthdayBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentBirthdayBinding.inflate(inflater, container,false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {

            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            birthdayFragment = this@BirthdayFragment
        }
    }


}