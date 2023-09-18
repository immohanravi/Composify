package com.mohanravi.composifylib

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 *  This is mohan created this composable by the reading the blog tutorial, link is given below
 * @author Ruthwik
 * @author https://ruthwikkk.medium.com/animate-borders-in-jetpack-compose-ca359deed7d5
 * @modified by Mohan Ravi
 */
@Composable
fun CardWithAnimatedBorder(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(20.dp),
    borderColors: List<Color> = emptyList(),
    onCardClick: () -> Unit = {},
    borderRadius: Dp = 2.dp,
    content: @Composable () -> Unit,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle by
    infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec =
        infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val brush =
        if (borderColors.isNotEmpty()) Brush.sweepGradient(borderColors)
        else Brush.sweepGradient(listOf(Color.Gray, Color.White))

    Surface(modifier = modifier.clickable { onCardClick() }, shape = shape) {
        Surface(
            modifier =
            Modifier
                .clipToBounds()
                .fillMaxWidth()
                .padding(borderRadius)
                .drawWithContent {
                    rotate(angle) {
                        drawCircle(
                            brush = brush,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    drawContent()
                },
            //color = MaterialTheme.colorScheme.background,
            shape = shape
        ) {
            Box{ content() }
        }
    }
}