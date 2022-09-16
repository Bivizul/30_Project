package aaa.bivizul.a30project.android

import aaa.bivizul.a30project.ui.Root.RootComponent
import aaa.bivizul.a30project.ui.Root.SetRoot
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = RootComponent(componentContext = defaultComponentContext())

        setContent {
            SetRoot(root)
        }
    }
}

