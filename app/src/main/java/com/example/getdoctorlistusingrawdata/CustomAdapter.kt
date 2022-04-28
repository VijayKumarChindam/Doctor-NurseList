package com.example.getdoctorlistusingrawdata
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.getdoctorlistusingrawdata.Model.Datamodel
import com.example.getdoctorlistusingrawdata.data.DoctorData
import java.util.*
import kotlin.collections.ArrayList

class CustomAdapter(
    private var context: Context,
    private var personNames: ArrayList<String>,
    private var role: ArrayList<String>,
    private var date: ArrayList<String>,
    private var cases: ArrayList<String>,

) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rowlayout, parent, false)
        return MyViewHolder(v)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


//        var personNames= personNames.toSet().toList() as ArrayList<String>
        holder.tvname.text = "Name:- " + personNames[position]
        holder.tvrole.text = "Role:- " + role[position]
        if (role.contains("Doctor")){
            holder.tvdate.text = "TAT:- " + date[position]

        }
        else{
            date.clear()
        }
        if (role.contains("Doctor")){
            holder.tvcase.text="Consultations:-"+cases[position]

        }
        else{
            holder.tvcase.text="Cases:-"+cases[position]
        }



    }
    override fun getItemCount(): Int {
        return personNames.size
    }
    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var tvname: TextView = itemView.findViewById<View>(R.id.tvName) as TextView
        var tvrole: TextView = itemView.findViewById<View>(R.id.tvEmail) as TextView
        var tvdate: TextView = itemView.findViewById<View>(R.id.tvDate) as TextView
        var tvcase: TextView = itemView.findViewById<View>(R.id.tvcases) as TextView


    }
}