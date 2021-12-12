package ug.sharma.calender.post_fetch_delete_task.model


import com.google.gson.annotations.SerializedName

data class Get_Task_Model(
    @SerializedName("tasks")
    val tasks: List<Task>
)