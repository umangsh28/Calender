package ug.sharma.calender.post_task.model


import com.google.gson.annotations.SerializedName

data class Get_Task_Model(
    @SerializedName("tasks")
    val tasks: List<Task>
)