package aaa.bivizul.a30project.android

import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTOSAI
import android.app.Application
import com.onesignal.OneSignal

class A30PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(APOSTOSAI)
    }

}