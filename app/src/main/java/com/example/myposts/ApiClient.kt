package com.example.myposts

import retrofit2.Retrofit  //librrary used to maske HTTP
import retrofit2.converter.gson.GsonConverterFactory

//create api object
//a base url function ,also function all are builder patternn
object ApiClient {
    var retrofit =  Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")//cerate a domain  we want to connunicate
        .addConverterFactory(GsonConverterFactory.create())  //changes json ojects to creating kotlin bjects
        .build()
    fun<T>buildApiClient(apiInterface: Class<T>):T{

        return retrofit.create(apiInterface)
    }


}