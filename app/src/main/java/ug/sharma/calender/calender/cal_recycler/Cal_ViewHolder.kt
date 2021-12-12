package ug.sharma.calender.calender.cal_recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_design.view.*
import ug.sharma.calender.calender.cal_data.data_number
import ug.sharma.calender.calender.interfacee.OnDateSelect

class Cal_ViewHolder(val itemView: View,val listener:OnDateSelect):RecyclerView.ViewHolder(itemView) {

    fun setdata( dataNumber: Int,pos:Int){
        itemView.apply {
            cal_number.text= dataNumber.toString()

            cal_number.setOnClickListener {
                listener.OnItemDate(pos)
            }
        }
    }
}