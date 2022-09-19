@file:Suppress("DEPRECATION")

package aaa.bivizul.a30project.android

import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTDOR
import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTKOR
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class ApostActivity : AppCompatActivity() {

    private lateinit var apostwv: WebView
    var filePathCallback: ValueCallback<Array<Uri>>? = null
    private val REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apost)

        apostwv = findViewById(R.id.apostweb)
        apostwv.webViewClient = WebViewClient()

        apostwv.webChromeClient = MyChromeClient()
        apostwv.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        apostwv.isScrollbarFadingEnabled = false

        setSettings()

        val aposturl = intent.getStringExtra(APOSTKOR) ?: APOSTDOR

        if (savedInstanceState == null) {
            apostwv.post {
                kotlin.run { apostwv.loadUrl(aposturl) }
            }
        }

        apostwv.canGoBack()
        apostwv.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                apostwv.canGoBack()
            ) {
                apostwv.goBack()
                return@OnKeyListener true
            }
            false
        })
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setSettings() {
        val apostws = apostwv.settings
        apostws.javaScriptEnabled = true
        apostws.loadWithOverviewMode = true
        apostws.allowFileAccess = true
        apostws.domStorageEnabled = true
        apostws.builtInZoomControls = true
        apostws.displayZoomControls = false
        apostws.useWideViewPort = true
        apostws.setSupportZoom(true)
        apostws.userAgentString = apostws.userAgentString.replace("; wv", "")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        apostwv.saveState(outState)
    }

    inner class MyChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            filePathCallback = filePath
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            startActivityForResult(intent, REQUEST_CODE)
            return true
        }


        private var apostCustomView: View? = null
        private var apostCustomViewCallback: CustomViewCallback? = null
        private var apostOriginalOrientation = 0
        private var apostOriginalSystemUiVisibility = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (apostCustomView == null) {
                null
            } else BitmapFactory.decodeResource(
                this@ApostActivity.applicationContext.resources,
                2130837573
            )
        }

        override fun onHideCustomView() {
            (this@ApostActivity.window.decorView as FrameLayout).removeView(apostCustomView)
            apostCustomView = null
            this@ApostActivity.window.decorView.systemUiVisibility = apostOriginalSystemUiVisibility
            this@ApostActivity.requestedOrientation = apostOriginalOrientation
            apostCustomViewCallback!!.onCustomViewHidden()
            apostCustomViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?
        ) {
            if (apostCustomView != null) {
                onHideCustomView()
                return
            }
            apostCustomView = paramView
            apostOriginalSystemUiVisibility = this@ApostActivity.window.decorView.systemUiVisibility
            apostOriginalOrientation = this@ApostActivity.requestedOrientation!!
            apostCustomViewCallback = paramCustomViewCallback
            (this@ApostActivity.window.decorView as FrameLayout).addView(
                apostCustomView,
                FrameLayout.LayoutParams(-1, -1)
            )
            this@ApostActivity.window.decorView.systemUiVisibility =
                3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQUEST_CODE) {
            filePathCallback!!.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode,
                    intent
                )
            )
            filePathCallback = null
        }
    }
}