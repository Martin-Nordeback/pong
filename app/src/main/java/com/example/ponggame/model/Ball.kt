package com.example.ponggame.model

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

class Ball (context: Context, var posX: Float, var posY: Float, var size: Float, var speedX: Float, var speedY: Float) {

    val paint = Paint()

    // LH

    fun update(){
        posY += speedY
        posX += speedX
    }


    fun draw (canvas: Canvas?){
        canvas?.drawCircle(posX,posY,size,paint)

    }


    fun checkBounds(bounds: Rect){
        if(posX-size < bounds.left){
            this.speedX *= -1
        }
        if(posX+size < bounds.right){
            this.speedX *= -1
        }
        if(posY-size < bounds.top){
            this.speedX *= -1
        }
        if(posY+size < bounds.bottom){
            this.speedX *= -1
        }
    }

}