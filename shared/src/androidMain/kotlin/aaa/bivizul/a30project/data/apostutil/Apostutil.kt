@file:Suppress("DEPRECATION")

package aaa.bivizul.a30project.data.apostutil

import aaa.bivizul.a30project.data.apostutil.Apostcon.APOSTACTIVITY
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import com.onesignal.OneSignal
import java.text.SimpleDateFormat
import java.util.*

actual fun getApostmm(): String {
    val manfacapost = android.os.Build.MANUFACTURER
    val modelapost = android.os.Build.MODEL
    return "$manfacapost $modelapost"
}

actual fun getApostsim(apostcon: Any): String {
    val context = apostcon as Context
    val telmanapost = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanapost.simCountryIso
}

actual fun getApostid(apostcon: Any): String {
    val context = apostcon as Context
    val sharedPreferences = context.getSharedPreferences("appprefapost", Context.MODE_PRIVATE)
    var apostid = sharedPreferences.getString("apost_key", "noapost") ?: "noapost"
    if (apostid == "noapost") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        apostid = datetime + randomNum
        sharedPreferences.edit().putString("apost_key", apostid).apply()
    }
    return apostid
}

actual fun getApostl(): String {
    return Locale.getDefault().language
}

actual fun getApostt(): String {
    val tzapost = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT)
    var zoneapost = "00:00"
    if (tzapost.length > 3) {
        zoneapost = tzapost.substring(3)
    }
    return zoneapost
}

actual fun getApostdlg(apostcon: Any, apostact: Any) {
    val context = apostcon as Context
    val activity = apostact as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Error connect with server")
        setMessage("Please exit the app and try again later")
        setPositiveButton("Exit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

actual fun checkApostnet(apostcon: Any): Boolean {
    val context = apostcon as Context
    val conmanapost =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfapost = conmanapost.activeNetworkInfo
    return netinfapost != null && netinfapost.isConnected
}

actual fun sigApostoff() {
    OneSignal.disablePush(true)
}

actual fun getApostActivity(apostact: Any, aposturl: String) {
    val activity = apostact as Activity
    val a = Class.forName(APOSTACTIVITY)
    val intent = Intent(activity, a)
    val put = intent.putExtra(Apostcon.APOSTKOR, aposturl)
    activity.startActivity(put)
}