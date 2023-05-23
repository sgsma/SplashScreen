package com.example.splashscreenjetpack

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        val scale = remember {
            androidx.compose.animation.core.Animatable(initialValue = 0.0f)
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(durationMillis = 850, easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
            )
            delay(2000)
            navController.popBackStack()
            navController.navigate(Screen.Main)

        }
        Image(
            painter = painterResource(id = R.drawable.sharp_movie_filter_black_20),
            contentDescription = "Logo",
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(45.dp)
                .scale(scale.value)
        )
        Text(
            text = "My App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(90.dp)

        )
    }
}
