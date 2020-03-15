package com.example.believe.CemeteryActivity

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.believe.MainActivity.Companion.bgm_begining
import com.example.believe.R
import com.example.believe.Restaurant.RestaurantActivity
import com.example.believe.backpack.BackpackActivity
import com.example.believe.publicFunction
import kotlinx.android.synthetic.main.activity_cemetery.*

class CemeteryActivity : AppCompatActivity() {

    var count = 1
    var status = 0

    val begining_describe = object : CountDownTimer(32000,4000){

        override fun onFinish() {

            var animator_words = ObjectAnimator.ofFloat(tv_begining_describe, "alpha", 1f, 0f, 0f)
                    .apply {
                        duration = 2000
                        interpolator = LinearInterpolator()
                        start()
                    }

            Thread {
                Thread.sleep(2000)
                runOnUiThread {
                    tv_time.visibility = View.VISIBLE
                    publicFunction.animate_tv_010(tv_time)
                }
            }.start()

            Thread {
                Thread.sleep(6000)
                runOnUiThread {
                    imgv_cemetery.visibility = View.VISIBLE
                    publicFunction.animate_imgv_011(imgv_cemetery)

                }
            }.start()

            Thread{
                Thread.sleep(7000)
                runOnUiThread {
                    tv_p2_story.visibility = View.VISIBLE
                    tv_next.visibility = View.VISIBLE
                    imgv_p02_arrow.visibility = View.VISIBLE
                    btn_backpack.visibility = View.VISIBLE

                    publicFunction.animate_btn_011(btn_backpack)
                    publicFunction.animate_tv_011(tv_p2_story)
                    publicFunction.animate_tv_011(tv_next)
                    publicFunction.animate_imgv_010_repeat(imgv_p02_arrow)

                }
            }.start()

        }
        override fun onTick(millisUntilFinished: Long) {

            if(count==1) {
                tv_begining_describe.setText(R.string.p01_1)
                count++
            }
            else if(count==2){
                tv_begining_describe.setText(R.string.p01_2)
                count++
            }
            else if(count==3){
                tv_begining_describe.setText(R.string.p01_3)
                count++
            }
            else if(count==4){
                tv_begining_describe.setText(R.string.p01_4)
                count++
            }
            else if(count==5){
                tv_begining_describe.setText(R.string.p01_5)
                count++
            }
            else if(count==6){
                tv_begining_describe.setText(R.string.p01_6)
                count++
            }
            else if(count==7){
                tv_begining_describe.setText(R.string.p01_7)
                count++
            }
            else if(count==8){
                tv_begining_describe.setTextColor(Color.parseColor("#FF0000"))
                tv_begining_describe.setText(R.string.p01_8)
                count++
            }

            publicFunction.animate_tv_010(tv_begining_describe)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cemetery)

        begining_describe.start()

        btn_backpack.setOnClickListener {
            startActivity(Intent(this, BackpackActivity::class.java))
            bgm_begining.pause()
        }

        tv_next.setOnClickListener {
            when(status){
                0 ->{
                    status++
                    tv_p2_story.setText(R.string.p02_2)
                    publicFunction.animate_tv_011(tv_p2_story)
                }
                1 ->{
                    status++
                    tv_p2_story.setText(R.string.p02_3)
                    publicFunction.animate_tv_011(tv_p2_story)
                }
                2 ->{
                    status++
                    tv_p2_story.setText(R.string.p02_4)
                    publicFunction.animate_tv_011(tv_p2_story)
                }
                3 ->{
                    status++
                    tv_p2_story.setText(R.string.p02_5)
                    publicFunction.animate_tv_011(tv_p2_story)
//                    imgv_cemetery.setImageResource(R.drawable.friends_diving)
//                    publicFunction.animate_imgv_011(imgv_cemetery)
                }
                4 ->{
                    startActivity(Intent(this,RestaurantActivity::class.java))
                    bgm_begining.release()
                }


            }

        }




    }

    override fun onResume() {
        super.onResume()
        bgm_begining.start()
        bgm_begining.isLooping = true


    }
}

