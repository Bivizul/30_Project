package aaa.bivizul.a30project.ui.apostwidget

import aaa.bivizul.a30project.data.apostutil.Apostcon
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
actual fun Apostibl() {

    val orientation = LocalConfiguration.current.orientation
    val imageBack = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> Apostcon.APOSTBV
        else -> Apostcon.APOSTBH
    }

//    GlideImage(
//        imageModel = imageBack,
//        imageOptions = ImageOptions(
//            contentScale = ContentScale.Crop,
//            alignment = Alignment.Center
//        )
//    )

}