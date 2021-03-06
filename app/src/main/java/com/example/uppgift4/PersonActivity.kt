package com.example.uppgift4


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.listofpeople.*
import okhttp3.*
import java.io.IOException


class PersonActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listofpeople)
        people.layoutManager = LinearLayoutManager(this)
        fetchJson()
    }


    private fun fetchJson() {
        //val url =toString
     val url=intent.getStringExtra("url")
        //val url= "https://grader.cs.hut.fi/static/CS-EJ4102_2020/_downloads/sample_json.json"
        val request = Request.Builder().url(url).build()
        var client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                val myCustom = "{\"persons\":" + body + "}";


                val gson = GsonBuilder().create()
                val persons = gson.fromJson(myCustom, Persons::class.java)


                runOnUiThread {
                    people.adapter = MainAdapter(persons)
                }




            }

            override fun onFailure(call: Call, e: IOException) {
                println("FAILED FETCH JSON")
            }
        })

    }
}
class Persons(val persons: List<People>)
class People(val name: String, val city: String, val photo: String)






