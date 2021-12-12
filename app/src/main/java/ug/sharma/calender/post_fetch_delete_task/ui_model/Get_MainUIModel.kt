package ug.sharma.calender.post_fetch_delete_task.ui_model

import ug.sharma.calender.post_fetch_delete_task.model.Get_Task_Model

sealed class Get_MainUIModel{
    data class OnSucesss(var taskModel: Get_Task_Model):Get_MainUIModel()

    data class OnErrorr(var Error:String):Get_MainUIModel()
}
