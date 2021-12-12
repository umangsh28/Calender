package ug.sharma.calender.post_task.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ug.sharma.calender.R
import ug.sharma.calender.post_task.model.Get_Task_Model
import ug.sharma.calender.post_task.model.Task
import ug.sharma.calender.post_task.onitem_click.OnItemDelete

class TaskAdapter(var taskModel: Get_Task_Model,var listener:OnItemDelete) :RecyclerView.Adapter<TaskHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): TaskHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_design2,parent,false)
        return TaskHolder(view,listener)
    }

    override fun onBindViewHolder(holder: TaskHolder, pos: Int) {
        val result :Task=taskModel.tasks[pos]
        holder.setdata(result)
    }

    override fun getItemCount(): Int {
        return taskModel.tasks.size
    }
}