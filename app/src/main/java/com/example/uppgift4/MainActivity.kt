package com.example.uppgift4

import android.content.Intent
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.listofpeople.*
import okhttp3.*
import java.io.IOException




class MainActivity() : AppCompatActivity() {


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val urlButton = findViewById<Button>(R.id.button)
    urlButton.setOnClickListener {

        val bool=URLUtil.isValidUrl(url_field.text.toString())
      if(bool==true) {
            val intent = Intent(this, PersonActivity::class.java)
            intent.putExtra("url",url_field.text.toString())

            startActivity(intent)
      }
    }


}



}


















/*
            client.newCall(request).enqueue(object : Callback {
                        override fun onFailure(call: Call, e: IOException) {
                            println("FUCK OFF")
                            e.printStackTrace()
                        }

                        override fun onResponse(call: Call, response: Response) {
                            if (response.isSuccessful) {
                                val responseData = response.body()?.string()
                                var json = JSONObject(responseData)
                                println("Request Successful!!")
                                println(json)
                                val responseObject = json.getJSONObject("response")
                                val docs = json.getJSONArray("docs")
                                println(response)
                            }
                        }



                    })*/
























