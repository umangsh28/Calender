package ug.sharma.calender.post_task.repo

import io.reactivex.rxjava3.core.Observable
import ug.sharma.calender.post_task.model.Get_Task_Model
import ug.sharma.calender.post_task.model.TaskModel
import ug.sharma.calender.post_task.network.network

class Main_Repositary {

    fun getdatabyRepo(userid:String,task:String):Observable<TaskModel>{
        return network.getdatabyntework().postdata(userid,task)
    }
    fun getdatabyRepo1(user:Int):Observable<Get_Task_Model>{
        return network.getdatabyntework().getdata(user)
    }

    fun deletedatabyRepo1(user:Int,task:Int):Observable<Get_Task_Model>{
        return network.getdatabyntework().deletedata(1011,task)
    }

}