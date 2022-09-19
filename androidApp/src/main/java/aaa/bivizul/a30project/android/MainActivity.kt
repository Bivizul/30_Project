package aaa.bivizul.a30project.android

import aaa.bivizul.a30project.data.apostutil.checkApostnet
import aaa.bivizul.a30project.data.apostutil.getApostdlg
import aaa.bivizul.a30project.ui.MyApplicationTheme
import aaa.bivizul.a30project.ui.apostwidget.Apostibl
import aaa.bivizul.a30project.ui.apostwidget.TransparentSystemBars
import aaa.bivizul.a30project.ui.root.RootComponent
import aaa.bivizul.a30project.ui.root.RootContent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (checkApostnet(this)) {
            val root = RootComponent(
                componentContext = defaultComponentContext(),
                context = this@MainActivity
            )
            setContent {
                MyApplicationTheme {
                    TransparentSystemBars()
                    Apostibl()
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .navigationBarsPadding()
                            .systemBarsPadding(),
                    ) {
                        RootContent(root)
                    }
                }
            }
        } else {
            getApostdlg(this)
        }
    }
}

