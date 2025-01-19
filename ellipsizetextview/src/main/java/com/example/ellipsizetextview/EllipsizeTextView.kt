package com.example.ellipsizetextview

import android.content.Context
import android.graphics.Canvas
import android.text.TextUtils
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class EllipsizeTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        val paint = paint
        paint.color = currentTextColor
        paint.textSize = textSize

        val maxWidth = width - paddingLeft - paddingRight
        val lines = text.split("\n")
        var yOffset = paddingTop

        for (line in lines) {
            val ellipsized = TextUtils.ellipsize(line, paint, maxWidth.toFloat(), TextUtils.TruncateAt.END).toString()
            canvas.drawText(ellipsized, paddingLeft.toFloat(), yOffset + paint.textSize, paint)
            yOffset += lineHeight

            if (yOffset > height - paddingBottom) break // Stop drawing if it exceeds view bounds
        }
    }
}
