package com.example.believe.BeachActivity

import android.animation.ObjectAnimator
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.believe.R
import com.example.believe.publicFunction
import kotlinx.android.synthetic.main.activity_beach.*
import kotlinx.android.synthetic.main.activity_cemetery.*

class BeachActivity : AppCompatActivity() {

    lateinit var bgm_enchantress: MediaPlayer
    var count = 1


    val timer_describe = object : CountDownTimer(100000,5000){

        override fun onFinish() {

//            var animator_words = ObjectAnimator.ofFloat(tv_begining_describe, "alpha", 1f, 0f, 0f)
//                .apply {
//                    duration = 2000
//                    interpolator = LinearInterpolator()
//                    start()
//                }
        }
        override fun onTick(millisUntilFinished: Long) {

            publicFunction.animate_tv_010(tv_center_beach)
            publicFunction.animate_tv_011(tv_p10_story)



            if(count==1) {
                tv_center_beach.visibility = View.VISIBLE
                tv_center_beach.setText(R.string.p10_1)
                count++
            }
            else if(count==2){
                tv_center_beach.setText(R.string.p10_2)
                count++
            }
            else if(count==3){

                //浮現旁白
                tv_center_beach.setText(R.string.p10_3)
                tv_center_beach.setTextColor(Color.parseColor("#ECB86B"))
                count++
            }
            else if(count==4){
                tv_center_beach.setText(R.string.p10_4)
                count++
            }
            else if(count==5){
                //馬克斯
                tv_center_beach.setTextColor(Color.parseColor("#5CB0D6"))
                tv_center_beach.setText(R.string.p10_5)
                count++
            }
            else if(count==6){
                //馬克斯
                tv_center_beach.setText(R.string.p10_5_1)
                count++
            }
            else if(count==7){
                //馬克斯
                tv_center_beach.setText(R.string.p10_5_2)
                count++
            }
            else if(count==8){
                //浮現旁白
                tv_center_beach.setTextColor(Color.parseColor("#ECB86B"))
                tv_center_beach.setText(R.string.p10_6)
                count++
            }
            else if(count==9){
                //馬克斯
                tv_center_beach.setTextColor(Color.parseColor("#5CB0D6"))
                tv_center_beach.setText(R.string.p10_7)
                count++
            }
            else if(count==10){
                tv_center_beach.setTextColor(Color.parseColor("#ECB86B"))
                tv_center_beach.setText(R.string.p10_8)

                //浮現阿芙拉眼睛
                gif_wink_afura.visibility = View.VISIBLE
                publicFunction.animate_imgv_010(gif_wink_afura)
                count++
            }
            else if(count==11){
                tv_center_beach.setTextColor(Color.parseColor("#5CB0D6"))
                tv_center_beach.setText(R.string.p10_9)

                //浮現馬克斯眼睛
                gif_wink_max.visibility = View.VISIBLE
                publicFunction.animate_imgv_010(gif_wink_max)
                count++
            }
            else if(count==12){
                tv_center_beach.setTextColor(Color.parseColor("#ECB86B"))
                tv_center_beach.setText(R.string.p10_10)

                //浮現阿芙拉眼睛
                gif_wink_afura.visibility = View.VISIBLE
                publicFunction.animate_imgv_010(gif_wink_afura)
                count++
            }
            else if(count==13){
                tv_center_beach.setTextColor(Color.parseColor("#5CB0D6"))
                tv_center_beach.setText(R.string.p10_11)

                //浮現馬克斯眼睛
                gif_wink_max.visibility = View.VISIBLE
                publicFunction.animate_imgv_010(gif_wink_max)
                count++
            }
            else if(count==14){
                //旁白
                tv_center_beach.setTextColor(Color.parseColor("#ECB86B"))
                tv_center_beach.setText(R.string.p10_12)
                count++
            }
            else if(count==15){
                //馬克斯
                tv_center_beach.setTextColor(Color.parseColor("#5CB0D6"))
                tv_center_beach.setText(R.string.p10_13)
                count++
            }
            else if(count==16){
                //旁白
                tv_center_beach.setTextColor(Color.parseColor("#ECB86B"))
                tv_center_beach.setText(R.string.p10_14)
                count++
            }
            else if(count==17){
                //惡魔
                tv_center_beach.setTextColor(Color.parseColor("#ff0000"))
                tv_center_beach.setText(R.string.p10_15)
                count++
            }
            else if(count==18){
                tv_center_beach.setTextColor(Color.parseColor("#ECB86B"))
                tv_center_beach.setText(R.string.p10_16)

                //浮現阿芙拉眼睛
                gif_wink_afura.visibility = View.VISIBLE
                publicFunction.animate_imgv_010(gif_wink_afura)
                count++
            }
            else if(count==19){
                tv_center_beach.setTextColor(Color.parseColor("#5CB0D6"))
                tv_center_beach.setText(R.string.p10_17)

                //浮現馬克斯眼睛
                gif_wink_max.visibility = View.VISIBLE
                publicFunction.animate_imgv_010(gif_wink_max)
                count++
            }
            else if(count==20){
                //惡魔
                tv_center_beach.setTextColor(Color.parseColor("#ff0000"))
                tv_center_beach.setText(R.string.p10_18)

                //浮現惡魔眼睛
                gif_wink_devil.visibility = View.VISIBLE
                var animator = ObjectAnimator.ofFloat(gif_wink_devil,"alpha",0f,1f,0f)
                    .apply {
                        duration = 2000
                        interpolator = LinearInterpolator()
                        start()
                    }
            }


        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beach)


        //先閃時間
        publicFunction.animate_tv_010(tv_time_beach)

        Thread {
            Thread.sleep(5000)
            runOnUiThread {
                timer_describe.start()
            }
        }.start()

        bgm_enchantress = MediaPlayer.create(this,R.raw.enchantress)     //載入音樂檔(需要時間)

    }


    override fun onResume() {
        super.onResume()
        bgm_enchantress.start()
        bgm_enchantress.isLooping = true


    }
}
