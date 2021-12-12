package ug.sharma.calender.post_fetch_delete_task.recycler

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_design2.view.*
import ug.sharma.calender.post_fetch_delete_task.model.Task
import ug.sharma.calender.post_fetch_delete_task.onitem_click.OnItemDelete

class TaskHolder(val itemtype: View,val listner:OnItemDelete):RecyclerView.ViewHolder(itemtype){

    fun setdata(taskModel: Task){
        itemtype.apply {
            Fetch_task.text=taskModel.taskDetail
            Log.d("umang",taskModel.taskDetail)
            btn_delete.setOnClickListener {
                listner.delete_Item(taskModel)
            }
        }
    }

}