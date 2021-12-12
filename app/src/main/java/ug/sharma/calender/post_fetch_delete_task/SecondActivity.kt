package ug.sharma.calender.post_fetch_delete_task

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*
import ug.sharma.calender.R
import ug.sharma.calender.post_fetch_delete_task.main_viewmodel.MainViewModel
import ug.sharma.calender.post_fetch_delete_task.model.Get_Task_Model
import ug.sharma.calender.post_fetch_delete_task.model.Task
import ug.sharma.calender.post_fetch_delete_task.onitem_click.OnItemDelete
import ug.sharma.calender.post_fetch_delete_task.recycler.TaskAdapter
import ug.sharma.calender.post_fetch_delete_task.ui_model.Get_MainUIModel

class SecondActivity : AppCompatActivity(),OnItemDelete{

    private lateinit var mainViewModel: MainViewModel
    private lateinit var taskAdapter: TaskAdapter

    private var Dates=""
    private var Month=""

    private var list:Get_Task_Model?=null



    // this is for posting task to server &  then fetching  & deleting it from server
    // basic structure -> api_client->network->repo(instance of api_client)->view model & ui_model(sealed class)->second activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)


        data_from_intent()

        btn_task.setOnClickListener {
            //adding data to api
            val task=ET_Task.text.toString()
            mainViewModel.getdatabyVmodel(1011.toString(),"$Dates-$Month Your_Task:$task")
            Toast.makeText(this,"Data added to api",Toast.LENGTH_SHORT).show()


        }


        Btn_fetch_task.setOnClickListener {
            //fetching api
            callApi()
            Toast.makeText(this,"Data Fetch from api",Toast.LENGTH_SHORT).show()
        }

        Btn_refresh.setOnClickListener {
            callApi()  //refreshing after deleting
            Toast.makeText(this,"Data Refresh from api",Toast.LENGTH_SHORT).show()

        }





    }

    private fun callApi() {
        mainViewModel.getdatabyVmodel1(1011)
        mainViewModel.liveData.observe(this,{
            when(it){
                is Get_MainUIModel.OnSucesss ->{
                    list= it.taskModel
                    Log.d("umang",it.toString())
                    setrecycler()
                }
                is Get_MainUIModel.OnErrorr->{
                    Log.d("umang",it.Error)
                }
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setrecycler() {
        //setting recycler for  user task
        taskAdapter= TaskAdapter(list!!,this)
        recycler_response.adapter=taskAdapter
        recycler_response.layoutManager=LinearLayoutManager(this)
        taskAdapter.notifyDataSetChanged()
    }


    fun data_from_intent(){//getting data from intent
        Month= intent.getStringExtra("month").toString()
        Dates=intent.getIntExtra("date",0).toString()
        date.text=Dates
        month.text=Month
    }

    override fun delete_Item(task: Task) {
        //deleting item
        mainViewModel.deletedatabyVmodel1(1011,task.taskId)
        Toast.makeText(this,"Data deleted from api \n Please Refresh",Toast.LENGTH_SHORT).show()
    }


}