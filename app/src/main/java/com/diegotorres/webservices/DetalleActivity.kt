package com.diegotorres.webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diegotorres.webservices.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalle.*
import kotlinx.android.synthetic.main.cupon_list_item.view.*

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val cupon = intent?.getSerializableExtra("cupon") as Offer
        updateCupon(cupon)
    }

    private fun updateCupon(cupon: Offer) {
        tv_titledetail.text = cupon.title
        tv_descriptiondetail.text = cupon.description
        tv_fecha.text = cupon.endDate
        if(!cupon.imageUrl.isNullOrEmpty()){
            Picasso.get().load(cupon.imageUrl).into(iv_imgdetail)
        }
    }
}
