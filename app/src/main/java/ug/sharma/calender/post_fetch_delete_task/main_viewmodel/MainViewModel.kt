package ug.sharma.calender.post_fetch_delete_task.main_viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ug.sharma.calender.post_fetch_delete_task.model.Get_Task_Model
import ug.sharma.calender.post_fetch_delete_task.model.TaskModel
import ug.sharma.calender.post_fetch_delete_task.repo.Main_Repositary
import ug.sharma.calender.post_fetch_delete_task.ui_model.Get_MainUIModel

class MainViewModel:ViewModel() {

    val repo=Main_Repositary()

    private lateinit var disposable: Disposable

    private lateinit var disposable1: Disposable

    private var mutableLiveData=MutableLiveData<Get_MainUIModel>()

     var liveData:LiveData<Get_MainUIModel> = mutableLiveData


    fun getdatabyVmodel(user:String,task:String){ // post request

        repo.getdatabyRepo(user,task).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<TaskModel>{
                override fun onSubscribe(d: Disposable) {
                    disposable=d
                }

                override fun onNext(t: TaskModel) {
                }

                override fun onError(e: Throwable) {
                    Log.d("umang",e.message.toString())
                }

                override fun onComplete() {
                    Log.d("umang","complete-t.task")
                }

            })
    }


    fun getdatabyVmodel1(user:Int){ // fetch data request

        repo.getdatabyRepo1(user).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<Get_Task_Model>{
                override fun onSubscribe(d: Disposable) {
                    disposable1=d
                }

                override fun onNext(t: Get_Task_Model) {
                    mutableLiveData.value=Get_MainUIModel.OnSucesss(t)
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {

                }

            })
    }

    fun deletedatabyVmodel1(user:Int,task:Int){ // delete data request

        repo.deletedatabyRepo1(1011,task).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<Get_Task_Model>{
                override fun onSubscribe(d: Disposable) {
                    disposable1=d
                }

                override fun onNext(t: Get_Task_Model) {

                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }

            })
    }




}