package ug.sharma.calender.post_fetch_delete_task.onitem_click

import ug.sharma.calender.post_fetch_delete_task.model.Task

interface OnItemDelete {

    fun delete_Item(task: Task)
}