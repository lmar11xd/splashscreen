package com.lmar.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.lmar.splashscreen.models.Screen
import com.lmar.splashscreen.utils.Metrics

class PresentationActivity : AppCompatActivity() {

    private lateinit var logo: ImageView
    private lateinit var appName: ImageView
    private lateinit var splashImg: ImageView
    private lateinit var lottieAnimationView: LottieAnimationView

    private lateinit var screenInfo: Screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)

        screenInfo = Metrics().getScreenInfo(applicationContext)
        Log.d("SCREEN", screenInfo.toString())

        logo = findViewById(R.id.logo)
        appName = findViewById(R.id.app_name)
        splashImg = findViewById(R.id.img)
        lottieAnimationView = findViewById(R.id.lottie)
    }

    override fun onStart() {
        super.onStart()
        var imgHeight = 900 * screenInfo.density
        var logoHeight = 100 * screenInfo.density
        var appnameHeight = 50 * screenInfo.density

        //layout_constraintVertical_bias of logo is 0.1
        var constY = screenInfo.height * 0.1

        //img height is 900dp in XML
        //Desplazamiento de splashImg
        var delta: Float = imgHeight - screenInfo.height
        var fondoDy: Float = -1 * (screenInfo.height * 0.30 + delta).toFloat()

        //logo height is 100dp in XML
        //Desplazamiento del logo
        var logoDy: Float = (screenInfo.height * 0.60 - (logoHeight / 2) + 6 * screenInfo.density).toFloat()

        //appname height is 50dp in XML
        var appnameDy: Float = (screenInfo.height - (constY + logoHeight) - appnameHeight - 10 * screenInfo.density).toFloat()

        splashImg.animate().translationY(fondoDy).setDuration(1000).setStartDelay(4000)
        logo.animate().translationY(logoDy).setDuration(1000).setStartDelay(4000)
        appName.animate().translationY(appnameDy).setDuration(1000).setStartDelay(4000)
        lottieAnimationView.animate().translationY(appnameDy).setDuration(1000).setStartDelay(4000)

        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            Log.d("ANIMATE IMG", "x: ${splashImg.x} - y: ${splashImg.y}")
            Log.d("ANIMATE LOGO", "x: ${logo.x} - y: ${logo.y}")
            Log.d("ANIMATE NAME", "x: ${appName.x} - y: ${appName.y}")
            Log.d("ANIMATE LOTTIE", "x: ${lottieAnimationView.x} - y: ${lottieAnimationView.y}")
            // Start your app main activity
            val i = Intent(this@PresentationActivity, MainActivity::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, 7000)
    }
}