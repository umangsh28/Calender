package ug.sharma.calender.post_task.onitem_click

import ug.sharma.calender.post_task.model.Task

interface OnItemDelete {

    fun delete_Item(task: Task)
}