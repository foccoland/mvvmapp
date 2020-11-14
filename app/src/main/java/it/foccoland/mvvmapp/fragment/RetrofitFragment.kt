package it.foccoland.mvvmapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import it.foccoland.mvvmapp.R
import it.foccoland.mvvmapp.databinding.FragmentRetrofitBinding
import it.foccoland.mvvmapp.rest.model.Photos
import it.foccoland.mvvmapp.rest.service.PhotoService
import it.foccoland.mvvmapp.rest.service.RetrofitInstance
import retrofit2.Response

class RetrofitFragment : Fragment() {

    private lateinit var binding: FragmentRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_retrofit, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(PhotoService::class.java)

        val responseLiveData: LiveData<Response<Photos>> = liveData {
            val response = retrofitService.getPhotos()
            emit(response)
        }

//        responseLiveData.observe(this, Observer {
//            val photos = it.body()?.listIterator()
//            photos?.let {
//                // act for get photo data
//            }
//        })

    }

}