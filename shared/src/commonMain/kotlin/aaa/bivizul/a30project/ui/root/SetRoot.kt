package aaa.bivizul.a30project.ui.root

import aaa.bivizul.a30project.ui.MyApplicationTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SetRoot(
    root: RootComponent
) {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            RootContent(root)
        }
    }
}
