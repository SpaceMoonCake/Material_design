package com.spacemooncake.materialdesign.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.spacemooncake.materialdesign.R
import com.spacemooncake.materialdesign.databinding.FragmentFirstBinding
import com.spacemooncake.materialdesign.databinding.PictureOfTheDayFragmentBinding
import com.spacemooncake.materialdesign.viewmodel.AppState
import com.spacemooncake.materialdesign.viewmodel.PictureOfTheDayViewModel

class PictureOfTheDayFragment : Fragment() {

    private var _binding: PictureOfTheDayFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PictureOfTheDayFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveDate().observe(viewLifecycleOwner, object : Observer<AppState>{
            override fun onChanged(t: AppState?) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}