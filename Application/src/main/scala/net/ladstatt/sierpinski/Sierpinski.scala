package net.ladstatt.sierpinski

// TODO
// implement here all domain logic
// Pos / Triangle / Sierpinski

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color


class Triangle(canv:Canvas){
  val paint = new Paint()
  paint.setColor(Color.WHITE)

  val depth = 7
  val x = canv.getWidth
  val y = Math.sqrt(x*x-x/2*x/2).toFloat

  var xA = 0
  var yA = y
  var xB = x/2
  var yB = 0
  var xC = x
  var yC = y

  def drawTriangle():Unit = {
    canv.drawLines(Array(xA, yA, xB, yB, xB, yB, xC, yC, xC, yC, xA, yA), paint)
    drawSub(depth, (xA + xB)/2, (yA + yB)/2, (xA + xC)/2, (yA + yC)/2, (xB + xC)/2, (yB + yC)/2)
  }

  def drawSub(depth:Int, xA:Float, yA:Float, xB:Float, yB:Float, xC:Float, yC:Float):Unit= {
    if (depth > 0) {
      canv.drawLines(Array(xA, yA, xB, yB, xB, yB, xC, yC, xC, yC, xA, yA),paint)
      val newDepth = depth -1
      drawSub(newDepth, (xA + xB)/2 + (xB - xC)/2, (yA + yB)/2 + (yB - yC)/2, (xA + xB)/2 + (xA - xC)/2, (yA + yB)/2 + (yA - yC)/2, (xA + xB)/2, (yA + yB)/2)
      drawSub(newDepth, (xC + xB)/2 + (xB - xA)/2, (yC + yB)/2 + (yB - yA)/2, (xC + xB)/2 + (xC - xA)/2, (yC + yB)/2 + (yC - yA)/2, (xC + xB)/2, (yC + yB)/2)
      drawSub(newDepth, (xA + xC)/2 + (xC - xB)/2, (yA + yC)/2 + (yC - yB)/2, (xA + xC)/2 + (xA - xB)/2, (yA + yC)/2 + (yA - yB)/2, (xA + xC)/2, (yA + yC)/2)
    }
  }

}

