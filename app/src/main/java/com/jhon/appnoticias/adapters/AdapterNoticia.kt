package com.jhon.appnoticias.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jhon.appnoticias.R
import com.jhon.data.model.bean.news.News
import java.text.SimpleDateFormat
import java.util.*

class AdapterNoticia(val listener: OnClickListener) : RecyclerView.Adapter<AdapterNoticia.NoticiaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoticiaViewHolder(layoutInflater.inflate(R.layout.item_noticia, parent, false))
    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int = items.size

    private var items: List<News> = emptyList()

    //nueva data
    fun swap(items: List<News>) {
        this.items = items
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClick(noticia: News)
    }

    class NoticiaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val txvTitle = view.findViewById<TextView>(R.id.title)
        val txvFecha = view.findViewById<TextView>(R.id.fechapublicacion)
        val txvAuthor = view.findViewById<TextView>(R.id.author)


        fun bind(beanNoticia: News, listener: OnClickListener) {

            // se configura logica de como se compartara el  view con los datos
            with(beanNoticia) {
                txvTitle.text = story_title
                txvFecha.text = getDateTime(created_at_i ?: 0, created_at)
                txvAuthor.text = author
                view.setOnClickListener {
                    listener.onClick(beanNoticia)
                }
            }
        }
        // se da formato a la fecha
        fun getDateTime(timestamp: Int, date: String?): String {
            var newDate: String = date ?: ""
            runCatching {
                val sdf = SimpleDateFormat("YYYY-MM-dd HH:mm aa", Locale.getDefault())
                val netDate = Date(timestamp.toLong() * 1000)
                sdf.format(netDate)
            }.onSuccess {
                newDate = it
            }
            return newDate
        }
    }


}
