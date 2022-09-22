package com.guruthedev.retrofitusingapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.guruthedev.retrofitusingapi.api.ApiInterface
import com.guruthedev.retrofitusingapi.api.ApiUtilities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userApi = ApiUtilities.getInstance().create(ApiInterface::class.java)
        GlobalScope.launch {
            val result = userApi.getUserDetails()
            if(result.body()!=null){
                result.body()!!.iterator().forEach {
                    Log.d("onCreate: ","${it.login}")
                }
//                Log.i("yous","${result.body()}")
            }
        }
    }
}
