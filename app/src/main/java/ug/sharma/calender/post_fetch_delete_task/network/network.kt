package ug.sharma.calender.post_fetch_delete_task.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ug.sharma.calender.post_fetch_delete_task.api.Api_Client
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

object network {

    val base_url="http://13.232.92.136:8084/"

    fun getdatabyntework() :Api_Client {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        return retrofit.create(Api_Client::class.java)
    }


}