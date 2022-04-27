package com.jhon.appnoticias.activity

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.jhon.appnoticias.databinding.ActivityWebBinding


class ActWebView : AppCompatActivity() {


    private lateinit var binding: ActivityWebBinding
    override fun onBackPressed() {
        // se configura el btnback
        when {
            binding.webView.canGoBack() -> {
                binding.webView.goBack()
            }
            else -> {

                val intent = Intent()
                intent.putExtra("data_id", dataID)
                setResult(RESULT_OK, intent)

                super.onBackPressed()
            }
        }
    }

    var dataID: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            webView.webViewClient = object : WebViewClient() {}
            webView.webChromeClient = object : WebChromeClient() {
                override fun onReceivedTitle(view: WebView, title: String) {
                    super.onReceivedTitle(view, title)
                }
            }
            awImbBack.setOnClickListener {
                onBackPressed()
            }

        }


        loadData()

    }
    //se carga el webview
    fun loadData() {
        dataID = intent.getStringExtra("data_id")
        val dataURL = intent.getStringExtra("data_url")
        dataURL?.let {
            binding.webView.loadUrl(it)
        } ?: run {
            finish()
        }
    }

    override fun onDestroy() {
        binding.webView.destroy()
        super.onDestroy()
    }


    override fun onPause() {
        binding.webView.onPause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        binding.webView.onResume()
    }


}