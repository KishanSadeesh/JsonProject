package com.example.jsonproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.jsonproject.databinding.ActivityMainBinding
import com.example.jsonproject.network.MarsApi
import com.example.jsonproject.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    var MarsPhotoDataBinding = MarsPhoto("123", "com.marsphotos.in")
    //lateinit var MarsRecyclerView: RecyclerView
    lateinit var marsAdapter: MarsAdapter
    lateinit var Photos: List<MarsPhoto>
    //lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //imageView = findViewById(R.id.imageView)
        //MarsRecyclerView = findViewById(R.id.RecyclerView)
        binding.marsphotoxml = MarsPhotoDataBinding

        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        Photos = ArrayList()
        marsAdapter = MarsAdapter(Photos)
        binding.RecyclerView.adapter = marsAdapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun getMarsPhotos() {
        GlobalScope.launch (Dispatchers.Main){
            var listMarsPhotos =   MarsApi.retrofitService.getPhotos()
            marsAdapter.listMarsPhotos = listMarsPhotos

            marsAdapter.notifyDataSetChanged()

            Log.i("Main Activity", listMarsPhotos.get(0).imgSrc)
        }
    }

    fun getJson(view: View) {
        getMarsPhotos()

    }

}

