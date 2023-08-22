package kr.hs.emirim.kkhhss.simple_webbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var editUrl : EditText
    lateinit var btnGo : Button
    lateinit var btnBack : Button
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editUrl = findViewById(R.id.edit_url)
        btnGo = findViewById(R.id.btnGo)
        btnBack = findViewById(R.id.btnBack)
        webView = findViewById(R.id.webView)

        webView.webViewClient = mirimWebViewClient()
        var webSet = webView.settings
        webSet.builtInZoomControls = true

        btnGo.setOnClickListener{
            webView.loadUrl(editUrl.text.toString())
        }
        btnBack.setOnClickListener{
            webView.goBack()
        }

    }

    class mirimWebViewClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }
    }
}