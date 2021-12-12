package ug.sharma.calender.post_task.ui_model

import ug.sharma.calender.post_task.model.TaskModel

sealed class MainUIModel{

    data class OnSucess(var taskModel: TaskModel):MainUIModel()

    data class OnError(var Error:String):MainUIModel()
}
