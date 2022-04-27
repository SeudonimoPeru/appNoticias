package com.jhon.appnoticias.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jhon.appnoticias.adapters.AdapterNoticia
import com.jhon.appnoticias.databinding.ActivityMainBinding
import com.jhon.appnoticias.viewModel.MainViewModel
import com.jhon.data.model.bean.news.News
import com.jhon.data.model.dto.MapperClientImpl

class ActMain : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private val adapter = AdapterNoticia(object : AdapterNoticia.OnClickListener {
        override fun onClick(noticia: News) {
            //VOY A WEB VIEW
            val intent = Intent(baseContext, ActWebView::class.java).apply {
                putExtra("data_id", noticia.objectID)
                putExtra("data_url", noticia.getURLValid())
            }
            getResult.launch(intent)

        }

    })
    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val data_id = it.data?.getStringExtra("data_id")
            data_id?.let {
                //se actualiza se oculta
                viewModel.updateVisibilityDB(data_id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            //rcv
            apRcvNews.layoutManager = LinearLayoutManager(baseContext)
            apRcvNews.setHasFixedSize(true)
            apRcvNews.adapter = adapter
            apRcvNews.addItemDecoration(DividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL))

            apSwpRefresh.setOnRefreshListener {
                viewModel.loadNews()
            }
        }

        //cargo new
        viewModel.loadNews()
        //observo lista
        viewModel.lstNewsLiveData.observe(this) { data ->
            // se mapea para pasar de la entidad al objeto News, con la cual se creo el adapter
            val datax = MapperClientImpl().toListBean(data)
            loadData(datax)
        }

        //observo flag
        viewModel.isOffline.observe(this) { flag ->
            viewOffline(flag)
        }


    }

    //muestro oculto view de offline
    fun viewOffline(boolean: Boolean) {
        binding.apSwpRefresh.isRefreshing = false
        binding.apViewOffline.visibility = if (boolean) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    // se carga la fata si es que cambia en room
    fun loadData(data: List<News>) {
        binding.apSwpRefresh.isRefreshing = false

        if (data.isEmpty()) {
            binding.apViewEmpty.visibility = View.VISIBLE
            binding.apRcvNews.visibility = View.GONE
        } else {
            binding.apViewEmpty.visibility = View.GONE
            binding.apRcvNews.visibility = View.VISIBLE
            adapter.swap(data)
        }
    }


}