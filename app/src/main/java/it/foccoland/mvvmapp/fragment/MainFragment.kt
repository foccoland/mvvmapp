package it.foccoland.mvvmapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import it.foccoland.mvvmapp.R
import it.foccoland.mvvmapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setButtons()
    }

    fun setButtons() {
        // Retrofit Fragment
        binding.btnRetrofitFragment.setOnClickListener {
            goToRetrofitFragment()
        }

        // ViewModel Fragment
        binding.btnViewmodelFragment.setOnClickListener {
            goToViewModelLearnFragment()
        }

        //Coroutines Fragment
        binding.btnRetrofitFragment.setOnClickListener {
            goToCoroutinesLearnFragment()
        }
    }

    fun goToRetrofitFragment() {
        val action = MainFragmentDirections
            .actionMainFragmentToRetrofitFragment()
        findNavController().navigate(action)
    }

    fun goToViewModelLearnFragment() {
        val action = MainFragmentDirections
            .actionMainFragmentToViewModelLearnFragment()
        findNavController().navigate(action)
    }

    fun goToCoroutinesLearnFragment() {
        val action = MainFragmentDirections
            .actionMainFragmentToCoroutinesLearnFragment()
        findNavController().navigate(action)
    }
}