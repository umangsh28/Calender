package ug.sharma.calender.post_fetch_delete_task.repo

import io.reactivex.rxjava3.core.Observable
import ug.sharma.calender.post_fetch_delete_task.model.Get_Task_Model
import ug.sharma.calender.post_fetch_delete_task.model.TaskModel
import ug.sharma.calender.post_fetch_delete_task.network.network

class Main_Repositary {

    fun getdatabyRepo(userid:String,task:String):Observable<TaskModel>{ // post data
        return network.getdatabyntework().postdata(userid,task)
    }
    fun getdatabyRepo1(user:Int):Observable<Get_Task_Model>{// fetch data
        return network.getdatabyntework().getdata(user)
    }

    fun deletedatabyRepo1(user:Int,task:Int):Observable<Get_Task_Model>{ // delete data, userid is permanent so hardcoding it.
        return network.getdatabyntework().deletedata(1011,task)
    }

}