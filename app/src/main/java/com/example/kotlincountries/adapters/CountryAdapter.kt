package com.example.kotlincountries.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountries.R
import com.example.kotlincountries.model.CountryModel
import com.example.kotlincountries.modules.GlideApp


class CountryAdapter (var context: Context): RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    private var list: List<CountryModel>? = null

    fun setData(data: List<CountryModel>){
        list = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list?.get(position)

        if (item != null) {
            holder.name.text = item.name
            holder.capital.text = item.capital
            holder.pupulation.text = item.population
            GlideApp
                .with(context).load(item.flag)
                .placeholder(R.mipmap.giphy)
                .into(holder.flag)
        }

    }

    override fun getItemCount(): Int {
      return list?.size!!
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.tvname)
        val pupulation : TextView = itemView.findViewById(R.id.tvPopulation)
        val capital : TextView = itemView.findViewById(R.id.tvCapital)
        val flag : ImageView = itemView.findViewById(R.id.flag)
    }
}