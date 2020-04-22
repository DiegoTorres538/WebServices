package com.diegotorres.webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diegotorres.webservices.model.Cupones
import com.diegotorres.webservices.model.Offer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var listCupon = ArrayList<Offer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        loadList()
    }

    private fun loadList(){
        val apiKey = "1fb8ac7ca6031d934faa5f3f1098cd99"
        apiService.create().getCuponStore(apiKey).enqueue(object: Callback<Cupones>{
            override fun onFailure(call: retrofit2.Call<Cupones>, t: Throwable) {
                Log.d("Error:", t.message)
            }

            override fun onResponse(call: retrofit2.Call<Cupones>, response: Response<Cupones>) {
                if(response.isSuccessful){
                    listCupon = response.body()!!.offers as ArrayList<Offer>
                    val cuponesAdapter = CuponesAdapter(listCupon)
                    recyclerView.adapter = cuponesAdapter
                }
            }

        })
    }
}
