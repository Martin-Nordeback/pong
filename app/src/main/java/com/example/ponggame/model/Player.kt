package com.example.ponggame.model


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.WindowInsetsAnimation.Bounds

class Player (context: Context, var posX: Float, var posY: Float, var size:Float, var speedX:Float, var speedY: Float,){
    var paint = Paint()

    fun update(speedAdjustment: Float){ // använda fingret eller nåt anat // update() is like setter
        posY += speedY * speedAdjustment// posY = posY + speedY // posY += speed same same
        posX += speedX * speedAdjustment


    }

    fun draw( canvas: Canvas?){ // this canvas draws the ball continuously. this can be null.
        canvas?.drawCircle(posX,posY,size,paint) // drew() gets  brings the positions and send it to canvas. it is like getter
    }
    fun checkBounds(bounds: Rect){

        if (posX-size < 0){   //  can be written bounds.left

            //  this.posX += speedX*2 // this is to make sure it doesn't go away

            this.speedX *= -1
        }
        if (posX+size > bounds.right){
            this.speedX *= -1
        }
        if (posY-size < bounds.top){
            this.speedY *= -1
        }
        if (posY+size > bounds.bottom){
            this.speedY *= -1
        }



    }
// Player first commit failed due to token
    // repeated fail to commit
    //let's see

  //comment for push request


}