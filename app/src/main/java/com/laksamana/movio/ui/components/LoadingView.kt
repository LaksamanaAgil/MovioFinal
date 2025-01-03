package com.laksamana.movio.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingView(modifier: Modifier = Modifier,isLoading:Boolean) { //TODO: Function untuk tampilan loading halaman
    AnimatedVisibility(
        isLoading,
        enter = fadeIn() + expandVertically() //TODO: Efek visual untuk tampilan loading
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth()) //TODO: Indikator loading yang digunakan berupa garis linear progress bar
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.primary.copy(
                    alpha = .3f
                )
            ) { }
        }
    }
}