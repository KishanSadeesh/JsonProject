package com.example.jsonproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jsonproject.network.MarsApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun getMarsPhotos() {
        GlobalScope.launch {
            var listMarsPhotos =   MarsApi.retrofitService.getPhotos()
            //var tvHome: TextView = findViewById(R.id.tvHome)
            //tvHome.setText(listMarsPhotos.get(1).imgSrc)
            Log.i("homeactiviy",listMarsPhotos.size.toString())
            Log.i("homeactivity-url",listMarsPhotos.get(1).imgSrc)

        }
    }

    fun getJson(view: View) {
        getMarsPhotos()

    }

}

