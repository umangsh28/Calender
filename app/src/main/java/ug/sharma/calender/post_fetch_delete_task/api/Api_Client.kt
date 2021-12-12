package ug.sharma.calender.post_fetch_delete_task.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*
import ug.sharma.calender.post_fetch_delete_task.model.Get_Task_Model
import ug.sharma.calender.post_fetch_delete_task.model.TaskModel

interface Api_Client {


    @POST("api/storeCalendarTask")
    @FormUrlEncoded
    fun postdata(
        @Field("user_id")
        user: String,
        @Field("task")
        task: String
    ): Observable<TaskModel>



    @POST("api/getCalendarTaskLists")
    @FormUrlEncoded
    fun getdata(
        @Field("user_id")
        user: Int,
    ): Observable<Get_Task_Model>

    @POST("api/deleteCalendarTask")
    @FormUrlEncoded
    fun deletedata(
        @Field("user_id")
        user: Int,
        @Field("task_id")
        task: Int
    ): Observable<Get_Task_Model>



}