package ug.sharma.calender.calender.cal_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import ug.sharma.calender.R
import ug.sharma.calender.calender.cal_data.data_number
import ug.sharma.calender.calender.interfacee.OnDateSelect

class Cal_Adapter(var listitem:List<Int>,var listener:OnDateSelect):RecyclerView.Adapter<Cal_ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): Cal_ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_design,parent,false)
        return Cal_ViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: Cal_ViewHolder, p1: Int) {
        val result:Int=listitem[p1]
        holder.setdata(result,p1)
    }

    override fun getItemCount(): Int {
        return listitem.size
    }
}