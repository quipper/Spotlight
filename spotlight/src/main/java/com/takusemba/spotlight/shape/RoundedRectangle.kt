package com.takusemba.spotlight.shape

import android.animation.TimeInterpolator
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import android.view.animation.DecelerateInterpolator
import java.util.concurrent.TimeUnit

/**
 * [Shape] of RoundedRectangle with customizable height, width, and radius.
 */
class RoundedRectangle @JvmOverloads constructor(
    override val height: Float,
    override val width: Float,
    private val radius: Float,
    override val type :Shape.ShapeType = Shape.ShapeType.ROUNDED_RECTANGLE,
    override val duration: Long = DEFAULT_DURATION,
    override val interpolator: TimeInterpolator = DEFAULT_INTERPOLATOR,
    override var clickable: Boolean = true
) : Shape {

  override fun draw(canvas: Canvas, point: PointF, value: Float, paint: Paint) {
    val halfWidth = width / 2 * value
    val halfHeight = height / 2 * value
    val left = point.x - halfWidth
    val top = point.y - halfHeight
    val right = point.x + halfWidth
    val bottom = point.y + halfHeight
    val rect = RectF(left, top, right, bottom)
    canvas.drawRoundRect(rect, radius, radius, paint)
  }

  companion object {

    val DEFAULT_DURATION = TimeUnit.MILLISECONDS.toMillis(500)

    val DEFAULT_INTERPOLATOR = DecelerateInterpolator(2f)
  }
}

