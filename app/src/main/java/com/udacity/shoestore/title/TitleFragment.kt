package com.udacity.shoestore.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.EventObserver
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentTitleBinding
import com.udacity.shoestore.ShareViewModel


// TODO: Rename parameter arguments, choose names that match


class TitleFragment : Fragment() {


    private val viewModel: ShareViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Observing the showToast event, call in the textClick function
        viewModel.toastEvent.observe(this, EventObserver { message ->
            Toast.makeText(context, message , Toast.LENGTH_SHORT).show()
        })
        // Observing the navigate event, call in the textClick function
        viewModel.welcomeNavigationEvent.observe(this, EventObserver{
            findNavController().navigate(R.id.action_titleFragment_to_welcomeFragment)
        })

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        binding.viewModel = viewModel
        return binding.root

    }

}
