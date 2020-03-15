package com.example.believe.Restaurant

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.believe.MainActivity
import com.example.believe.R
import com.example.believe.publicFunction
import kotlinx.android.synthetic.main.activity_cemetery.*
import kotlinx.android.synthetic.main.activity_restaurant.*
import kotlinx.android.synthetic.main.activity_restaurant.tv_next

class RestaurantActivity : AppCompatActivity() {

    var story = 0
    lateinit var bgm_crowd_talking: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        bgm_crowd_talking = MediaPlayer.create(this,R.raw.crowd_talking)     //載入音樂檔(需要時間)

        tv_time_restaurant.visibility = View.VISIBLE
        publicFunction.animate_tv_010(tv_time_restaurant)

        Thread {
            Thread.sleep(5000)
            runOnUiThread {
                imgv_restaurant.visibility = View.VISIBLE
                publicFunction.animate_imgv_011(imgv_restaurant)

                tv_p3_story.visibility = View.VISIBLE
                publicFunction.animate_tv_011(tv_p3_story)

                tv_next.visibility = View.VISIBLE
                publicFunction.animate_tv_011(tv_next)

                imgv_p03_arrow.visibility = View.VISIBLE
                publicFunction.animate_imgv_010_repeat(imgv_p03_arrow)


            }
        }.start()

        tv_next.setOnClickListener {
            when(story){
                0 -> goOn(R.string.p03_1)
                1 -> goOn(R.string.p03_2)
                2 -> goOn(R.string.p03_3)
                3 -> goOn(R.string.p03_4)
                4 -> goOn(R.string.p03_5)
                5 -> goOn(R.string.p03_6)
                6 -> goOn(R.string.p03_7)
                7 -> goOn(R.string.p03_8)
                8 -> goOn(R.string.p03_9)
                9 -> goOn(R.string.p03_10)
                10 -> goOn(R.string.p03_11)
                11 -> goOn(R.string.p03_12)
                12 ->goOn(R.string.p03_13)
                13 ->{
                    //逃出餐廳
                }




            }
        }


    }

    private fun goOn(s:Int) {
        story++
        tv_p3_story.setText(s)
        publicFunction.animate_tv_011(tv_p3_story)
    }

    override fun onResume() {
        super.onResume()
        bgm_crowd_talking.start()
        bgm_crowd_talking.isLooping = true


    }
}
