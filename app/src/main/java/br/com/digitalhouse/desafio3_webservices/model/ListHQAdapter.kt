package br.com.digitalhouse.desafio3_webservices.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafio3_webservices.R
import br.com.digitalhouse.desafio3_webservices.comicsHQ.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hqs.view.*

class ListHQAdapter
    (val listHQS: List<Result>, val listener: onClickLIstenerHQ) :
    RecyclerView.Adapter<ListHQAdapter.viewHolderHQ>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderHQ {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hqs, parent, false)
        return viewHolderHQ(view)
    }

    override fun onBindViewHolder(holder: viewHolderHQ, position: Int) {
        val hq = listHQS[position]
        val picasso = Picasso.get()
        val base = hq.thumbnail.path
        val extension = hq.thumbnail.extension
        val tipoImagem = "/portrait_uncanny."
        val url = base + tipoImagem + extension

        holder.numeroHQ.text = hq.id.toString()
        picasso.load(url).into(holder.imagemCapaHQ)

        holder.itemView.setOnClickListener {
            listener.hqClick(position)
        }
    }

    interface onClickLIstenerHQ {
        fun hqClick(position: Int)
    }


    override fun getItemCount() = listHQS.size

    inner class viewHolderHQ(view: View) : RecyclerView.ViewHolder(view) {
        val imagemCapaHQ: ImageView = view.iv_itemHQ
        val numeroHQ: TextView = view.tv_itemHQ


    }
}