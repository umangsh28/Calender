package ug.sharma.calender

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ug.sharma.calender.calender.cal_recycler.Cal_Adapter
import ug.sharma.calender.calender.interfacee.OnDateSelect
import ug.sharma.calender.post_fetch_delete_task.SecondActivity


class MainActivity : AppCompatActivity(), OnDateSelect {

    private var calAdapter: Cal_Adapter? = null
    private var list = mutableListOf<Int>()
    private var year_list = mutableListOf<Int>()
    private var month_list = mutableListOf<String>()
    private lateinit var yspin: Spinner
    private lateinit var mspin: Spinner
    private var YEAR = ""
    private var MONTH = ""
    lateinit var preferences: SharedPreferences



    // this is first activity for showing calender & assigning listener on date
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences("umang", Context.MODE_PRIVATE)


        year_spinner()
        month_spinner()

        setrecyler()


    }


    private fun year_spinner() {//  assigning year from spinner for year
        for (i in 2021 downTo 1990) {
            year_list.add(i)
        }
        val Yspinner = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, year_list)
        Yspinner.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        yspin = findViewById<Spinner>(R.id.year)
        yspin.adapter = Yspinner
        yspin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                YEAR = yspin.getItemAtPosition(position).toString()
                cal_year.text = YEAR
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }


    private fun month_spinner() {// assiging month from spinner for month

        month_list = arrayListOf(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        )

        val Mspinner = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, month_list)
        Mspinner.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        mspin = findViewById<Spinner>(R.id.month)
        mspin.adapter = Mspinner


        mspin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                MONTH = mspin.getItemAtPosition(position).toString()
                cal_months.text = MONTH


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }


    fun insert_data() { //insert dates to recycler View
        for (i in 1..30) {
            list.addAll(listOf(i))

        }
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun setrecyler() { // agrid layout to show dates in an appropriate way
        insert_data()
        if (list != null) {
            calAdapter = list.let { Cal_Adapter(it, this) }
        } else {
            Log.d("umang", "Empty list")
        }
        recyler_cal.adapter = calAdapter
        recyler_cal.layoutManager = GridLayoutManager(this, 6)


        calAdapter?.notifyDataSetChanged()
    }


    override fun OnItemDate(pos: Int) {//using interface to transfer data on click of any date  ,now second activity will open
        val i = Intent(this, SecondActivity::class.java)
        i.putExtra("year", YEAR)
        i.putExtra("month", MONTH)
        i.putExtra("date", list[pos])
        startActivity(i)
    }


}