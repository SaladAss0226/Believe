package com.example.believe

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.golden72.backpack.BackpackAdapter
import com.example.golden72.backpack.MyPackage
import kotlinx.android.synthetic.main.activity_cemetery.*

object publicFunction {
    fun putIn(item: MyPackage, imgv: View){
        BackpackAdapter.unAssignList.add(item)
        imgv.visibility = View.GONE
    }

    //浮出文字敘述
    fun animate_tv_011(tv:TextView){
        var animator = ObjectAnimator.ofFloat(tv,"alpha",0f,1f,1f)
            .apply {
                duration = 4000
                interpolator = LinearInterpolator()
                start()
            }
    }
    //文字浮出又消失
    fun animate_tv_010(tv:TextView){
        var animator = ObjectAnimator.ofFloat(tv,"alpha",0f,1f,0f)
            .apply {
                duration = 4000
                interpolator = LinearInterpolator()
                start()
            }
    }

    //浮出圖片
    fun animate_imgv_011(imgv:ImageView){
        var animator = ObjectAnimator.ofFloat(imgv,"alpha",0f,1f,1f)
            .apply {
                duration = 4000
                interpolator = LinearInterpolator()
                start()
            }
    }
    //浮出圖片又消失
    fun animate_imgv_010(imgv:ImageView){
            var animator = ObjectAnimator.ofFloat(imgv,"alpha",0f,1f,0f)
                .apply {
                    duration = 4000
                    interpolator = LinearInterpolator()
                    start()
                }
    }

    //浮出按鈕
    fun animate_btn_011(btn:Button){
        var animator = ObjectAnimator.ofFloat(btn,"alpha",0f,1f,1f)
            .apply {
                duration = 4000
                interpolator = LinearInterpolator()
                start()
            }
    }




    //閃爍文字
    fun animate_tv_010_repeat(tv: TextView){
        var animator = ObjectAnimator.ofFloat(tv,"alpha",0f,1f,0f)
            .apply {
                duration = 4000
                interpolator = LinearInterpolator()
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.RESTART
                start()
            }
    }

    //閃爍圖片
    fun animate_imgv_010_repeat(imgv: ImageView){
        var animator = ObjectAnimator.ofFloat(imgv,"alpha",0f,1f,0f)
            .apply {
                duration = 2000
                interpolator = LinearInterpolator()
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.RESTART
                start()
            }
    }
}