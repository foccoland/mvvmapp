package it.foccoland.mvvmapp.rest.service

import it.foccoland.mvvmapp.rest.model.Photo
import it.foccoland.mvvmapp.rest.model.Photos
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("/photos")
    suspend fun getPhotos(): Response<Photos>
}