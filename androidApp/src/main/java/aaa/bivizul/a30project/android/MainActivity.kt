package aaa.bivizul.a30project.android

import aaa.bivizul.a30project.data.apostutil.checkApostnet
import aaa.bivizul.a30project.data.apostutil.getApostdlg
import aaa.bivizul.a30project.ui.root.RootComponent
import aaa.bivizul.a30project.ui.root.SetRoot
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (checkApostnet(this)) {

            val root = RootComponent(componentContext = defaultComponentContext())

            setContent {
                SetRoot(root)
            }

        } else {
            getApostdlg(this, this)
        }
    }
}

