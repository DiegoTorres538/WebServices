package com.diegotorres.webservices

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegotorres.webservices.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cupon_list_item.view.*

class CuponesAdapter(cuponList:ArrayList<Offer>) :
    RecyclerView.Adapter<CuponesAdapter.CuponesViewHolder>() {

    private var cuponList = ArrayList<Offer>()

    init {
        this.cuponList = cuponList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cupon_list_item, parent, false)
        return CuponesViewHolder(itemView)
    }

    override fun getItemCount(): Int = cuponList.size

    override fun onBindViewHolder(holder: CuponesViewHolder, position: Int) {
        val cupones = cuponList[position]
        holder.setMovie(cupones)
    }

    class CuponesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var cupon: Offer? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setMovie(cupon: Offer) {
            this.cupon = cupon
            val iD = "ID: "
            itemView.tv_title.text = cupon.title
            itemView.tv_store.text = cupon.store
            itemView.tv_startdate.text = cupon.startDate
            //itemView.tv_endate.text = cupon.endDate
            itemView.tv_offertext.text = iD+cupon.lmdId
            //itemView.tv_offervalue.text = cupon.offerValue
            if(!cupon.imageUrl.isNullOrEmpty()){
                Picasso.get().load(cupon.imageUrl).into(itemView.iv_picture)
            }
        }

        override fun onClick(v: View) {
            val intent = Intent(itemView.context, DetalleActivity::class.java)
            intent.putExtra("cupon",cupon)
            itemView.context.startActivity(intent)
        }
    }
}