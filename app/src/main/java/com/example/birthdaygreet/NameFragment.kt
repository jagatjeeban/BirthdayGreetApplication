package com.example.birthdaygreet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.birthdaygreet.databinding.NameFragmentBinding


class NameFragment : Fragment() {

    private val sharedViewModel: NameViewModel by activityViewModels()

    private var binding: NameFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = NameFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {

            wishButton.setOnClickListener { wishButton(binding?.nameInput?.text.toString()) }
        }

        binding?.nameFragment = NameFragment()
    }

    private fun wishButton(nameText: String) {

        sharedViewModel.setName(nameText)

        if (sharedViewModel.hasNoNameSet()) {
            Toast.makeText(requireContext(), "Enter name", Toast.LENGTH_SHORT).show()
        } else {
            findNavController().navigate(R.id.action_nameFragment_to_birthdayFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null


    }

}