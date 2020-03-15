package com.example.believe

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.believe.BeachActivity.BeachActivity
import com.example.believe.CemeteryActivity.CemeteryActivity
import com.example.believe.Restaurant.RestaurantActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var bgm_begining: MediaPlayer
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bgm_begining = MediaPlayer.create(this,R.raw.emerald_princess_original)     //載入音樂檔(需要時間)

        bgm_begining.start()

        publicFunction.animate_tv_010_repeat(tv_get_start)

        tv_get_start.setOnClickListener {
            startActivity(Intent(this, CemeteryActivity::class.java))
        }


        //快速旅行
        btn_skip_toRestaurant.setOnClickListener {
            startActivity(Intent(this,RestaurantActivity::class.java))
            bgm_begining.release()
        }


        btn_skip_toBeach.setOnClickListener {
            startActivity(Intent(this, BeachActivity::class.java))
            bgm_begining.release()
        }




    }
}
