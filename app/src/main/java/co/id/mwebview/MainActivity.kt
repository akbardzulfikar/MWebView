package co.id.mwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
//                Toast.makeText(applicationContext, "Web Dicoding berhasil dimuat", Toast.LENGTH_LONG).show()
                view.loadUrl("javascript:alert('Web Dicoding berhasil dimuat')")
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: JsResult): Boolean {
                Toast.makeText(this@MainActivity, message,Toast.LENGTH_LONG).show()
                result.confirm()
                return true
            }
        }

        webView.loadUrl("https://www.dicoding.com")
    }
}