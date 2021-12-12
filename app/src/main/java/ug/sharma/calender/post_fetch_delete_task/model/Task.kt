package ug.sharma.calender.post_fetch_delete_task.model


import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("task_detail")
    val taskDetail: String,
    @SerializedName("task_id")
    val taskId: Int
)