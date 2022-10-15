package com.lmar.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class PresentationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)

        var logo = findViewById(R.id.logo) as ImageView
        var appName = findViewById(R.id.app_name) as ImageView
        var splashImg = findViewById(R.id.img) as ImageView
        var lottieAnimationView = findViewById(R.id.lottie) as LottieAnimationView

        splashImg.animate().translationY(-1600f).setDuration(1000).setStartDelay(4000)
        logo.animate().translationY(1400f).setDuration(1000).setStartDelay(4000)
        appName.animate().translationY(1400f).setDuration(1000).setStartDelay(4000)
        lottieAnimationView.animate().translationY(1400f).setDuration(1000).setStartDelay(4000)

        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@PresentationActivity, MainActivity::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, 6500)
    }
}