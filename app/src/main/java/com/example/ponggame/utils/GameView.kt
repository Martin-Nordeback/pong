package com.example.ponggame.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.ponggame.model.Ball
import com.example.ponggame.ui.PongActivity
import java.lang.System.currentTimeMillis
import kotlin.concurrent.thread

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback, Runnable {
//martins gren
    private var score = 0
    private var thread: Thread? = null
    private var running = false
    lateinit var canvas: Canvas

    private lateinit var ball1: Ball

    var pActivity = context as PongActivity
    private var bounds = Rect()

    var mHolder: SurfaceHolder? = holder

    var frameRate = 30
    var deltaTime = 0L
    var timeToUpdate = currentTimeMillis()


    init {
        if (mHolder != null) {
            mHolder?.addCallback(this)
        }
        setup()
    }

    fun setup() {
        ball1 = Ball(this.context, 100f, 100f, 50f, 7f, 5f)
        ball1.paint.color = Color.WHITE

    }

    fun start() {
        running = true
        thread = Thread(this)
        thread?.start()
    }

    fun stop() {
        running = false
        try {
            thread?.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun update(speedAdjustment: Float) {
        ball1.update(speedAdjustment)
    }

    fun draw() {
        canvas = mHolder!!.lockCanvas()
        canvas.drawColor(Color.BLACK)
        ball1.draw(canvas)
        mHolder!!.unlockCanvasAndPost(canvas)

    }

    fun intersects(b1: Ball) {
        if (Math.sqrt(
                Math.pow(b1.posX.toDouble(), 2.0)
                        + Math.pow(b1.posY - b1.posY.toDouble(), 2.0)
            ) <= b1.size
        ) {
            bounceBall(b1)
            score ++
            //pActivity.updateText("Score: $score")
        }
    }

    fun bounceBall(b1: Ball) {
        b1.speedY *= -1
        //b2.speedX = 0f
        ball1.paint.color = Color.YELLOW

    }


    override fun surfaceCreated(p0: SurfaceHolder) {
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        stop()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    override fun run() {
        while (running) {
            if (currentTimeMillis() >= timeToUpdate) {
                deltaTime = currentTimeMillis() - timeToUpdate
                timeToUpdate += 1000 / frameRate

                val speedAdjustment = 1f + deltaTime * frameRate / 1000


                update(speedAdjustment)
                draw()
                intersects(ball1)
                ball1.checkBounds(bounds)
            }

        }

    }
}


