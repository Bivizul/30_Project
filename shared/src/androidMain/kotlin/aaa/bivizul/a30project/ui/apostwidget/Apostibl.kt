package aaa.bivizul.a30project.ui.apostwidget

import aaa.bivizul.a30project.data.apostutil.Apostcon
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@Composable
actual fun Apostibl() {

    val orientation = LocalConfiguration.current.orientation
    val imageModel = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> Apostcon.APOSTBV
        else -> Apostcon.APOSTBH
    }

    CoilImage(
        imageModel = imageModel,
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    )

}